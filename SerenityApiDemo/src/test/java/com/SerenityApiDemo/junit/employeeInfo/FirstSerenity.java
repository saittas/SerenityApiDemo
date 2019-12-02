package com.SerenityApiDemo.junit.employeeInfo;
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
import net.thucydides.core.annotations.Title;
@RunWith(SerenityRunner.class)
//@Ignore
public class FirstSerenity {
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://dummy.restapiexample.com/api";
		//RestAssured
				// "/v1/employees"
		
	}
	@Test
	public void getAllEmployees() {
		SerenityRest.given().when().get("/v1/employees")//serenityrest is only wrapping on restassured
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
	@Title("This test will get the information of all employees from the Endpoints")
	@Test
	public void test01() {
	SerenityRest.given().when().get("/v1/employees")//serenityrest is only wrapping on restassured
	//the benefits of serenityrest is during the report part
	.then().log().all().statusCode(200);
		
	}
}
