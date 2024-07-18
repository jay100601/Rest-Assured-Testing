package BookTest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class post_Book {
	
	@Test
	void postBookToUser() {
		
	        JSONArray collectionOfIsbns = new JSONArray();
	        JSONObject isbnObject1 = new JSONObject();
	        isbnObject1.put("isbn", "9781449337711");
	        collectionOfIsbns.add(isbnObject1);
		
		
		
		//Specify baseURI
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		
		//Request Payload sending along with POST request
		JSONObject requestparams = new JSONObject();
		
		
        requestparams.put("userId", "b767f4d5-5e24-454f-a988-0f1eb2840b8f");
        requestparams.put("collectionOfIsbns", collectionOfIsbns);

		httprequest.header("Content-Type","application/json");
		
		
		httprequest.body(requestparams.toJSONString());
		
		Response response = httprequest.request(Method.POST,"?addListOfBooks");

		
		//print response in console window
		System.out.println("Response Body is:" +response.prettyPrint());
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: " +statusCode);
		Assert.assertEquals(statusCode, 401);
		
		
		
		
	}
	
	

}
