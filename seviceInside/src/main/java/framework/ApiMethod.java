package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.commons.io.IOUtils;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiMethod {
	public static Response executeRequest(String testCaseName, String excelPath, String sheetName) {
		
		LinkedHashMap reqPara = ExcelLib.getRequestParameters(testCaseName, excelPath, sheetName);
		//System.out.println(reqPara);
		String httpMethod=reqPara.get("HTTPMethod").toString();
		System.out.println("httpMethod"+httpMethod);
		switch(httpMethod) {
		case "GET":
			//return given().queryParam("queryPara",reqPara.get("QueryParameter").toString()).when().get(reqPara.get("EndPoint").toString());
			
			
	
		return given().when().get(reqPara.get("EndPoint").toString());
		
		
		case "POST":
			try {
				FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resourses\\json\\"+testCaseName+".json");
				return given().contentType(ContentType.JSON).and().body(IOUtils.toByteArray(fis)).when().post(reqPara.get("EndPoint").toString());
				
			}catch(IOException e){
				
			}
//		case "PUT":
//		case "DELETE":
				
	


}
		return null;
	
	

	}
	}
