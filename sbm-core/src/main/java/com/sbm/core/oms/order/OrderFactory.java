package com.sbm.core.oms.order;

import com.sbm.core.oms.order.register.RegisterOrderEvent;

/**
 * Created by jclinto on 18/04/2017.
 */
public interface OrderFactory {

    Order from(RegisterOrderEvent event);
}
