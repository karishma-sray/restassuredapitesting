package validationOfResponses;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	
	@Test
	public void GetSingleUser()
	{
		//Get Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		//URI = "https://reqres.in/api/users/2"
		
		//specify base uri
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users/2");
		
		//create get request
		Response response = requestSpec.get();
		
		//validate response header
		String contentType = response.getHeader("Content-Type");
			
		//System.out.println("Value of connection:" + connection);
		
		//read all the response header attributes/keys and print their values
		Headers headersList = response.getHeaders();
		
		//iterate over header list 
		for (Header header:headersList)
		{
			System.out.println("Key : "+ header.getName() +" Value : "+ header.getValue());
		}
		
		
		//validate header content-type , expected value : application/json; charset=utf-8
		Assert.assertEquals(contentType, "application/json; charset=utf-8","Header content type mismatch.");
		
	}
}
