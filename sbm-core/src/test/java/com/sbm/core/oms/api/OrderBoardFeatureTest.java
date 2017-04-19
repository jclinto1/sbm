package com.sbm.core.oms.api;

import org.junit.Test;

/**
 * Created by jclinto on 18/04/2017.
 */
public class OrderBoardFeatureTest {

    public static final int SINGLE_ORDER = 1;

    @Test
    public void canRegisterSingleOrderTheCancel() {

//        OrderBoardService orderBoardService = OrderBoardServiceFactory.INSTANCE.bootsrapInMemoryConf();
//
//        orderBoardService.registerOrder(new OrderTestBuilder().sellOrderA().build());
//
//        OrderBoardSnapshot orderBoardSnapshot = orderBoardService.getOrderSummary();
//
//        Assert.assertEquals(SINGLE_ORDER, orderBoardSnapshot.rowCount());
//        OrderSnapshot orderSnapshot = orderBoardSnapshot.firstOrderOrNull();
//        Assert.assertNotNull(orderSnapshot);
//
//        OrderBoardSnapshot expected = new OrderBoardSnapshotTestBuilder()
//                .build();
//        OrderSnapshot orderSnapshot = expected.firstOrderOrNull();
//
//        Assert.assertEquals(orderSnapshot, orderSnapshot.getOrderId());
//        Assert.assertEquals("3.5 Kg for £306.0", orderSnapshot.getSummary());
//
//        orderBoardService.cancelOrder(new CancelOrderEvent(orderSnapshot.getOrderId()));
//        orderBoardSnapshot = orderBoardService.getOrderSummary();
//        Assert.assertEquals(0, orderBoardSnapshot.rowCount());
    }
}
