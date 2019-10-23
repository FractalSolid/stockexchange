package com.amartinez.stockexchange.model;

import lombok.Builder;
import lombok.Getter;

@Builder
public class CurrencyExchangeRequest {

    @Getter
    private FromCurrency fromCurrency;
    @Getter
    private ToCurrency toCurrency;


}
