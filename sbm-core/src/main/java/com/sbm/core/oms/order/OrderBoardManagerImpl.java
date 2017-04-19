package com.sbm.core.oms.order;

/**
 * Created by jclinto on 18/04/2017.
 */
public class OrderBoardManagerImpl implements OrderBoardManager {

    private final NettedOrderRepository nettedOrderRepository;

    private final OrderBoard orderBoard;

    public OrderBoardManagerImpl(OrderBoard orderBoard, NettedOrderRepository nettedOrderRepository) {
        this.orderBoard = orderBoard;
        this.nettedOrderRepository = nettedOrderRepository;
    }

    @Override
    public void registerOrder(Order order) {

        // Find if there is a matching order already

        HashedOrder hashedOrder = new HashedOrder(order);
        int key = hashedOrder.getKey();

        LiveOrder liveOrder = this.nettedOrderRepository.findByKey(key);

        if(liveOrder == null) {
            liveOrder = new LiveOrder(hashedOrder);
            this.nettedOrderRepository.store(Integer.valueOf(key), liveOrder);
            this.orderBoard.addOrderRow(liveOrder);
        } else {
            //update order
        }

        // Add this order to that order as a child and roll up math to the parent

    }

    /**
     * interface as a add method which is wrong top provide to the client
     *
     * @return
     */
    @Override
    public OrderBoard asOrderBoardSnapshot() {
        return this.orderBoard;
    }

    @Override
    public void cancelOrder(int hashedOrderKey) {

        LiveOrder liveOrder = this.nettedOrderRepository.findByKey(hashedOrderKey);

        this.orderBoard.removeOrderRow(liveOrder);
    }
}
