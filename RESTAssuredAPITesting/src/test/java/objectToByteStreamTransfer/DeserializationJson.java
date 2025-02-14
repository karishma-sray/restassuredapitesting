package objectToByteStreamTransfer;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializationJson {
	@Test
	public void createUser() {

		//https://reqres.in/api/users

		//create request specification		
		RequestSpecification req = RestAssured.given();

		//declare uri
		req.baseUri("https://reqres.in");
		req.basePath("/api/users");

		//Create Json body

		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Karishma");
		jsonData.put("job", "QA");
		
		
		// perform post request
		Response response = req.contentType(ContentType.JSON).body(jsonData.toJSONString()).post();
		
		ResponseBody repBody = response.getBody();
		
		// Deserialize responseBody i.e json resoponse body to class object

		// Class<T> is a generic form of any class of type T which is also referred to
		// as template class.

		JsonPostRequestResponse responseClass = repBody.as(JsonPostRequestResponse.class);

		Assert.assertEquals(responseClass.name, "Karishma", "check for name.");
		Assert.assertEquals(responseClass.job, "QA", "check for QA.");
				
	}
}
