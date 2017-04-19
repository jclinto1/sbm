package com.sbm.core.oms.order.register;

import com.sbm.core.orderboard.Price;

import java.util.Currency;

public final class PriceTestBuilder {

    private Currency currency = Currency.getInstance("GBP");
    private int amount;

    public Price build() {
        return new Price(this.currency, this.amount);
    }

    public PriceTestBuilder currency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public PriceTestBuilder amount(int amount) {
        this.amount = amount;
        return this;
    }

}
