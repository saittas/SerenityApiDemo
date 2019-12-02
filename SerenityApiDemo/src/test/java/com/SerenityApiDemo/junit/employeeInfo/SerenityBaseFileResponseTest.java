package com.SerenityApiDemo.junit.employeeInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class SerenityBaseFileResponseTest {

	
    @Title("Get available plans base response capture")
	@Test
	public void Test01() throws IOException {
	RestAssured.baseURI ="https://c1-k8s-go0v.aws-us-west-2-green.kube-np.ebiz.verizon.com/ev6v";
	 String requestBody= " {\r\n" + 
	 		"  \"data\": {\r\n" + 
	 		"    \"billAccountNum\": \"00001\",\r\n" + 
	 		"    \"customerId\": \"0418191346\",\r\n" + 
	 		"    \"locationCode\": \"0026301\"\r\n" + 
	 		"  },\r\n" + 
	 		"  \"meta\": {\r\n" + 
	 		"    \"clientCorrelationId\": \" \",\r\n" + 
	 		"    \"client\": \"PEGA\",\r\n" + 
	 		"    \"user\": \"gopalvi\"\r\n" + 
	 		"  }\r\n" + 
	 		"}";
	
   Response response=null;

	response=(Response) SerenityRest.given().contentType(ContentType.JSON).when().body(requestBody).post("nsq1/browse/get-available-plans");//serenityrest is only wrapping on restassured
	//the benefits of serenityrest is during the report part
	//then().log().all().statusCode(200);
	BufferedWriter file = null;
	file = new BufferedWriter(
			new FileWriter("C:\\Users\\PALAEM\\Desktop\\SerenityApiDemo\\SerenityApiDemo\\GetAvailablePlans_baseSerenity.txt", true));
	file.write((response.asString()));
	 file.newLine();
     file.close();
	System.out.println("Successfully Copied JSON Object to File...");
	
}
}
