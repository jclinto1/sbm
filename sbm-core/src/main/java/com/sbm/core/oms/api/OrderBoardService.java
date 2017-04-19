package com.sbm.core.oms.api;

import com.sbm.core.oms.order.cancel.CancelOrderEvent;
import com.sbm.core.oms.order.register.RegisterOrderEvent;
import com.sbm.core.oms.order.OrderBoard;

public interface OrderBoardService {

    void registerOrder(RegisterOrderEvent registerOrderEvent);

    OrderBoard getOrderSummary();

    void cancelOrder(CancelOrderEvent cancelOrderEvent);
}
