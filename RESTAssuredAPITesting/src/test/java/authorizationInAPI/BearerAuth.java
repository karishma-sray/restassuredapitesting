package authorizationInAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerAuth {
//https://gorest.co.in/rest-console	
//login & it'll create a token string	
//4ed3303851f5bf9869c46f04b6227030db48b52c2c6a977a5629bb4c15716ee5
	
	
	@Test
	public void BearerToken()
	{
		//https://gorest.co.in/public/v2/users
		//create requsest specification
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
		
		//create json object & pass the data for auth
		
		JSONObject payload = new JSONObject();
		payload.put("name", "karishma");
		payload.put("gender", "Female");
		payload.put("email", "karishma123@gmail.com");
		payload.put("status", "Active");
		
		String AuthToken = "Bearer 4ed3303851f5bf9869c46f04b6227030db48b52c2c6a977a5629bb4c15716ee5";
		
		//create header, content type,json body
		requestSpec.headers("Authorization", AuthToken).
		contentType(ContentType.JSON).
		body(payload.toJSONString());
		
		//perform post request
		Response response = requestSpec.post();
		

		//validate status code 
		Assert.assertEquals(response.statusCode()/*actual*/, 201/*expected*/,"check for status code");
	
		//print status line & response boy
		System.out.println("Responsne status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asString());
		
		
	}
}
