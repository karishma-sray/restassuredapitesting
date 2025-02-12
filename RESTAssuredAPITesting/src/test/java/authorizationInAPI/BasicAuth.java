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
		//Non-preemptive() --> minimum 2 requests response required to process a call & by default basic authorization is non preemptive,ie; known as challanged basic auth.
		//which means it'll not give credes to server initially, when server asked for it then only it'll gv creds.
		
		Response response = requestSpec.auth().preemptive().basic("postman", "password").get();

		//print status line
		System.out.println("Responsne status:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());

	}
}
