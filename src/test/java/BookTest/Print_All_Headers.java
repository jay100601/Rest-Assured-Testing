package BookTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Print_All_Headers {
	
	@Test
	public void printHeaders() {
		
		//Specify baseURI
				RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
				
				//Request object
				RequestSpecification httprequest = RestAssured.given();
				
				//Response object
				Response response = httprequest.request(Method.GET);
				
				//print response in console window
				
				System.out.println("Response Body is:" +response.prettyPrint());
				
			Headers allheaders = response.headers(); //to capture all headers from response
			
			for(Header header:allheaders) {
				System.out.println(header.getName()+"----->"+header.getValue());
				
			}
				
				
	}
	

}
