package com.studentapp.logginginfo;

import org.junit.jupiter.api.Test;

import com.studentapp.model.StudentPojo;
import com.studentapp.tests.TestBase;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class LoggingResponseValues extends TestBase{
	
	
	@Test
	public void testResponse01() {
		System.out.println("Printing response Header");
		given()
		.when()
		.get("/list")
		.then()
		.log()
		.headers()
		.statusCode(200);
		
	}
	
	@Test
	public void testResponse02() {
		System.out.println("Printing response Status line");
		given()
		.when()
		.get("/list")
		.then()
		.log()
		.status()
		.statusCode(200);
		
	}
	
	@Test
	public void testResponse03() {
		System.out.println("Printing response Body");
		given()
		.when()
		.get("102")
		.then()
		.log()
		.body()
		.statusCode(200);
	}
	
	@Test
	public void testResponse04() {
		System.out.println("Printing response incase of an error");
		given()
		.when()
		.get("101")
		.then()
		.log()
		.ifError();
	}
}
