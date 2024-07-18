package BookTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Book_GET_Request {

	@Test
	void getBookInfo() {
		
		//Specify baseURI
		RestAssured.baseURI="https://demoqa.com/BookStore/v1/Book";
		
		//Request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET,"?ISBN=9781449325862");
		
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
		
		
	}
	
	
	
}
