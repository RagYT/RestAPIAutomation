package com.studentapp.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.studentapp.model.StudentPojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class MyFirstTestTwo extends TestBase{
	
	@Disabled
	@Test
	public void getAllDetails() {
		given()
		.when()
		.get("/list")
		.prettyPrint();
	}
	
	// Creating and adding data to the payload
	@Disabled
	@Test
	public void createStudent() {
		String payload ="{\"firstName\":\"Test\",\"lastName\":\"two\",\"email\":\"test2@gmail.com\",\"programme\":\"Computer Science\",\"courses\":[\"Java\",\"Python\"]}";
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.body(payload)
		.post()
		.then()
		.statusCode(201); //for new data creation status code is 201
	}

	@Disabled
	@DisplayName("Create new student by sending payload as object")
	@Test
	public void createStudentByPojoPayload() {
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
		.when()
		.contentType(ContentType.JSON)
		.when()
		.body(stud)
		.post()
		.then()
		.statusCode(201);
	}
	
	@Disabled
	@DisplayName("Create new student with instant fake data")
	@Test
	public void studentPojoWithJavaFakeApi() {
		
		List<String> course = new ArrayList<String>();
		course.add("C");
		course.add("C++");
		
		Faker fake = new Faker();
		
		StudentPojo sPojo = new StudentPojo();
		sPojo.setFirstName(fake.name().firstName());
		sPojo.setLastName(fake.name().lastName());
		sPojo.setEmail(fake.internet().emailAddress());
		
		sPojo.setProgramme("Computer");
		sPojo.setCourses(course);
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.body(sPojo)
		.post()
		.then()
		.statusCode(201);
	}
	
	@Disabled
	@DisplayName("Update particular student data")
	@Test
	public void updateParticularStudentData() {
		
		List<String> course = new ArrayList<String>();
		course.add("C");
		course.add("Java");
		
		Faker fake = new Faker();
		
		StudentPojo sPojo = new StudentPojo();
		sPojo.setFirstName(fake.name().firstName());
		sPojo.setLastName(fake.name().lastName());
		sPojo.setEmail(fake.internet().emailAddress());
		
		sPojo.setProgramme("Science");
		sPojo.setCourses(course);
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.body(sPojo)
		.put("/101") // instead of post use put and provide the id to update
		.then()
		.statusCode(200); // for update status code is 200
	}
	
	@Disabled
	@DisplayName("Update Partial information student data")
	@Test
	public void updatePartialInfoInStudentData() {
		
		
		Faker fake = new Faker();		
		StudentPojo sPojo = new StudentPojo();

		sPojo.setEmail(fake.internet().emailAddress());

		
		given()
		.when()
		.contentType(ContentType.JSON)
		.body(sPojo)
		.patch("/101") // instead of put use patch and provide the id to update
		.then()
		.statusCode(200); 
	}
	
	@Disabled
	@DisplayName("Delete particular id in student data")
	@Test
	public void deleteSingleStudentData() {
		
		given()
		.when()
		.contentType(ContentType.JSON)
		.delete("/101")
		.then()
		.statusCode(204);  // for delete status code is 204
	}
}
