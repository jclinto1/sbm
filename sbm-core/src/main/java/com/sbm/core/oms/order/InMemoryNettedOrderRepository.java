package com.sbm.core.oms.order;

import java.util.HashMap;
import java.util.Map;

public class InMemoryNettedOrderRepository implements NettedOrderRepository {

    private Map<Integer, LiveOrder> index = new HashMap<>();

    @Override
    public LiveOrder findByKey(int key) {
        return this.index.get(key);
    }

    @Override
    public void store(Integer key, LiveOrder liveOrder) {
        this.index.put(key, liveOrder);
    }
}
