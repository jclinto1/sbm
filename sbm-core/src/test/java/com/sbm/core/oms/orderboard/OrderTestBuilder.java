package com.sbm.core.oms.orderboard;

import com.sbm.core.orderboard.Price;
import com.sbm.core.orderboard.Order;
import com.sbm.core.orderboard.OrderType;

/**
 * Canned data test builder class of {@code {@link Order }
 *
 * Created by jclinto on 18/04/2017.
 */
public final class OrderTestBuilder {

    private String userId = "dummyUser";
    private double quantity = 2.4;
    private Price price = new PriceTestBuilder().build();
    private OrderType orderType = OrderType.SELL;

    public Order build() {
        return new Order(
                this.userId,
                this.quantity,
                this.price,
                this.orderType);
    }

    public OrderTestBuilder sellOrderA() {
        this.userId = "dummyUser1";
        this.quantity = 3.5;
        this.price = new PriceTestBuilder().amount(306).build();
        return this;
    }

    public OrderTestBuilder sellOrderB() {
        this.userId = "dummyUser2";
        this.quantity = 1.2;
        this.price = new PriceTestBuilder().amount(310).build();
        return this;
    }

    public OrderTestBuilder sellOrderC() {
        this.userId = "dummyUser3";
        this.quantity = 1.5;
        this.price = new PriceTestBuilder().amount(307).build();
        return this;
    }

    public OrderTestBuilder sellOrderD() {
        this.userId = "dummyUser4";
        this.quantity = 2.0;
        this.price = new PriceTestBuilder().amount(306).build();
        return this;
    }

    public OrderTestBuilder buyOrderE() {
        this.userId = "dummyUser5";
        this.quantity = 2.0;
        this.price = new PriceTestBuilder().amount(406).build();
        this.orderType = OrderType.BUY;
        return this;
    }

    public OrderTestBuilder buyOrderF() {
        this.userId = "dummyUser5";
        this.quantity = 1.3;
        this.price = new PriceTestBuilder().amount(345).build();
        this.orderType = OrderType.BUY;
        return this;
    }

    public OrderTestBuilder buyOrderG() {
        this.userId = "dummyUser6";
        this.quantity = 2.2;
        this.price = new PriceTestBuilder().amount(345).build();
        this.orderType = OrderType.BUY;
        return this;
    }

    public OrderTestBuilder buyOrderH() {
        this.userId = "dummyUser6";
        this.quantity = 2.7;
        this.price = new PriceTestBuilder().amount(290).build();
        this.orderType = OrderType.BUY;
        return this;
    }

    public OrderTestBuilder userId(String userId) {
        this.userId = userId;
        return this;
    }

    public OrderTestBuilder quantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderTestBuilder price(Price price) {
        this.price = price;
        return this;
    }

    public OrderTestBuilder orderTypeSide(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }
}
