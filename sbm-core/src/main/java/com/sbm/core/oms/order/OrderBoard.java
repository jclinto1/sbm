package com.sbm.core.oms.order;

public interface OrderBoard {

    void addOrderRow(LiveOrder liveOrder);

    void removeOrderRow(LiveOrder liveOrder);

    int rowCount();

    LiveOrder firstOrder();

}
