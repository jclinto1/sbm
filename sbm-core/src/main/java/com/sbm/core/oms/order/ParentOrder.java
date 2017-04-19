package com.sbm.core.oms.order;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * A ParentOrder is made up of 1 or more underlying HashedOrder.
 * The key of the HashedOrder is used as the surrogate key for the order.
 */
public class ParentOrder {

    private final int orderId;
    private double quantity;
    private final Set<HashedOrder> underlyingOrders = Sets.newHashSet();
    private String summary;

    public ParentOrder(HashedOrder hashedOrder) {
        this.orderId = hashedOrder.getKey();
        storeUnderlyingOrder(hashedOrder);
        computeQuantity(hashedOrder);
        buildSummaryMessage(hashedOrder);
    }

    public void merge(HashedOrder hashedOrder) {
        computeQuantity(hashedOrder);
        buildSummaryMessage(hashedOrder);
    }

    private void storeUnderlyingOrder(HashedOrder hashedOrder) {
        this.underlyingOrders.add(hashedOrder);
    }

    private void computeQuantity(HashedOrder hashedOrder) {
        this.quantity = this.quantity + hashedOrder.getQuantity();
    }

    private void buildSummaryMessage(HashedOrder hashedOrder) {
        this.summary = new StringBuilder(String.valueOf(this.quantity))
                .append(" Kg for £")
                .append(hashedOrder.getPrice())
                .toString();
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getSummary() {
        return this.summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParentOrder that = (ParentOrder) o;

        return orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return this.orderId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParentOrder{");
        sb.append("orderId=").append(orderId);
        sb.append(", quantity=").append(quantity);
        sb.append(", underlyingOrders=").append(underlyingOrders);
        sb.append(", summary='").append(summary).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
