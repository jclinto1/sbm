package com.sbm.core.oms.order;

import com.google.common.collect.Lists;

import java.util.List;

public class InMemoryOrderBoard implements OrderBoard {

    private final List<LiveOrder> orders = Lists.newArrayList();

    public LiveOrder firstOrder() {
        return this.orders.get(0);
    }

    public void addOrderRow(LiveOrder liveOrder) {
        this.orders.add(liveOrder);
    }

    @Override
    public void removeOrderRow(LiveOrder liveOrder) {
        this.orders.remove(liveOrder);
    }

    @Override
    public int rowCount() {
        return this.orders.size();
    }
}
