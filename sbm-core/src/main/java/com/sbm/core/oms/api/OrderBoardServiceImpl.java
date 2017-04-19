package com.sbm.core.oms.api;

import com.sbm.core.oms.order.cancel.CancelOrderEvent;
import com.sbm.core.oms.order.cancel.CancelOrderHandler;
import com.sbm.core.oms.order.register.RegisterOrderEvent;
import com.sbm.core.oms.order.register.RegisterOrderHandler;
import com.sbm.core.oms.order.summary.GetOrderSummaryHandler;
import com.sbm.core.oms.order.OrderBoard;

public class OrderBoardServiceImpl implements OrderBoardService {

    private final RegisterOrderHandler registerOrderHandler;
    private final GetOrderSummaryHandler getOrderSummaryHandler;
    private final CancelOrderHandler canceOrderHandler;

    public OrderBoardServiceImpl(RegisterOrderHandler registerOrderHandler,
                                 GetOrderSummaryHandler getOrderSummaryHandler,
                                 CancelOrderHandler canceOrderHandler) {
        this.registerOrderHandler = registerOrderHandler;
        this.getOrderSummaryHandler = getOrderSummaryHandler;
        this.canceOrderHandler = canceOrderHandler;
    }

    @Override
    public void registerOrder(RegisterOrderEvent registerOrderEvent) {

        // send through ring buffer or single threaded process

        this.registerOrderHandler.execute(registerOrderEvent);
    }

    @Override
    public OrderBoard getOrderSummary() {

        // send through ring buffer or single threaded process

        return this.getOrderSummaryHandler.execute();
    }

    @Override
    public void cancelOrder(CancelOrderEvent cancelOrderEvent) {

        // send through ring buffer or single threaded process

        this.canceOrderHandler.execute(cancelOrderEvent);
    }
}
