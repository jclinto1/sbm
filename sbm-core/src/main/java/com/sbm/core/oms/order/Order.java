package com.sbm.core.oms.order;

import com.sbm.core.orderboard.Price;

public class Order {

    private final String userId;
    private final double quantity;
    private final Price price;
    private final OrderType orderType;

    public Order(String userId, double quantity, Price price, OrderType orderType) {
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public Price getPrice() {
        return this.price;
    }

    public OrderType getOrderType() {
        return this.orderType;
    }

    public boolean isBUY() {
        return OrderType.BUY == this.orderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (Double.compare(order.quantity, quantity) != 0) return false;
        if (!userId.equals(order.userId)) return false;
        if (!price.equals(order.price)) return false;
        return orderType == order.orderType;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userId.hashCode();
        temp = Double.doubleToLongBits(quantity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + price.hashCode();
        result = 31 * result + orderType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", orderType=").append(orderType);
        sb.append('}');
        return sb.toString();
    }
}
