package com.SerenityApiDemo.employeeIdInfo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
@RunWith(SerenityRunner.class)
//@Ignore
public class SerenityIdInfo {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//RestAssured
				// "/v1/employees"
		
	}
   
	@Test
	public void getAllEmployees() {
		SerenityRest.given().when().get("/employees")//serenityrest is only wrapping on restassured
		//the benefits of serenityrest is during the report part
		.then().log().all().statusCode(200);
		
	}
	@Test
	public void thisIsFailing() {
		SerenityRest.given().when().get("/v1/employees").then().log().all().statusCode(500);
	}
	@Pending
	@Test
	public void thisIsAPending() {
		
	}
	@Ignore
	@Test
	public void thisIsASkippedTest() {
		System.out.println("This is an error"+(5/0));
		
	}
	@Test
	public void thisIsATestWithError() {
		System.out.println("This is an error"+(5/0));
	}
	
	@Test
	public void FileDoesNotExistTest() throws FileNotFoundException {
		File file=new File("E://file.text");
		FileReader fr=new FileReader(file);
	
	}
	@Manual
	@Test
	public void ThisIsAManual() {
		
	}
}
