package com.amartinez.stockexchange.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrencyExchangeDeserializer extends StdDeserializer {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

    public CurrencyExchangeDeserializer() {
        this(null);
    }

    public CurrencyExchangeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String fromCurrencyCode = node.get("Realtime Currency Exchange Rate").get("1. From_Currency Code").asText();
        String fromCurrencyName = node.get("Realtime Currency Exchange Rate").get("2. From_Currency Name").asText();
        String toCurrencyCode = node.get("Realtime Currency Exchange Rate").get("3. To_Currency Code").asText();
        String toCurrencyName = node.get("Realtime Currency Exchange Rate").get("4. To_Currency Name").asText();
        double exchangeRate = node.get("Realtime Currency Exchange Rate").get("5. Exchange Rate").asDouble();
        String date = node.get("Realtime Currency Exchange Rate").get("6. Last Refreshed").asText();
        Date parsedDate = null;
        try {
            parsedDate = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String timezone = node.get("Realtime Currency Exchange Rate").get("7. Time Zone").asText();

        return new CurrencyExchangeData(fromCurrencyCode, fromCurrencyName, toCurrencyCode, toCurrencyName, exchangeRate, parsedDate, timezone);
    }
}
