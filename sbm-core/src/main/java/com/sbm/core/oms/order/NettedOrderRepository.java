package com.sbm.core.oms.order;

public interface NettedOrderRepository {

    LiveOrder findByKey(int key);

    void store(Integer integer, LiveOrder liveOrder);
}
