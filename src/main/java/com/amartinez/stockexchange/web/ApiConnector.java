package com.amartinez.stockexchange.web;

import com.amartinez.stockexchange.model.ApiParameter;

@FunctionalInterface
public interface ApiConnector {

    String getRequest(ApiParameter... apiParameters);
}
