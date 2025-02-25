package com.api.filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
        logRequest(requestSpec);
        Response response = filterContext.next(requestSpec, responseSpec);
        logResponse(response);
        return response;
    }

    public void logRequest(FilterableRequestSpecification requestSpec){
        logger.info("BASE URI : "+ requestSpec.getBaseUri());
        logger.info("Header : "+ requestSpec.getHeaders());
        logger.info("payload : "+ requestSpec.getBody());

    }

    public void logResponse(Response response){
        logger.info("Status Code : "+ response.getStatusCode());
        logger.info("Response Header : "+ response.headers());
        logger.info("Response Body : "+ response.getBody().prettyPrint());
    }
}
