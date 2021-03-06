package com.sbm.core.orderboard;

import java.util.HashSet;
import java.util.Set;

public final class LiveOrder implements Comparable<LiveOrder> {

    public final int orderId;
    public final OrderType orderType;
    public final Price price;
    private double quantity;
    private final Set<HashedOrder> underlyingOrders = new HashSet<>();
    private String summary;

    public LiveOrder(HashedOrder hashedOrder) {
        this.orderId = hashedOrder.getKey();
        this.orderType = hashedOrder.getOrderType();
        this.price = hashedOrder.getPrice();
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
        //Could extract a summary formatter interface to make this more flex-able
        this.summary = new StringBuilder(String.valueOf(this.quantity))
                .append(" Kg for ")
                .append(hashedOrder.getPrice().formatted)
                .toString();
    }

    public String getSummary() {
        return this.summary;
    }

    public boolean isBUY() {
        return OrderType.BUY == this.orderType;
    }

    public boolean isSELL() {
        return OrderType.SELL == this.orderType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LiveOrder that = (LiveOrder) o;

        return orderId == that.orderId;
    }

    @Override
    public int hashCode() {
        return this.orderId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LiveOrder{");
        sb.append("orderId=").append(orderId);
        sb.append(", quantity=").append(quantity);
        sb.append(", underlyingOrders=").append(underlyingOrders);
        sb.append(", summary='").append(summary).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(LiveOrder other) {
        // Could extract this logic or pass to the sort directly to make this more flex-able
        if(this.isSELL() && other.isSELL()) {
            if(this.price.isLower(other.price)) {
                return 1;
            } else if(this.price.isLower(other.price) == false) {
                return -1;
            }
        }

        if(this.isBUY() && other.isBUY()) {
            if(this.price.isLower(other.price) == false) {
                return 1;
            } else if(this.price.isLower(other.price)) {
                return -1;
            }
        }

        return 0;
    }
}