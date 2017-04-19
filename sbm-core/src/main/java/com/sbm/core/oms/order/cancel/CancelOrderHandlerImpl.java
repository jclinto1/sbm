package com.sbm.core.oms.order.cancel;

import com.sbm.core.oms.order.OrderBoardManager;

public class CancelOrderHandlerImpl implements CancelOrderHandler {

    private final OrderBoardManager orderBoardManager;

    public CancelOrderHandlerImpl(OrderBoardManager orderBoardManager) {
        this.orderBoardManager = orderBoardManager;
    }

    @Override
    public void execute(CancelOrderEvent event) {
        int hashedParentOrderId = event.getOrderId();
        this.orderBoardManager.cancelOrder(hashedParentOrderId);
    }
}
