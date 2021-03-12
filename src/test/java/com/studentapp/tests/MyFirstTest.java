package com.studentapp.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class MyFirstTest {
	
	private void sytles() {
		
		RestAssured.given()
				    .queryParam("", "")
				    .when()
				    .get("https://www.google.com")
				    .then();
		
		RestAssured.given()
				   .expect()
				   .then();
	}
	
	@Disabled // It wont execute this test
	@DisplayName("Getting all the details from database")
	@Test
	public void getStudentDetails() {
		
		RequestSpecification reqSpec = RestAssured.given();
		Response res = reqSpec.get("https://reqres.in/api/users/2");
		//res.prettyPrint();
		ValidatableResponse vRes = res.then();
		vRes.statusCode(200);
		
		
		RestAssured.given()
				   .when()
				   .get("https://reqres.in/api/users/2")
				   .then()
				   .statusCode(200);
				 	   
	}
	
	@Disabled 
	@DisplayName("Query Params Examples")
	@Test
	public void getSingleStudentList() {
		
		given()
		.queryParam("programme", "Computer Science")
		.queryParam("limit", 1)
		.when()
		.get("http://localhost:2020/student/list")
		.prettyPrint();
		
		// OR below, both same, storing response in object
		//------------------------------------------------
		
		
		Response res = given()
				.queryParam("programme", "Computer Science")
				.queryParam("limit", 1)
				.when()
				.get("http://localhost:2020/student/list");
		res.prettyPrint();
		
		
		// OR below, both same, Passing multiple QueryParams in single line
		//-----------------------------------------------------------------
		
		
		given()
		.queryParams("programme", "Computer Science", "limit", 1)
		.when()
		.get("http://localhost:2020/student/list")
		.prettyPrint();
		
		
		// OR below, both same, Passing queryParams as a map
		//--------------------------------------------------
		
		
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("programme", "Computer Science");
		mapObj.put("limit", 1);
		
		given()
		.queryParams(mapObj)
		.when()
		.get("http://localhost:2020/student/list")
		.prettyPrint();
		
		
		//--------------------------------------------------
	}
	
	@Disabled
	@DisplayName("Path parameters example")
	@Test
	public void pathParams() {
		given()
		.when()
		.get("http://localhost:2020/student/1")
		.prettyPrint();
		
		// Above is hardcoded
		
		given()
		.pathParam("id", 2)
		.when()
		.get("http://localhost:2020/student/{id}")
		.prettyPrint();
		
	}

}
