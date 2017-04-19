package com.sbm.core.oms.order.register;

import com.sbm.core.oms.order.OrderType;
import com.sbm.core.oms.lang.CurrencyCode;

public class RegisterOrderEvent {

    private final String userId;
    private final double quantity;
    private final int price;
    private final CurrencyCode currencyCode;
    private final OrderType orderType;

    public RegisterOrderEvent(String userId, double quantity, int price, CurrencyCode currencyCode, OrderType orderType) {
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.currencyCode = currencyCode;
        this.orderType = orderType;
    }

    public String getUserId() {
        return userId;
    }

    public double getQuantity() {
        return quantity;
    }

    public int getPrice() {
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
        final StringBuilder sb = new StringBuilder("CancelOrderEvent{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", currencyCode=").append(currencyCode);
        sb.append(", orderType=").append(orderType);
        sb.append('}');
        return sb.toString();
    }
}
