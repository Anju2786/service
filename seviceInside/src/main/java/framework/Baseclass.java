package framework;

import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import static io.restassured.RestAssured.*;




public class Baseclass implements iConstants {

	public static ExtentReports extendreports;
	public static ExtentTest extendtest;
	public static ExtentHtmlReporter extenthtmlreporter;
	public String testCaseName;

	/**
	 * to initialize the URI,port and authentication
	 */
	@BeforeSuite
	public void config() {
		baseURI = BASE_URI;
		// port=4444;
		// given().auth().basic(userName,password);
	}
}
