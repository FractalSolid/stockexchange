package com.amartinez.stockexchange.model;

public class FromCurrency implements ApiParameter {
    private String fromCurrency;

    public FromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    @Override
    public String getKey() {
        return "from_currency";
    }

    @Override
    public String getValue() {
        return fromCurrency;
    }
}
