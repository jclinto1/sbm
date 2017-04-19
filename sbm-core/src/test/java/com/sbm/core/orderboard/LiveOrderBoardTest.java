package com.sbm.core.orderboard;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LiveOrderBoardTest {

    Order sellOrderA = new OrderTestBuilder().sellOrderA().build();
    Order sellOrderB = new OrderTestBuilder().sellOrderB().build();
    Order sellOrderC = new OrderTestBuilder().sellOrderC().build();
    Order sellOrderD = new OrderTestBuilder().sellOrderD().build();

    Order buyOrderE = new OrderTestBuilder().buyOrderE().build();
    Order buyOrderF = new OrderTestBuilder().buyOrderF().build();
    Order buyOrderG = new OrderTestBuilder().buyOrderG().build();
    Order buyOrderH = new OrderTestBuilder().buyOrderH().build();

    @Test
    public void addSingleOrder() {
        LiveOrderBoard board = new InMemoryLiveOrderBoard();
        board.registerOrder(sellOrderA);
        List<LiveOrder> liveOrders = board.toLadder();
        Assert.assertEquals(1, liveOrders.size());
        LiveOrder orderSummary = liveOrders.get(0);
        Assert.assertEquals("3.5 Kg for £306", orderSummary.getSummary());
    }

    @Test
    public void mergeTwoOrders() {
        LiveOrderBoard board = new InMemoryLiveOrderBoard();
        board.registerOrder(sellOrderA);
        board.registerOrder(sellOrderD);
        List<LiveOrder> liveOrders = board.toLadder();
        Assert.assertEquals(1, liveOrders.size());
        Assert.assertEquals("5.5 Kg for £306", liveOrders.get(0).getSummary());
    }

    @Test
    public void mergesAndSortsSellOrders() {
        LiveOrderBoard board = new InMemoryLiveOrderBoard();
        board.registerOrder(sellOrderB);
        board.registerOrder(sellOrderA);
        board.registerOrder(sellOrderC);
        board.registerOrder(sellOrderD);

        List<LiveOrder> liveOrders = board.toLadder();
        Assert.assertEquals(3, liveOrders.size());

        Assert.assertEquals("5.5 Kg for £306", liveOrders.get(0).getSummary());
        Assert.assertEquals("1.5 Kg for £307", liveOrders.get(1).getSummary());
        Assert.assertEquals("1.2 Kg for £310", liveOrders.get(2).getSummary());
    }

    @Test
    public void mergesAndSortsBuyOrders() {
        LiveOrderBoard board = new InMemoryLiveOrderBoard();
        board.registerOrder(buyOrderE);
        board.registerOrder(buyOrderF);
        board.registerOrder(buyOrderG);
        board.registerOrder(buyOrderH);

        List<LiveOrder> liveOrders = board.toLadder();
        Assert.assertEquals(3, liveOrders.size());

        Assert.assertEquals("2.0 Kg for £406", liveOrders.get(0).getSummary());
        Assert.assertEquals("3.5 Kg for £345", liveOrders.get(1).getSummary());
        Assert.assertEquals("2.7 Kg for £290", liveOrders.get(2).getSummary());
    }

    @Test
    public void sortsSamePricedBuyAndSellOrders() {
        LiveOrderBoard board = new InMemoryLiveOrderBoard();
        board.registerOrder(new OrderTestBuilder().BUY().quantity(1.3).build());
        board.registerOrder(new OrderTestBuilder().SELL().quantity(5.4).build());

        List<LiveOrder> liveOrders = board.toLadder();
        Assert.assertEquals(2, liveOrders.size());

        Assert.assertEquals("5.4 Kg for £300", liveOrders.get(0).getSummary());
        Assert.assertEquals("1.3 Kg for £300", liveOrders.get(1).getSummary());
    }

    @Test
    public void mergesAndSortsBuyAndSellOrdersAndCancels() {
        LiveOrderBoard board = new InMemoryLiveOrderBoard();
        board.registerOrder(buyOrderF);
        board.registerOrder(sellOrderA);
        board.registerOrder(buyOrderH);
        board.registerOrder(sellOrderC);
        board.registerOrder(sellOrderD);
        board.registerOrder(buyOrderE);
        board.registerOrder(sellOrderB);
        board.registerOrder(buyOrderG);

        List<LiveOrder> liveOrders = board.toLadder();
        Assert.assertEquals(6, liveOrders.size());

        Assert.assertEquals("5.5 Kg for £306", liveOrders.get(0).getSummary());
        Assert.assertEquals("1.5 Kg for £307", liveOrders.get(1).getSummary());
        Assert.assertEquals("1.2 Kg for £310", liveOrders.get(2).getSummary());
        Assert.assertEquals("2.0 Kg for £406", liveOrders.get(3).getSummary());
        Assert.assertEquals("3.5 Kg for £345", liveOrders.get(4).getSummary());
        Assert.assertEquals("2.7 Kg for £290", liveOrders.get(5).getSummary());

        Assert.assertTrue(board.cancelOrder(liveOrders.get(1)));

        liveOrders = board.toLadder();
        Assert.assertEquals(5, liveOrders.size());

        Assert.assertEquals("5.5 Kg for £306", liveOrders.get(0).getSummary());
        Assert.assertEquals("1.2 Kg for £310", liveOrders.get(1).getSummary());
        Assert.assertEquals("2.0 Kg for £406", liveOrders.get(2).getSummary());
        Assert.assertEquals("3.5 Kg for £345", liveOrders.get(3).getSummary());
        Assert.assertEquals("2.7 Kg for £290", liveOrders.get(4).getSummary());

        Assert.assertTrue(board.cancelOrder(liveOrders.get(4)));

        liveOrders = board.toLadder();
        Assert.assertEquals(4, liveOrders.size());

        Assert.assertEquals("5.5 Kg for £306", liveOrders.get(0).getSummary());
        Assert.assertEquals("1.2 Kg for £310", liveOrders.get(1).getSummary());
        Assert.assertEquals("2.0 Kg for £406", liveOrders.get(2).getSummary());
        Assert.assertEquals("3.5 Kg for £345", liveOrders.get(3).getSummary());

        Assert.assertTrue(board.cancelOrder(liveOrders.get(0)));

        liveOrders = board.toLadder();
        Assert.assertEquals(3, liveOrders.size());

        Assert.assertEquals("1.2 Kg for £310", liveOrders.get(0).getSummary());
        Assert.assertEquals("2.0 Kg for £406", liveOrders.get(1).getSummary());
        Assert.assertEquals("3.5 Kg for £345", liveOrders.get(2).getSummary());

        Assert.assertTrue(board.cancelOrder(liveOrders.get(0)));
        Assert.assertTrue(board.cancelOrder(liveOrders.get(1)));
        Assert.assertTrue(board.cancelOrder(liveOrders.get(2)));

        liveOrders = board.toLadder();
        Assert.assertEquals(0, liveOrders.size());
    }
}
