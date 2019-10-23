package com.amartinez.stockexchange.web;

import com.amartinez.stockexchange.model.ApiParameter;
import com.amartinez.stockexchange.model.ApiParameterBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class AlphaVantageConnector implements ApiConnector {

    private static final String BASE_URL = "https://www.alphavantage.co/query?";
    private final String apiKey;
    private final int timeout;
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public AlphaVantageConnector(String apiKey, int timeout) {
        this.apiKey = apiKey;
        this.timeout = timeout;
    }

    @Override
    public String getRequest(ApiParameter... apiParameters) {
        String params = getParameters(apiParameters);
        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(BASE_URL + params))
                    .timeout(Duration.ofSeconds(timeout))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.body());
            return response.body();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "TODO: Error";
    }

    private String getParameters(ApiParameter... apiParameters) {
        ApiParameterBuilder urlBuilder = new ApiParameterBuilder();
        for (ApiParameter parameter : apiParameters) {
            urlBuilder.append(parameter);
        }
        urlBuilder.concatApiParameters("apikey", apiKey);
        return urlBuilder.getUrl();
    }
}
