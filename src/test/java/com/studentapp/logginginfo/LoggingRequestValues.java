package com.studentapp.logginginfo;

import org.junit.jupiter.api.Test;

import com.studentapp.model.StudentPojo;
import com.studentapp.tests.TestBase;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class LoggingRequestValues extends TestBase{
	
	@Test
	public void test01() {
		System.out.println("Printing request headers");
		given()
		.log()
		.headers()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void test02() {
		System.out.println("Printing request Parameters");
		given()
		.param("programme", "Computer Science") //This is request parameter
		.queryParam("limit", 1)  // This is query parameter
		.log()
		.parameters()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void test03() {
		StudentPojo stud = new StudentPojo();
		
		List<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("goland");
		
		stud.setFirstName("Rag");
		stud.setLastName("test");
		stud.setEmail("rag@test.com");
		stud.setProgramme("Computer Science");
		stud.setCourses(course);
		
		given()
		.log()
		.body()
		.when()
		.contentType(ContentType.JSON)
		.body(stud)
		.post()
		.then()
		.statusCode(201);
	}
	
	@Test
	public void test04() {
		
		System.out.println("Printing all request logs");
		StudentPojo stud = new StudentPojo();
		
		List<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("goland");
		
		stud.setFirstName("Rag04");
		stud.setLastName("test04");
		stud.setEmail("rag04@test.com");
		stud.setProgramme("Science 04");
		stud.setCourses(course);
		
		given()
		.log()
		.all()
		.when()
		.contentType(ContentType.JSON)
		.body(stud)
		.post()
		.then()
		.statusCode(201);
	}

	@Test
	public void test05() {
		
		System.out.println("Printing request logs only if request fails");
		StudentPojo stud = new StudentPojo();
		
		List<String> course = new ArrayList<String>();
		course.add("Java");
		course.add("goland");
		
		stud.setFirstName("Rag04");
		stud.setLastName("test04");
		stud.setEmail("rag04@test.com");
		stud.setProgramme("Science 04");
		stud.setCourses(course);
		
		given()
		.log()
		.ifValidationFails()
		.when()
		.contentType(ContentType.JSON)
		.body(stud)
		.post()
		.then()
		.statusCode(201); //since same data added in prev test, it fails with 500 error state
	}
}
