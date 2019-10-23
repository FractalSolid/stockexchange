package com.amartinez.stockexchange.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@JsonDeserialize(using = CurrencyExchangeDeserializer.class)
public class CurrencyExchangeData {

    @Getter
    private final String fromCurrencyCode;
    @Getter
    private final String fromCurrencyName;
    @Getter
    private final String toCurrencyCode;
    @Getter
    private final String toCurrencyName;
    @Getter
    private final double exchangeRate;
    @Getter
    private final Date time;
    @Getter
    private final String timezone;

    @Override
    public String toString() {
        return "Response: " + "\n" + "1. From_Currency Code: " + fromCurrencyCode + "\n" + "2. From_Currency Name: " + fromCurrencyName
                + "\n" + "3. To_Currency Code: " + toCurrencyCode + "\n" + "4. To_Currency Name: " + toCurrencyName + "\n" + "5. Exchange Rate: " + exchangeRate
                + "\n" + "6. Time of conversion: " + time + "\n" + "7. Timezone: " + timezone;
    }
}
