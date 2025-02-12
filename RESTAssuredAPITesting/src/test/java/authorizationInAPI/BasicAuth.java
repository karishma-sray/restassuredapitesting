package authorizationInAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuth {
	@Test
	public void BasicAuthUsingCreds()
	{
		RequestSpecification requestSpec = RestAssured.given();

		//Specify URL
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");

		//perform get request
		//Response response = requestSpec.get();
		Response response = requestSpec.auth().preemptive().basic("postman", "password").get();

		//print status line
		System.out.println("Responsne status:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());

	}
}
