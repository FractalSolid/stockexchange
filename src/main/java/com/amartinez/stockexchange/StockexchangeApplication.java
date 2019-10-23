package com.amartinez.stockexchange;

import com.amartinez.stockexchange.model.CurrencyExchange;
import com.amartinez.stockexchange.service.ForeignExchange;
import com.amartinez.stockexchange.web.AlphaVantageConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StockexchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockexchangeApplication.class, args);

        //String apiKey = "WD0M7Q1TXI2I0W6Z";
        //int timeout = 30;

        //AlphaVantageConnector alphaVantageConnector = new AlphaVantageConnector(apiKey, timeout);
        //ForeignExchange foreignExchange = new ForeignExchange(alphaVantageConnector);

        //try{
          //  CurrencyExchange currencyExchange = foreignExchange.currencyExchangeRate("USD", "GBP");
           // System.out.println(currencyExchange.toString());
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
    }

}
