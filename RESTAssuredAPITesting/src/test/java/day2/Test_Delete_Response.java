package day2;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_Delete_Response {
	@SuppressWarnings("unchecked")
	@Test
	public void post_Response_Test1() {
		baseURI = "https://reqres.in/api/users/476";
		
		//PUT = entirely update
		//Delete complete jsonData , that we have created		
		/*
		 * { "name": "Karishma", 
		 * "job": "QA", 
		 * "id": "476", 
		 * "createdAt": * "2025-02-06T07:14:05.669Z" }
		 */
		
		
		
		//write test cases in bdd format
		given().
		when().
		delete().
		then().statusCode(204).log().all();
	}
	
}
