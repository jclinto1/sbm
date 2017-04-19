package com.sbm.core.oms;

import com.sbm.core.oms.order.OrderType;
import com.sbm.core.oms.lang.CurrencyCode;
import com.sbm.core.oms.order.Order;
import com.sbm.core.oms.order.register.RegisterOrderEvent;

/**
 * Canned data test builder class of {@code {@link Order }
 *
 * Created by jclinto on 18/04/2017.
 */
public class RegisterOrderEventCannedDataTestBuilder {

    // Developers, do not change the defaults values, if you need different values add a function
    // or change a new instance locally your class.
    private String userId = "dummyUser";
    private double quantity = 2.4;
    private double price = 245.00;
    private CurrencyCode currencyCode = CurrencyCode.GBP;
    private OrderType orderType = OrderType.SELL;

    public RegisterOrderEvent build() {
        return new RegisterOrderEvent(
                this.userId,
                this.quantity,
                this.price,
                this.currencyCode,
                this.orderType);
    }

    public RegisterOrderEventCannedDataTestBuilder registerOrderA() {
//        this.orderId = 1L;//UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE
        this.userId = "dummyUser1";
        this.quantity = 3.5;
        this.price = 306.00;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder registerOrderB() {
        this.userId = "dummyUser2";
        this.quantity = 1.2;
        this.price = 310.00;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder registerOrderC() {
        this.userId = "dummyUser3";
        this.quantity = 1.5;
        this.price = 307.00;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder registerOrderD() {
        this.userId = "dummyUser4";
        this.quantity = 2.0;
        this.price = 306.00;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder userId(String userId) {
        this.userId = userId;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder quantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder price(double price) {
        this.price = price;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder currencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public RegisterOrderEventCannedDataTestBuilder orderTypeSide(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }
}
