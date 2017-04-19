package com.sbm.core.orderboard;

import com.sbm.core.oms.order.LiveOrder;
import com.sbm.core.oms.order.Order;

import java.util.List;

public interface LiveOrderBoard {

    void registerOrder(Order event);

    List<LiveOrder> toSnapshotList();
}
