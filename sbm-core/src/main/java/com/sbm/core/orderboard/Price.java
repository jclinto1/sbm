package com.sbm.core.orderboard;

import java.util.Currency;

/**
 * Created by jclinto on 19/04/2017.
 */
public class Price {

    private final Currency currency;
    private final int amount;
    private final String formatted;

    public Price(Currency currency, int amount) {
        this.currency = currency;
        this.amount = amount;
        this.formatted = new StringBuilder(this.currency.getSymbol())
                .append(this.amount)
                .toString();
    }

    public int intValue() {
        return this.amount;
    }

    public String formattedText() {
        return this.formatted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (amount != price.amount) return false;
        return currency.equals(price.currency);
    }

    public boolean isLower(Price price) {
        return this.amount > price.intValue();
    }

    @Override
    public int hashCode() {
        int result = currency.hashCode();
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Price{");
        sb.append("currency=").append(currency);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();
    }

}
