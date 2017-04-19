package com.sbm.core.oms.api;

import com.sbm.core.oms.api.OrderBoardService;
import com.sbm.core.oms.api.OrderBoardServiceFactory;
import com.sbm.core.oms.order.OrderBoard;
import com.sbm.core.oms.order.ParentOrder;
import com.sbm.core.oms.order.cancel.CancelOrderEvent;
import com.sbm.core.oms.order.register.RegisterOrderEventCannedDataTestBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jclinto on 18/04/2017.
 */
public class OrderBoardFeatureTest {

    public static final int SINGLE_ORDER = 1;

    @Test
    public void canRegisterSingleOrderTheCancel() {

        OrderBoardService orderBoardService = OrderBoardServiceFactory.INSTANCE.bootsrapInMemoryConf();

        orderBoardService.registerOrder(new RegisterOrderEventCannedDataTestBuilder().registerOrderA().build());

        OrderBoard orderBoardSnapshot = orderBoardService.getOrderSummary();

        Assert.assertEquals(SINGLE_ORDER, orderBoardSnapshot.rowCount());
        ParentOrder parentOrder = orderBoardSnapshot.firstOrder();
        Assert.assertEquals("3.5 Kg for £306.0", parentOrder.getSummary());

        orderBoardService.cancelOrder(new CancelOrderEvent(parentOrder.getOrderId()));
        orderBoardSnapshot = orderBoardService.getOrderSummary();
        Assert.assertEquals(0, orderBoardSnapshot.rowCount());
    }
}
