package com.snapdeal.commons.validator

import spock.lang.Specification

class ValidatorUtilTest extends Specification {

	def 'Testing ValidatorUtil HTTP Url validation'(){
		
		setup:
		ValidatorUtil validator=new ValidatorUtil();
		
		expect:
		validator.isHttpURLValid(urls)==expectedvalues
		
		where:
		urls<<["http://foo.bar.com/","ftp://foo.bar.com/","Invalid url"]
		expectedvalues<<[true,false,false]
		
	}
	
	def 'Testing ValidatorUtil JSON validation'(){
		
		setup:
		ValidatorUtil validator=new ValidatorUtil();
		
		expect:
		validator.isJSONValid(json)==expectedvalues
		
		where:
		json<<["""{"color": "red"}""","Not a valid JSON",null]
		expectedvalues<<[true,false,false]
		
	}
	
}
