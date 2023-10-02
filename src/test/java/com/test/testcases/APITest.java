package com.test.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class APITest extends BaseTest{
	
	String bookingUrl=		"https://restful-booker.herokuapp.com/booking/";
	String bookingId=null;
	
	@Test(priority=1)
	public void createBooking()
	{
		Map<String,String> header=new HashMap<String,String>();
		header.put("Content-Type", "application/json");
		String body="{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		Response response=restAssured.postWithHeadersNoParam(bookingUrl, header, body);
		response.prettyPrint();
		bookingId=response.jsonPath().getString("bookingid");
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	@Test(priority=2)
	public void updateBooking()
	{
		generateAuth();
		Map<String,String> header=new HashMap<String,String>();
		header.put("Content-Type", "application/json");
		header.put("Accept", "application/json");
		header.put("Cookie", "token="+authToken);
		String body="{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		Response response=restAssured.putWithHeadersNoParam(bookingUrl+bookingId, header, body);
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void deleteBooking()
	{
		generateAuth();
		Map<String,String> header=new HashMap<String,String>();
		header.put("Content-Type", "application/json");
		header.put("Cookie", "token="+authToken);
		Response response=restAssured.deleteWithHeaders(bookingUrl+bookingId, header);
		response.prettyPrint();
		Assert.assertEquals(response.statusCode(), 201);
	}
	
	
	
	

}
