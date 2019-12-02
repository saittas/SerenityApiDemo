package com.SerenityApiDemo.cucumber.serenity;

import java.util.HashMap;

import com.SerenityApiDemo.model.EmployeeClass;
import com.SerenityApiDemo.utils.ReusableSpecification;

import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmployeeSerenitySteps {
	@Step("Creating the new employee with firstName: {0}, int salary: {1}, int age: {2}")
   public ValidatableResponse createEmployee(String firstName, int salary, int age) {
	   EmployeeClass employee=new EmployeeClass();
		employee.setFirstName(firstName);
		employee.setSalary(salary);
		employee.setAge(age);
		
		 return SerenityRest.rest().given().spec(ReusableSpecification.getGenericRequestSpec())//this will print request information
		.when().body(employee).post("/create")
		//System.out.println(response);
	.then();//this will print response information
//		.statusCode(201);
	  
   }
	@Step("Getting the employee information with firstname: {0}")
	public HashMap<String,Object>getEmployeeInfoByFirstName(String firstName){
		String p1="findAll{it.firstName=='";
		String p2="'}.get(0)";
       
				return SerenityRest.rest().given().when().get("/employee/0").then().log().all()
		.statusCode(200).extract().path("findAll{it.firstName==''}.get(0)");
//		System.out.println("the value is"+value);
		
	}
}
