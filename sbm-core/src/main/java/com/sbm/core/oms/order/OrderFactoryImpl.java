package com.sbm.core.oms.order;

import com.sbm.core.oms.lang.CurrencyCode;
import com.sbm.core.oms.order.register.RegisterOrderEvent;

/**
 * Order Factory class which creates orders from events and
 * assigns a generated order ID whose implementation can be
 * optionally provided.
 */
public class OrderFactoryImpl implements OrderFactory {

    private final OrderIdGenerator orderIdGenerator;

    public OrderFactoryImpl() {
        //Defaults to simple order Id generator
        this.orderIdGenerator = new SimpleOrderIdGenerator();
    }

    public OrderFactoryImpl(OrderIdGenerator orderIdGenerator) {
        this.orderIdGenerator = orderIdGenerator;
    }

    @Override
    public Order from(RegisterOrderEvent event) {

        String userId = event.getUserId();
        double quantity = event.getQuantity();
        int price = event.getPrice();
        CurrencyCode currencyCode = event.getCurrencyCode();
        OrderType orderType = event.getOrderType();

        // Here we can in the future add additional fields such as createdDateTime for instance

//        Order order = new Order(
//                userId,
//                quantity,
//                price,
//                currencyCode,
//                orderType);
//
//        return order;

        return null;
    }
}
