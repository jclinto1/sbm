package com.sbm.core.oms.order.register;

import com.sbm.core.oms.order.Order;
import com.sbm.core.oms.order.OrderBoardManager;
import com.sbm.core.oms.order.OrderFactory;
import com.sbm.core.oms.order.OrderFactoryImpl;

public class RegisterOrderHandlerImpl implements RegisterOrderHandler {

    private final OrderFactory orderFactory;
    private final OrderBoardManager orderBoardManager;

    /**
     * Creates a CancelOrderHandlerImpl that Uses the default {@link OrderFactoryImpl} internally
     * @param orderBoardManager
     */
    public RegisterOrderHandlerImpl(OrderBoardManager orderBoardManager) {
        this(new OrderFactoryImpl(), orderBoardManager);
    }

    public RegisterOrderHandlerImpl(OrderFactory orderFactory, OrderBoardManager orderBoardManager) {
        this.orderFactory = orderFactory;
        this.orderBoardManager = orderBoardManager;
    }

    @Override
    public void execute(RegisterOrderEvent event) {

        Order order = this.orderFactory.from(event);

        // persist order in orderRepository

        this.orderBoardManager.registerOrder(order);
    }
}
