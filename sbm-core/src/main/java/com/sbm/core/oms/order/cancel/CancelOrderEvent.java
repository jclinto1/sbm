package com.sbm.core.oms.order.cancel;

public class CancelOrderEvent {

    private final int orderId;

    public CancelOrderEvent(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CancelOrderEvent{");
        sb.append("orderId=").append(orderId);
        sb.append('}');
        return sb.toString();
    }
}
