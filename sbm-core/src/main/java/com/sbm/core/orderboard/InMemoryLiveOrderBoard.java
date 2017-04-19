package com.sbm.core.orderboard;

import com.sbm.core.oms.order.HashedOrder;
import com.sbm.core.oms.order.LiveOrder;
import com.sbm.core.oms.order.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryLiveOrderBoard implements LiveOrderBoard {

    private Map<Integer, LiveOrder> buyOrderMap = new HashMap<>();
    private Map<Integer, LiveOrder> sellOrderMap = new HashMap<>();

    public InMemoryLiveOrderBoard() {
    }

    @Override
    public void registerOrder(Order order) {

        HashedOrder hashedOrder = new HashedOrder(order);

        if(order.isBUY()) {
            handleOrder(hashedOrder, this.buyOrderMap);
        } else {
            handleOrder(hashedOrder, this.sellOrderMap);
        }
    }

    private void handleOrder(HashedOrder hashedOrder, Map<Integer, LiveOrder> backingMap) {

        int key = hashedOrder.getKey();
        LiveOrder liveOrder = backingMap.get(key);

        if(liveOrder == null) {
            liveOrder = new LiveOrder(hashedOrder);
            backingMap.put(Integer.valueOf(key), liveOrder);
        } else {
            liveOrder.merge(hashedOrder);
        }
    }

    @Override
    public List<LiveOrder> toSnapshotList() {
        return Stream.concat(
                this.sellOrderMap.values().stream().sorted(),
                this.buyOrderMap.values().stream().sorted())
                .collect(Collectors.toList());
    }
}
