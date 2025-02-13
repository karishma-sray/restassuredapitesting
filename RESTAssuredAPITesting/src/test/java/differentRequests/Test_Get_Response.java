package differentRequests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_Get_Response {
	
	@Test
 public void get_Response_Test1() {
	 Response resGet = get("https://reqres.in/api/users?page=2");
	 System.out.println(resGet.asString());
	 System.out.println(resGet.getStatusCode());
	 System.out.println(resGet.getTime());
	 
	 //Validate status code
	 int expectedStatusCode = 200;
	 int actualStatusCode = resGet.getStatusCode();
	 Assert.assertEquals(actualStatusCode, expectedStatusCode);
 }
	@Test
	 public void get_Response_Test2() {
		 //using BDD
		 //Given, When, Then
		baseURI = "https://reqres.in/api/users";
		given().queryParam("page", "2").when().get().then().statusCode(200);
		
	 }
}
