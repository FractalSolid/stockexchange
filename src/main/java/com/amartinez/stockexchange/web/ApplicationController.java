package com.amartinez.stockexchange.web;

import com.amartinez.stockexchange.model.CurrencyExchange;
import com.amartinez.stockexchange.model.CurrencyExchangeRequest;
import com.amartinez.stockexchange.service.ForeignExchange;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ApplicationController {

    @PostMapping(path = "/exchange", consumes = "application/json", produces = "application/json")
    public String currencyExchange(@RequestBody CurrencyExchangeRequest currencyExchangeRequest) {
        //TODO: Deberiamos devolver un JSON aquí
        String apiKey = "WD0M7Q1TXI2I0W6Z";
        int timeout = 30;

        AlphaVantageConnector alphaVantageConnector = new AlphaVantageConnector(apiKey, timeout);
        ForeignExchange foreignExchange = new ForeignExchange(alphaVantageConnector);
        CurrencyExchange currencyExchange = null;
        try{
            currencyExchange = foreignExchange.currencyExchangeRate(currencyExchangeRequest.getFromCurrency().toString(),
                    currencyExchangeRequest.getToCurrency().toString());
            System.out.println(currencyExchange.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return currencyExchange.getCurrencyExchangeData().toString();
    }
}
