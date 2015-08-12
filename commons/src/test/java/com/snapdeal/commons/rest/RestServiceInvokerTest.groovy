package com.snapdeal.commons.rest

import org.json.simple.parser.ParseException;

import spock.lang.Specification

class RestServiceInvokerTest extends Specification {

	def 'testing for Invalid URL'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		
		when:
		invoker.getJSON("invalid URL", new HashMap<String, String>())
		
		then:
		thrown(URISyntaxException)
	}
	
	
	def 'testing for a valid case without query params'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		
		when:
		String responseJSON=invoker.getJSON("http://jsonplaceholder.typicode.com/posts/1", new HashMap<String, String>())
		println 'JSON::'+responseJSON
		 
		then:
		noExceptionThrown()
	}
	
	def 'testing for a invalid get endpoint'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		
		when:
		String responseJSON=invoker.getJSON("http://jsonplaceholder.typicode.com", new HashMap<String, String>())
		println 'JSON::'+responseJSON
		 
		then:
		noExceptionThrown()
	}
	
	
	def 'testing for a valid get endpoint with queryParams'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		Map<String, Object> queryParams=new HashMap<String, Object>()
		queryParams.put("userId",1)
		
		when:
		String responseJSON=invoker.getJSON("http://jsonplaceholder.typicode.com/posts", queryParams)
		println 'JSON::'+responseJSON
		 
		then:
		noExceptionThrown()
	}
	
	
	
	//Testing for endpoints with Headers
	
	def 'testing for Invalid URL with headers'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		
		when:
		invoker.getJSON("invalid URL", new HashMap<String, String>(),new HashMap<String, Object>())
		
		then:
		thrown(URISyntaxException)
	}
	
	
	def 'testing for a valid case without query params and headers'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		
		when:
		String responseJSON=invoker.getJSON("http://jsonplaceholder.typicode.com/posts/1", new HashMap<String, String>(),new HashMap<String, Object>())
		println 'JSON::'+responseJSON
		 
		then:
		noExceptionThrown()
	}
	
	def 'testing for a invalid get endpoint with headers'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		
		when:
		String responseJSON=invoker.getJSON("http://jsonplaceholder.typicode.com", new HashMap<String, String>(),new HashMap<String, Object>())
		println 'JSON::'+responseJSON
		 
		then:
		noExceptionThrown()
	}
	
	
	def 'testing for a valid get endpoint with queryParams and headers'()
	{
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		Map<String, Object> queryParams=new HashMap<String, Object>()
		queryParams.put("userId",1)
		
		when:
		String responseJSON=invoker.getJSON("http://jsonplaceholder.typicode.com/posts", new HashMap<String, String>(),queryParams)
		println 'JSON::'+responseJSON
		 
		then:
		noExceptionThrown()
	}
	
	def 'Post + valid URL'(){
		
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		String json='{"title": "foo","body": "bar","userId": 1}'
		String url='http://jsonplaceholder.typicode.com/posts'
		
		when:
		String responseJSON=invoker.postJSON(url, json)
		println 'Post Response::'+responseJSON
		then:
		noExceptionThrown()
	}
	
	def 'Post + invalid URL'(){
		
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		String json='{"title": "foo","body": "bar","userId": 1}'
		String url='invalid url'
		
		when:
		String responseJSON=invoker.postJSON(url, json)
		println 'Post Response::'+responseJSON
		then:
		thrown(URISyntaxException)
	}
	
	def 'Post + invalid endpoint'(){
		
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		String json='{"title": "foo","body": "bar","userId": 1}'
		String url='http://snapdeal.typicode.com/'
		
		when:
		String responseJSON=invoker.postJSON(url, json)
		println 'Post Response::'+responseJSON
		then:
		noExceptionThrown()
	}
	
	
	def 'Post + invalid JSON'(){
		
		setup:
		RestServiceInvoker invoker=new RestServiceInvoker()
		String json='Invalid JSON'
		String url='http://snapdeal.typicode.com/'
		
		when:
		String responseJSON=invoker.postJSON(url, json)
		println 'Post Response::'+responseJSON
		then:
		thrown(ParseException)
	}
	
	
	
}
