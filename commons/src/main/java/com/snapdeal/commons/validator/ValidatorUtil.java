package com.snapdeal.commons.validator;

import org.apache.commons.validator.routines.UrlValidator;
import org.apache.log4j.Logger;
import org.json.simple.parser.JSONParser;

public class ValidatorUtil {

	private static final Logger LOGGER = Logger.getLogger(ValidatorUtil.class);
	
	private JSONParser jsonParser=new JSONParser();
	
	public boolean isHttpURLValid(String url) {

		String[] schemes = { "http", "https" };
		UrlValidator urlValidator = new UrlValidator(schemes);
		return urlValidator.isValid(url);
	}

	public boolean isJSONValid(String json) {
		try
		{
		jsonParser.parse(json);
		return true;
		}catch(Exception e)
		{
			LOGGER.info("JSON is invalid");
			return false;
		}
	}
}
