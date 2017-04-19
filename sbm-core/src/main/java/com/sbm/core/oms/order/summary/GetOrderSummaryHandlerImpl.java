package com.sbm.core.oms.order.summary;

import com.sbm.core.oms.order.OrderBoard;
import com.sbm.core.oms.order.OrderBoardManager;

public class GetOrderSummaryHandlerImpl implements GetOrderSummaryHandler {

    private final OrderBoardManager orderBoardManager;

    public GetOrderSummaryHandlerImpl(OrderBoardManager orderBoardManager) {
        this.orderBoardManager = orderBoardManager;
    }

    @Override
    public OrderBoard execute() {
        OrderBoard liveOrderBoard = this.orderBoardManager.getOrderBoardSummary();
        return liveOrderBoard;
    }
}
