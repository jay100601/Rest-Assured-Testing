package BookTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Validate_header {

	@Test
	void verifyHeaders() {
		
		//Specify baseURI
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET);
		
		//print response in console window
		System.out.println("Response Body is:" +response.prettyPrint());
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status Code is: " +statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status Line Verification
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is:" +statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		//validating header
		
		String contentType = response.header("Content-Type");//capture details of content-Type
		System.out.println("Content-Type: " +contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		
		String contentLength = response.header("Content-Length");//capture details of content-Length
		System.out.println("Content Length: " +contentLength);
		Assert.assertEquals(contentLength, "4514");
		
		
		
		
		
		
		
	}
	
}
