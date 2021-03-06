package com.sbm.core.orderboard;

public class HashedOrder {

    private final Order order;
    private final int key;

    public HashedOrder(Order order) {
        this.order = order;
        this.key = hashCodeGroup();
    }

    private int hashCodeGroup() {
        int result = 0;
        result = 31 * result + this.order.price.hashCode();
        result = 31 * result + this.order.orderType.hashCode();
        return result;
    }

    public Price getPrice() {
        return this.order.price;
    }

    public double getQuantity() {
        return this.order.quantity;
    }

    public OrderType getOrderType() {
        return this.order.orderType;
    }

    public int getKey() {
        return this.key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashedOrder that = (HashedOrder) o;

        if (key != that.key) return false;
        return order.equals(that.order);
    }

    @Override
    public int hashCode() {
        int result = order.hashCode();
        result = 31 * result + key;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HashedOrder{");
        sb.append("order=").append(order);
        sb.append(", key=").append(key);
        sb.append('}');
        return sb.toString();
    }
}
