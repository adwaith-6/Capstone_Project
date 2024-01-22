package com.flyaway;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Rest_FlyAway {
	private static final String BASE_URL = "http://localhost:8080/";

	@Test
	public void testFlightSearchApi() {
		String source = "Bangalore";
		String destination = "Chennai";
		String date = "2024-01-20";
		Response response = RestAssured.given().param("source", source).param("destination", destination)
				.param("date", date).get(BASE_URL + "FlyAway/");
		Assert.assertEquals(response.getStatusCode(), 200);

	}
}
