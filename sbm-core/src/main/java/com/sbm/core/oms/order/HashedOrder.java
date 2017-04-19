package com.sbm.core.oms.order;

import com.google.common.base.Objects;

/**
 * Decorates the {@link Order} by adding a key hashed identified
 * which is very specific to the Live Order Board and hence this
 * identifer is not part of the order directly.
 */
public class HashedOrder {

    private final Order order;
    private final int key;

    public HashedOrder(Order order) {
        this.order = order;
        this.key = Objects.hashCode(
                this.order.getPrice(),
                this.order.getCurrencyCode(),
                this.order.getOrderType());
    }

    public double getPrice() {
        return this.order.getPrice();
    }

    public double getQuantity() {
        return this.order.getQuantity();
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
