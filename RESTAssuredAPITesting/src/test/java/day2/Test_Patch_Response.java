package day2;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_Patch_Response {
	@SuppressWarnings("unchecked")
	@Test
	public void post_Response_Test1() {
		baseURI = "https://reqres.in/api/users/476";
		
		//PUT = partial update
		//Update partial jsonData to jsonDataNew
		
		/*
		 * { "name": "Karishma", 
		 * "job": "QA", 
		 * "id": "476", 
		 * "createdAt": * "2025-02-06T07:14:05.669Z" }
		 */
		
		JSONObject jsonDataNew = new JSONObject();
		jsonDataNew.put("name", "Meena");
		jsonDataNew.put("job", "ML");
		
		//write test cases in bdd format
		given().header("content-type","application/json").contentType(ContentType.JSON).body(jsonDataNew.toJSONString()).
		when().patch().
		then().statusCode(200).log().all();
	}
	
}
