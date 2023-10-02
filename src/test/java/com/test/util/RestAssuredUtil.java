package com.test.util;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.RestAssured;
import io.restassured.authentication.NoAuthScheme;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtil {

	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


	/**
	 * This method is to POST with Map<String,String> headers
	 * 
	 * @param url
	 * @param mapHeader
	 * @param body
	 * @return Response object
	 */
	public Response postWithHeadersNoParam(String url, Map<String, String> mapHeader, String body) {

		Response response = null;

		try {

			response = RestAssured.given().relaxedHTTPSValidation().headers(mapHeader).body(body).when().post(url);

			// logger.info("postWithHeadersNoParam() response body --> " +
			// response.body().asPrettyString());
			return response;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("url to be hit is --> "+url);
			logger.error("postWithHeadersNoParam() response body --> " + response.body().asPrettyString());
			logger.error("postWithHeadersNoParam() failed for -> " + e.getMessage());
		}
		return response;

	}

	/**
	 * Use this method to make a DELETE with Map<String,String> map Headers
	 *
	 * @param url
	 * @param mapHeader
	 * @return
	 */
	public Response deleteWithHeaders(String url, Map<String, String> mapHeader) {
		Response response = null;
		logger.info("url to be hit is --> "+url);
		try {
			response = RestAssured.given().relaxedHTTPSValidation().headers(mapHeader).when()
					.delete(url);

			return response;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("deleteWithHeaderMap() response body -> " + response.body().asPrettyString());
			logger.error("deleteWithHeaderMap() failed for -> " + e.getMessage());

		}
		return response;
	}

	/**
	 * This is to make a PUT call
	 * 
	 * @param url
	 * @param mapHeader
	 * @param body
	 * @return Response oject
	 */
	public Response putWithHeadersNoParam(String url, Map<String, String> mapHeader, String body) {

		Response response = null;
		logger.info("url to be hit is --> "+url);

		try {

			response = RestAssured.given().relaxedHTTPSValidation().headers(mapHeader).body(body).when().put(url);

			// logger.info("putWithHeadersNoParam() response body --> " +
			// response.body().asPrettyString());
			return response;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("putWithHeadersNoParam() response body --> " + response.body().asPrettyString());
			logger.error("putWithHeadersNoParam() failed for -> " + e.getMessage());
		}
		return response;

	}
}


