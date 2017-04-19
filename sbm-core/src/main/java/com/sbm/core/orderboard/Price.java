package com.sbm.core.orderboard;

import java.util.Currency;

public class Price {

    public final Currency currency;
    public final int amount;
    public final String formatted;

    public Price(Currency currency, int amount) {
        this.currency = currency;
        this.amount = amount;
        // Could extract a PriceFormat interface here to make this flex-able
        this.formatted = new StringBuilder(this.currency.getSymbol())
                .append(this.amount)
                .toString();
    }

    public final boolean isLower(Price price) {
        return this.amount > price.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (amount != price.amount) return false;
        return currency.equals(price.currency);
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
