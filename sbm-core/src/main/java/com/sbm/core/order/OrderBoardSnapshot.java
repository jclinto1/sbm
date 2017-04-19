package com.sbm.core.order;

import java.util.List;

public class OrderBoardSnapshot {

    private List<OrderSnapshot> orderSnapshots;

    public OrderBoardSnapshot(List<OrderSnapshot> orderSnapshots) {
        this.orderSnapshots = orderSnapshots;
    }

    public OrderSnapshot firstOrderOrNull() {
        if(this.orderSnapshots.isEmpty()) {
            return null;
        }

        OrderSnapshot orderSnapshot = this.orderSnapshots.get(0);
        return orderSnapshot;
    }

    public int rowCount() {
        return this.orderSnapshots.size();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OrderBoardSnapshot{");
        sb.append("orderSnapshots=").append(orderSnapshots);
        sb.append('}');
        return sb.toString();
    }

}
