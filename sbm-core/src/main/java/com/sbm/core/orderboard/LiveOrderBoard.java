package com.sbm.core.orderboard;

import java.util.List;

public interface LiveOrderBoard {

    void registerOrder(Order order);

    boolean cancelOrder(LiveOrder liveOrder);

    List<LiveOrder> toLadder();
}
