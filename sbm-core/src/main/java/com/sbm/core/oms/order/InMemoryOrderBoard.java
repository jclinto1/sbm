package com.sbm.core.oms.order;

import com.google.common.collect.Lists;

import java.util.List;

public class InMemoryOrderBoard implements OrderBoard {

    private final List<ParentOrder> orders = Lists.newArrayList();

    public ParentOrder firstOrder() {
        return this.orders.get(0);
    }

    public void addOrderRow(ParentOrder parentOrder) {
        this.orders.add(parentOrder);
    }

    @Override
    public void removeOrderRow(ParentOrder parentOrder) {
        this.orders.remove(parentOrder);
    }

    @Override
    public int rowCount() {
        return this.orders.size();
    }
}
