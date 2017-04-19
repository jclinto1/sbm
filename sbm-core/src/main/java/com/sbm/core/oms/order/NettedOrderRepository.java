package com.sbm.core.oms.order;

public interface NettedOrderRepository {

    ParentOrder findByKey(int key);

    void store(Integer integer, ParentOrder parentOrder);
}
