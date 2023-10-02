package com.test.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeSuite;

import com.test.util.RestAssuredUtil;
import com.test.util.WebAction;

import io.restassured.response.Response;

public class BaseTest {
	
	
	public RestAssuredUtil restAssured=null;
	public String authToken=null;
	public WebAction webAction=null;
	
	@BeforeSuite
	public void beforeSuite()
	{
		restAssured =new RestAssuredUtil();
		webAction=new WebAction();
	}
	
	public void generateAuth()
	{
		String url="https://restful-booker.herokuapp.com/auth";
		Map<String,String> header=new HashMap<String,String>();
		header.put("Content-Type", "application/json");
		String body="{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}";
		Response response=restAssured.postWithHeadersNoParam(url, header, body);
		authToken=response.jsonPath().getString("token");
	}

}
