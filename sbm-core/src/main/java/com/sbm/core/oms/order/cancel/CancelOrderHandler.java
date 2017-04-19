package com.sbm.core.oms.order.cancel;

public interface CancelOrderHandler {

    void execute(CancelOrderEvent event);
}
