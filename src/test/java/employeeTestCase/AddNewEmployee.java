package employeeTestCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.DataFile;

public class AddNewEmployee {

	DataFile df = new DataFile();
	
@Test
 void addEmployee() throws InterruptedException  {
	
	RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	
	RequestSpecification httprequest = RestAssured.given();
	
	//creating data to send along POST request
	JSONObject requestparams = new JSONObject();
	
	requestparams.put("name", df.empname);
	requestparams.put("salary", df.empsal);
	requestparams.put("age",df.empage);
	
	//add some header for POST request
	httprequest.header("Content-Type","application/json");
	
	//add json to the body of request
	httprequest.body(requestparams.toJSONString());
	
	//POST request to send and save response
	Response response = httprequest.request(Method.POST,"/create");
	
	
	//capture response body to perform validation
	String responseBody = response.getBody().asString();
	System.out.println("Response Body is:"+responseBody);
	
	Assert.assertEquals(responseBody.contains(df.empname),true);
	Assert.assertEquals(responseBody.contains(df.empsal),true);
	Assert.assertEquals(responseBody.contains(df.empage),true);
	
	
}


	
	
	
	
}
