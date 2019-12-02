package com.SerenityApiDemo.junit.employeeInfo;

import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.SerenityApiDemo.cucumber.serenity.EmployeeSerenitySteps;
import com.SerenityApiDemo.model.EmployeeClass;
import com.SerenityApiDemo.testbase.TestBase;
import com.SerenityApiDemo.utils.TestUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import io.vavr.collection.HashMap;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//JUNIT METHOD
@Ignore
public class EmployeesCRUD extends TestBase{
	static String firstName="emrselfahkevali"+TestUtils.getRandomValue();
	static int age=31;
	static int salary=7000;
	static int EmployeeId;
	Response response;
	@Steps
	EmployeeSerenitySteps steps;
	
@Title("This test will create a new employee")
	@Test
	public void test001() {
	//steps.createEmployee(firstName, salary, age).statusCode(200).spec(ReusableSpecification.getGenericResponseSpec());
	EmployeeClass employee=new EmployeeClass();
	employee.setFirstName(firstName);
	employee.setAge(age);
	employee.setSalary(salary);
	
	response=SerenityRest.rest().given().contentType(ContentType.JSON).log().all()//this will print request information
	.when().body(employee).post("/create");
//	System.out.println(response);
////	.then().log().all()//this will print response information
////	.statusCode(201);
	
}
@Title("Verify if the employee was added to the application")
@Test
public void test002() {
//	String p1="findAll{it.firstName=='";
//	String p2="'}.get(0)";
	//HashMap<String, Object>value=new HashMap<String, Object>;
	HashMap<String, Object> value=steps.getEmployeeInfoByFirstName(firstName);
	//=SerenityRest.rest().given().when().get("id").then().log().all()
//	.statusCode(200).extract().path("findAll{it.firstName==''}.get(0)");
////	System.out.println("the value is"+value);
////			String result=JsonPath.from(response.asString()).get("/employee/0");
			assertThat(value, hasValue(firstName));
			
			
//			//EmployeeId=get("id");
			
}
@Title("Update employee information")
@Test
public void test003() {
	firstName=firstName+"_Updated";
	EmployeeClass employee=new EmployeeClass();
	employee.setFirstName(firstName);
	employee.setAge(age);
	employee.setSalary(salary);
	
	response=SerenityRest.rest().given().contentType(ContentType.JSON).log().all()//this will print request information
	.when().body(employee).post("/create");
	System.out.println(response);
	
	
}
@Title("Delete the employee and verify if the employee is deleted")
@Test
public void test004() {
	//String id=response.then().extract().response().jsonPath().get("/employee/0");
	SerenityRest.rest().given().when().delete("/delete/0");
	
	//trying to retrieve it back
	SerenityRest.rest().given()
	.when().get("/employee/0")
	.then().log().all().statusCode(200);
	
}
}
