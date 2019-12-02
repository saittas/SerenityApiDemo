package com.SerenityApiDemo.testbase;

import org.junit.BeforeClass;
import org.junit.Ignore;

import io.restassured.RestAssured;

public class TestBase {
@BeforeClass
public static void init() {
	//RestAssured.baseURI="http://dummy.restapiexample.com";
	RestAssured.basePath="/api/v1";
	
}
}
