package com.sbm.core.orderboard;

import java.util.HashSet;
import java.util.Set;

public final class LiveOrder implements Comparable<LiveOrder> {

    private final int orderId;
    private double quantity;
    private OrderType orderType;
    private Price price;
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
        this.summary = new StringBuilder(String.valueOf(this.quantity))
                .append(" Kg for ")
                .append(hashedOrder.getPrice().formattedText())
                .toString();
    }

    public int getOrderId() {
        return this.orderId;
    }

    public String getSummary() {
        return this.summary;
    }

    public Price getPrice() {
        return price;
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
        if(this.orderType == OrderType.SELL) {
            if(this.price.isLower(other.getPrice())) {
                return 1;
            } else if(this.price.isLower(other.getPrice()) == false) {
                return -1;
            }
        }

        if(this.orderType == OrderType.BUY) {
            if(this.price.isLower(other.getPrice()) == false) {
                return 1;
            } else if(this.price.isLower(other.getPrice())) {
                return -1;
            }
        }

        return 0;
    }
}