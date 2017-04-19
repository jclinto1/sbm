package com.sbm.core.orderboard;

import java.util.List;

public interface LiveOrderBoard {

    void registerOrder(Order event);

    List<LiveOrder> toLadder();
}
