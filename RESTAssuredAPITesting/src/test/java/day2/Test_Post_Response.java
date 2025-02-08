package day2;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test_Post_Response {
	@SuppressWarnings("unchecked")
	@Test
	public void post_Response_Test1() {
		baseURI = "https://reqres.in/api/users";
		
		//create Json object to store json data which you want to create
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Karishma");
		jsonData.put("job", "QA");
		
		//write test cases in bdd format
		given().header("content-type","application/json").contentType(ContentType.JSON).body(jsonData.toJSONString()).
		when().post().
		then().statusCode(201).log().all();
	}
	
}
