package com.amartinez.stockexchange.service;

import com.amartinez.stockexchange.model.*;
import com.amartinez.stockexchange.web.ApiConnector;
import com.amazonaws.services.rds.model.Timezone;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class ForeignExchange {

    private final ApiConnector apiConnector;

    public ForeignExchange(ApiConnector apiConnector) {
        this.apiConnector = apiConnector;
    }

    public CurrencyExchange currencyExchangeRate(String fromCCY, String toCCY) throws IOException {
        String json = apiConnector.getRequest(Function.CURRENCY_EXCHANGE_RATE, new FromCurrency(fromCCY), new ToCurrency(toCCY));

        //TODO: Extract this to a utility class?
        ObjectMapper objectMapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        objectMapper.setDateFormat(dateFormat);
        SimpleModule module = new SimpleModule("CurrencyExchangeDeserializer", new Version(1, 0, 0, null, null, null));
        objectMapper.registerModule(module);
        CurrencyExchangeData currencyExchangeData = objectMapper.readValue(json, CurrencyExchangeData.class);
        System.out.println(currencyExchangeData);
        //TODO: Call here the custom deserializer

        return new CurrencyExchange(currencyExchangeData);
    }
}
