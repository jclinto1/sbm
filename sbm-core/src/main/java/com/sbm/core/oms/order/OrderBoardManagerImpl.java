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

        ParentOrder parentOrder = this.nettedOrderRepository.findByKey(key);

        if(parentOrder == null) {
            parentOrder = new ParentOrder(hashedOrder);
            this.nettedOrderRepository.store(Integer.valueOf(key), parentOrder);
            this.orderBoard.addOrderRow(parentOrder);
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
    public OrderBoard getOrderBoardSummary() {
        return this.orderBoard;
    }

    @Override
    public void cancelOrder(int hashedOrderKey) {

        ParentOrder parentOrder = this.nettedOrderRepository.findByKey(hashedOrderKey);

        this.orderBoard.removeOrderRow(parentOrder);
    }
}
