package com.SerenityApiDemo.junit.employeeInfo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.SerenityApiDemo.cucumber.serenity.EmployeeSerenitySteps;
import com.SerenityApiDemo.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;


@UseTestDataFrom("C:\\Users\\ivc17242adm\\eclipse-workspace\\SerenityApiDemo\\src\\test\\resources\\testdata\\employeesInfo.csv")
@RunWith(SerenityParameterizedRunner.class)//this annotation is enabling the serenity to run many times 
//on cvs how many information is provided
@Ignore
public class CreateEmployeeDataDriven extends TestBase{
	
	
	private String firstName;
	public String getEmployee_name() {
		return firstName;
	}
	public void setEmployee_name(String firstName) {
		this.firstName = firstName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
//	public EmployeeSerenitySteps getSteps() {
//		return steps;
//	}
//	public void setSteps(EmployeeSerenitySteps steps) {
//		this.steps = steps;
//	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int salary;
	private int age;
	
	
	@Steps
	EmployeeSerenitySteps steps;
	@Title("DataDriven test for adding multiple to the employees")
	@Test
	public void createMultipleEmployees() {
		steps.createEmployee(firstName, salary, age).statusCode(201);
		
		
	}

}
