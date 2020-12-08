package com.amazonaws.lambda.demo.http;
import java.util.Map;


/*
 * Model Json data format that the API gateway creates from the http request
 */

public class HttpQueryStringRequest {

	Map<String, String> queryStringParameters;

	public Map<String, String> getQueryStringParameters() {
		return queryStringParameters;
	}

	public void setQueryStringParameters(Map<String, String> queryStringParameters) {
		this.queryStringParameters = queryStringParameters;
	}
	
}
