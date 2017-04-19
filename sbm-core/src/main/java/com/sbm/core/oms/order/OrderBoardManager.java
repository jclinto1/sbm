package com.sbm.core.oms.order;

public interface OrderBoardManager {

    void registerOrder(Order order);

    OrderBoard asOrderBoardSnapshot();

    void cancelOrder(int hashedOrderKey);
}
