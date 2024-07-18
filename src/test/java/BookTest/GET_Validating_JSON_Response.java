package BookTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Validating_JSON_Response {

	@Test
	public void getResponseBody() {
		RestAssured.baseURI ="https://demoqa.com/BookStore/v1/Book";
		RequestSpecification httpresquest = RestAssured.given();
		
		Response response = httpresquest.request(Method.GET,"?ISBN=9781491904244");
		
		JsonPath jsonpath = response.jsonPath();//to capture all response
		
		System.out.println(jsonpath.get("isbn"));
		System.out.println(jsonpath.get("title"));
		System.out.println(jsonpath.get("subTitle"));
		System.out.println(jsonpath.get("author"));
		System.out.println(jsonpath.get("publish_date"));
		System.out.println(jsonpath.get("publisher"));
		System.out.println(jsonpath.get("pages"));
		System.out.println(jsonpath.get("description"));
		System.out.println(jsonpath.get("website"));
		
		Assert.assertEquals(jsonpath.get("title"), "You Don't Know JS");

		
		
		
	}
	
	
	
	
}
