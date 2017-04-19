package com.sbm.core.orderboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemoryLiveOrderBoard implements LiveOrderBoard {

    private Map<Integer, LiveOrder> buyOrderMap = new HashMap<>();
    private Map<Integer, LiveOrder> sellOrderMap = new HashMap<>();

    @Override
    public void registerOrder(Order order) {

        HashedOrder hashedOrder = new HashedOrder(order);

        if(order.isBUY()) {
            registerOrderForMap(hashedOrder, this.buyOrderMap);
        } else {
            registerOrderForMap(hashedOrder, this.sellOrderMap);
        }
    }

    private void registerOrderForMap(HashedOrder hashedOrder, Map<Integer, LiveOrder> backingMap) {

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
    public boolean cancelOrder(LiveOrder liveOrder) {

        boolean removed;

        if(liveOrder.isBUY()) {
            removed = cancelOrderForMap(liveOrder, this.buyOrderMap);
        } else {
            removed = cancelOrderForMap(liveOrder, this.sellOrderMap);
        }

        return removed;
    }

    private boolean cancelOrderForMap(LiveOrder liveOrder, Map<Integer, LiveOrder> backingMap) {
        return backingMap.remove(liveOrder.orderId, liveOrder);
    }

    @Override
    public List<LiveOrder> toLadder() {
        return Stream.concat(
                this.sellOrderMap.values().stream().sorted(),
                this.buyOrderMap.values().stream().sorted())
                .collect(Collectors.toList());
    }
}
