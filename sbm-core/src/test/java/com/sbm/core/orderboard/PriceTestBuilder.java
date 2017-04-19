package com.sbm.core.orderboard;

import java.util.Currency;

public final class PriceTestBuilder {

    private Currency currency = Currency.getInstance("GBP");
    private int amount = 300;

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
