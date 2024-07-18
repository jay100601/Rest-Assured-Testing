package TestBase;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class base {

	public static RequestSpecification httpRequest;
	public static Response response;
	
	
	public Logger logger;
	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("EmployeeRestAPI");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}
			
			
	
	
}
