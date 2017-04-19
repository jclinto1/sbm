package com.sbm.core.oms.api;

import com.sbm.core.oms.order.*;
import com.sbm.core.oms.order.cancel.CancelOrderHandler;
import com.sbm.core.oms.order.cancel.CancelOrderHandlerImpl;
import com.sbm.core.oms.order.register.RegisterOrderHandler;
import com.sbm.core.oms.order.register.RegisterOrderHandlerImpl;
import com.sbm.core.oms.order.summary.GetOrderSummaryHandler;
import com.sbm.core.oms.order.summary.GetOrderSummaryHandlerImpl;

public enum OrderBoardServiceFactory {

    INSTANCE;

    /**
     * Creates an Order Service class with the default implementations which are in-memory
     * and fine for demo purposed.
     */
    public OrderBoardService bootsrapInMemoryConf() {

        OrderBoard orderBoard = new InMemoryOrderBoard();
        NettedOrderRepository nettedOrderRepository = new InMemoryNettedOrderRepository();
        OrderBoardManager orderBoardManager = new OrderBoardManagerImpl(orderBoard, nettedOrderRepository);

        RegisterOrderHandler registerOrder = new RegisterOrderHandlerImpl(orderBoardManager);
        GetOrderSummaryHandler getOrderSummary = new GetOrderSummaryHandlerImpl(orderBoardManager);
        CancelOrderHandler cancelOrderHandler = new CancelOrderHandlerImpl(orderBoardManager);

        OrderBoardService orderBoardService = new OrderBoardServiceImpl(registerOrder, getOrderSummary, cancelOrderHandler);

        return orderBoardService;
    }
}
