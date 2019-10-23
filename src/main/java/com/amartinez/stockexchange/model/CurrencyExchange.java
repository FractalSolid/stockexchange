package com.amartinez.stockexchange.model;

import lombok.Getter;

public class CurrencyExchange {
    @Getter
    private CurrencyExchangeData currencyExchangeData;

    //Default constructor for Jackson
    public CurrencyExchange() {}

    public CurrencyExchange(CurrencyExchangeData currencyExchangeData) {
        this.currencyExchangeData = currencyExchangeData;
    }
}
