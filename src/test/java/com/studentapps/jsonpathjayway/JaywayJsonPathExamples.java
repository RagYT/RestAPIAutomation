package com.studentapps.jsonpathjayway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JaywayJsonPathExamples {
	
//	    git clone https://github.com/bestbuy/api-playground/
//		cd api-playground
//		npm install
//		npm start
//		# Best Buy API Playground started at http://localhost:3030
	
	static String jsonResponse;
	
	@BeforeAll
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3030;
		
		jsonResponse = given().when().get("/products").asString();
	}
	
	@Test
	public void getRoot() {
		System.out.println("Printing Root element");
		Map<String, ?> rootElement = JsonPath.read(jsonResponse, "$");
		System.out.println(rootElement.toString());
	}
	
	@Test
	public void getTotalFromResponse() {
		System.out.println("Printing total value");
		int total = JsonPath.read(jsonResponse, "$.total");
		System.out.println(total);
	}
	
	//It displays all values in data component
	@Test
	public void getAllDataElements() {
		System.out.println("Printing All data elements");
		List<HashMap<String,Object>> dataElements = JsonPath.read(jsonResponse, "$.data");
		dataElements.stream().forEach(System.out::println);
	}
	
	@Test
	public void getFirstDataElement() {
		System.out.println("Printing first data element");
		Map<String, ?> firstDataElement = JsonPath.read(jsonResponse, "$.data[0]");
		System.out.println(firstDataElement.toString());
	}

	@Test
	public void getLastDataElement() {
		System.out.println("Printing Last data element");
		Map<String, ?> lastDataElement = JsonPath.read(jsonResponse, "$.data[-1]");
		System.out.println(lastDataElement.toString());
	}
}
