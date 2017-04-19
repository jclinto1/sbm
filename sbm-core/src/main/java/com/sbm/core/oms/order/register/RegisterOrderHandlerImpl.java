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

        // place holder for validation logic such as checking the userId is present in the system
        // and has the right limits to place this order

        this.orderBoardManager.registerOrder(order);
    }
}
