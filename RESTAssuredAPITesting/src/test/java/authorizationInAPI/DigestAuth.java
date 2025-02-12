package authorizationInAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DigestAuth {
	@Test
	public void DigestAuthentication()
	{
		//http://httpbin.org/digest-auth/undefined/prachi/prachi
		RequestSpecification requestSpec = RestAssured.given();
		//go to "http://httpbin.org" git repo & register under Auth>DigestGet>>it'll generate an url,which you can use.
		//Specify URL
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/karishma/karishma");

		//perform get request
		//Response response = requestSpec.get();
		Response response = requestSpec.auth().digest("karishma", "karishma").get();

		Assert.assertEquals(response.statusCode()/*actual*/, 200,"check for status code");
		//print status line
		System.out.println("Digest Auth Responsne status:" + response.statusLine());
		System.out.println("Digest Auth Response body:" + response.body().asString());

	}
}
