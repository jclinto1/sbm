package com.sbm.core.oms.order;

import java.util.HashMap;
import java.util.Map;

public class InMemoryNettedOrderRepository implements NettedOrderRepository {

    private Map<Integer, ParentOrder> index = new HashMap<>();

    @Override
    public ParentOrder findByKey(int key) {
        return this.index.get(key);
    }

    @Override
    public void store(Integer key, ParentOrder parentOrder) {
        this.index.put(key, parentOrder);
    }
}
