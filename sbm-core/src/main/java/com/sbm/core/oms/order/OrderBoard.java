package com.sbm.core.oms.order;

public interface OrderBoard {

    void addOrderRow(ParentOrder parentOrder);

    void removeOrderRow(ParentOrder parentOrder);

    int rowCount();

    ParentOrder firstOrder();

}
