package com.snapdeal.commons.rest;

import java.net.URISyntaxException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.snapdeal.commons.validator.ValidatorUtil;

public class RestServiceInvoker {

	private ValidatorUtil validatorUtil = new ValidatorUtil();
	private static final Logger LOGGER = Logger
			.getLogger(RestServiceInvoker.class);

	@SuppressWarnings("unchecked")
	public String getJSON(String url, Map<String, Object> queryParams)
			throws URISyntaxException {
		HttpResponse<JsonNode> httpResponse = null;
		if (!validatorUtil.isHttpURLValid(url)) {
			throw new URISyntaxException(url, "The URL is not absolute");
		}

		try {
			httpResponse = Unirest.get(url).queryString(queryParams).asJson();
		} catch (UnirestException e) {
			LOGGER.error("Exception occured while making get call");
			JSONObject errorObject = new JSONObject();
			errorObject.put("status", "500");
			errorObject.put("message", e.getLocalizedMessage());
			return errorObject.toJSONString();
		}
		return httpResponse.getBody().toString();
	}

	@SuppressWarnings("unchecked")
	public String getJSON(String url, Map<String, String> headers,
			Map<String, Object> queryParams) throws URISyntaxException {
		HttpResponse<JsonNode> httpResponse = null;
		if (!validatorUtil.isHttpURLValid(url)) {
			throw new URISyntaxException(url, "The URL is not absolute");
		}

		try {
			httpResponse = Unirest.get(url).headers(headers)
					.queryString(queryParams).asJson();
		} catch (UnirestException e) {

			LOGGER.error("Exception occured while making get call");
			JSONObject errorObject = new JSONObject();
			errorObject.put("status", "500");
			errorObject.put("message", e.getLocalizedMessage());
			return errorObject.toJSONString();
		}
		return httpResponse.getBody().toString();
	}

	@SuppressWarnings("unchecked")
	public String postJSON(String url, String jsonData)
			throws URISyntaxException, ParseException {
		HttpResponse<JsonNode> httpResponse = null;

		if (!validatorUtil.isHttpURLValid(url)) {
			throw new URISyntaxException(url, "The URL is not absolute");
		}
		
		if(!validatorUtil.isJSONValid(jsonData))
		{
			throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
		}

		try {
			httpResponse = Unirest.post(url).body(jsonData).asJson();
		} catch (UnirestException e) {

			LOGGER.error("Exception occured while making post call");
			JSONObject errorObject = new JSONObject();
			errorObject.put("status", "500");
			errorObject.put("message", e.getLocalizedMessage());
			return errorObject.toJSONString();
		}
		return httpResponse.getBody().toString();

	}
	
	
	@SuppressWarnings("unchecked")
	public String postJSON(String url, String jsonData,Map<String, String> headers)
			throws URISyntaxException, ParseException {
		HttpResponse<JsonNode> httpResponse = null;

		if (!validatorUtil.isHttpURLValid(url)) {
			throw new URISyntaxException(url, "The URL is not absolute");
		}
		
		if(!validatorUtil.isJSONValid(jsonData))
		{
			throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
		}

		try {
			httpResponse = Unirest.post(url).headers(headers).body(jsonData).asJson();
		} catch (UnirestException e) {

			LOGGER.error("Exception occured while making post call");
			JSONObject errorObject = new JSONObject();
			errorObject.put("status", "500");
			errorObject.put("message", e.getLocalizedMessage());
			return errorObject.toJSONString();
		}
		return httpResponse.getBody().toString();

	}
	
	
	
	@SuppressWarnings("unchecked")
	public String putJSON(String url, String jsonData)
			throws URISyntaxException, ParseException {
		HttpResponse<JsonNode> httpResponse = null;

		if (!validatorUtil.isHttpURLValid(url)) {
			throw new URISyntaxException(url, "The URL is not absolute");
		}
		
		if(!validatorUtil.isJSONValid(jsonData))
		{
			throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
		}

		try {
			httpResponse = Unirest.put(url).body(jsonData).asJson();
		} catch (UnirestException e) {

			LOGGER.error("Exception occured while making post call");
			JSONObject errorObject = new JSONObject();
			errorObject.put("status", "500");
			errorObject.put("message", e.getLocalizedMessage());
			return errorObject.toJSONString();
		}
		return httpResponse.getBody().toString();

	}
	
	
	@SuppressWarnings("unchecked")
	public String putJSON(String url, String jsonData,Map<String, String> headers)
			throws URISyntaxException, ParseException {
		HttpResponse<JsonNode> httpResponse = null;

		if (!validatorUtil.isHttpURLValid(url)) {
			throw new URISyntaxException(url, "The URL is not absolute");
		}
		
		if(!validatorUtil.isJSONValid(jsonData))
		{
			throw new ParseException(ParseException.ERROR_UNEXPECTED_TOKEN);
		}

		try {
			httpResponse = Unirest.put(url).headers(headers).body(jsonData).asJson();
		} catch (UnirestException e) {

			LOGGER.error("Exception occured while making post call");
			JSONObject errorObject = new JSONObject();
			errorObject.put("status", "500");
			errorObject.put("message", e.getLocalizedMessage());
			return errorObject.toJSONString();
		}
		return httpResponse.getBody().toString();

	}

}
