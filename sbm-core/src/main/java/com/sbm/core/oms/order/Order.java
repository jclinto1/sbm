package com.sbm.core.oms.order;

import com.google.common.collect.Lists;
import com.sbm.core.oms.lang.CurrencyCode;

import java.util.List;

public class Order {

    private final long orderId;
    private final String userId;
    private final double quantity;
    private final double price;
    private final CurrencyCode currencyCode;
    private final OrderType orderType;
    private final List<Order> underlyingOrders = Lists.newArrayList();

    public Order(long orderId, String userId, double quantity, double price, CurrencyCode currencyCode, OrderType orderType) {
        this.orderId = orderId;
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.currencyCode = currencyCode;
        this.orderType = orderType;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", currencyCode=").append(currencyCode);
        sb.append(", orderType=").append(orderType);
        sb.append('}');
        return sb.toString();
    }
}
