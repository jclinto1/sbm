package com.sbm.core.oms.order;

public interface OrderBoardManager {

    void registerOrder(Order order);

    OrderBoard getOrderBoardSummary();

    void cancelOrder(int hashedOrderKey);
}
