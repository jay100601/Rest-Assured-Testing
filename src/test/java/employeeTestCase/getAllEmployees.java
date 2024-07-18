package employeeTestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestBase.base;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class getAllEmployees extends base {

	@BeforeMethod
	void getallemployees() throws InterruptedException {
		logger.info("----------------------------Started class----------------------------");
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		
		Thread.sleep(3000);
	}
	
	@Test(priority =1)
	void checkResponseBody() {
		logger.info("----------------------Checking Response Body----------------------------");
		
		String reponseBody = response.prettyPrint();
		logger.info("Status Code is==>"+reponseBody);
		Assert.assertTrue(reponseBody!=null);
		
	}
	
	
	@Test(priority =2)
	void checkStatusCode() {
		logger.info("----------------------Checking Status Code----------------------------");
	
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==>"+statusCode);
		Assert.assertEquals(statusCode, 429);
			
	}
	
	@Test(priority =3)
	void checkResponseTime() {
		logger.info("----------------------Checking Response Time----------------------------");
	
		long responseTime = response.getTime();
		logger.warn("Response Time is greater than 2000");
		Assert.assertTrue(responseTime<10000);
			
	}
	
	@Test(priority =4)
	void checkStatusLine() {
		logger.info("----------------------Checking Status Line----------------------------");
	
		String statusLine = response.getStatusLine();
		logger.info("Status Line is:==>"+statusLine);
		Assert.assertEquals(statusLine,"HTTP/1.1 429 Too Many Requests");
			
	}	
	
	@Test(priority =5)
	void checkContentType() {
		logger.info("----------------------Checking content Type----------------------------");
	
		String contentType = response.header("Content-Type");
		logger.info("Content Type is:==>"+contentType);
		Assert.assertEquals(contentType,"text/html; charset=UTF-8");
			
	}
	
	@Test(priority =6)
	void checkServerType() {
		logger.info("----------------------Checking Server Type----------------------------");
	
		String serverType = response.header("Server");
		logger.info("Server Type is:==>"+serverType);
		Assert.assertEquals(serverType,"nginx/1.21.6");
			
	}
	
	
	
	
	
	
	
	
	
	
	
}
