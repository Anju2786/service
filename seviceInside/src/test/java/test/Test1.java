package test;

import org.testng.annotations.Test;

import framework.ApiMethod;
import framework.Baseclass;
import io.restassured.response.Response;

public class Test1 extends Baseclass {

	@Test
	public void getTest() {
	
		Response res = ApiMethod.executeRequest("getAllItemByTaskId" ,REQ_PARA_FILLE_PATH, REQ_PARA_SHEET);
		System.out.println(res.prettyPrint());
	}

}
