package com.sbm.core.oms.order.cancel;

import com.sbm.core.oms.order.OrderBoardManager;
import com.sbm.core.oms.order.OrderFactory;
import com.sbm.core.oms.order.OrderFactoryImpl;

public class CancelOrderHandlerImpl implements CancelOrderHandler {

    private final OrderFactory orderFactory;
    private final OrderBoardManager orderBoardManager;

    public CancelOrderHandlerImpl(OrderBoardManager orderBoardManager) {
        this(new OrderFactoryImpl(), orderBoardManager);
    }

    public CancelOrderHandlerImpl(OrderFactory orderFactory, OrderBoardManager orderBoardManager) {
        this.orderFactory = orderFactory;
        this.orderBoardManager = orderBoardManager;
    }

    @Override
    public void execute(CancelOrderEvent event) {
        int hashedParentOrderId = event.getOrderId();
        this.orderBoardManager.cancelOrder(hashedParentOrderId);
    }
}
