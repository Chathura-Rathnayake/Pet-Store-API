package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.example.petstore.Pet;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;

import java.util.HashMap;

import static org.hamcrest.Matchers.allOf;

@QuarkusTest
public class PetResourceTest {

	
	//TEST 01 - testing the search APIs
	//testing the API to search a pet by age
	@Test
    public void testSearchByAgeAPI() {

        given()
          .when().get("/pets/searchByAge/3")
          .then()
          .statusCode(200)
          .log()
          .all();        
        
    }
	
	//testing the API to search a pet by name
	@Test
    public void testSearchByNameAPI() {

		Response response = given()
          .when().get("/pets/searchByName/puus")
          .then()
          .extract().response();
		
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("puus", response.jsonPath().getString("petName[0]"));
        Assertions.assertEquals("6", response.jsonPath().getString("age[0]"));
        Assertions.assertEquals("cat", response.jsonPath().getString("type[0]"));
    }
	
	
	
	//TEST 02 - testing the pet API
	//testing the viewing all the pets API
	@Test
    public void testViewPetsAPI() {
		System.out.println("----------------------------");  
		System.out.println("testing the viewing pets API");  

        given()
          .when().get("/pets")
          .then()
          .statusCode(200)
          .log()
          .all();        
        
    }
	
	//testing the API to view a given pet
	@Test
    public void testViewOnePetAPI() {

		Response response = given()
          .when().get("/pets/4")
          .then()
          .extract().response();
		
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("rex", response.jsonPath().getString("petName"));
        Assertions.assertEquals("5", response.jsonPath().getString("age"));
        Assertions.assertEquals("dog", response.jsonPath().getString("type"));
    }
	
	//testing the API used to create a pet
	@Test
    public void testCreatePetAPI() {

		String payload = "{\"id\":7,"
				+ "\"petName\":\"phishy\","
				+ "\"age\":1,"
				+ "\"type\":\"fish\"}";
		
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(payload)
                .when()
                .post("/pets")
                .then()
                .extract().response();     
        
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("phishy", response.jsonPath().getString("petName"));
        Assertions.assertEquals("1", response.jsonPath().getString("age"));
        Assertions.assertEquals("fish", response.jsonPath().getString("type"));
        
    }
	
	//testing the API used to update a pet
	@Test
    public void testUpdatePetAPI() {

		String payload = "{\"id\":1,"
				+ "\"petName\":\"kittyNameUpdated\","
				+ "\"age\":11,"
				+ "\"type\":\"cat\"}";
		
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(payload)
                .when()
                .put("/pets")
                .then()
                .extract().response();     
        
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("kittyNameUpdated", response.jsonPath().getString("petName"));
        Assertions.assertEquals("11", response.jsonPath().getString("age"));
        Assertions.assertEquals("cat", response.jsonPath().getString("type"));
        
    }
	
	//testing the API used to delete a pet
	@Test
    public void testDeletePetAPI() {

        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/pets/3")
                .then()
                .extract().response();  
        
        Assertions.assertEquals(204, response.statusCode());
        
    }
	
	//TEST 03 - testing the pet-type API
	//testing the viewing all the pet types API
	@Test
    public void testViewPetTypesAPI() {
		System.out.println("----------------------------");  
		System.out.println("testing the viewing pet types API");  

        given()
          .when().get("/petType")
          .then()
          .statusCode(200)
          .log()
          .all();        
        
    }
	
	//testing the API used to update a pet type
	@Test
    public void testUpdatePetTypeAPI() {

		String payload = "{\"oldType\":\"dog\",\"newType\":\"hound\"}";
		
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(payload)
                .when()
                .put("/petType")
                .then()
                .extract().response();     
        
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("dog", response.jsonPath().getString("oldType"));
        Assertions.assertEquals("hound", response.jsonPath().getString("newType"));
        
    }
	
	//testing the API used to delete a pet type
	@Test
    public void testDeletePetTypeAPI() {

        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete("/petType/\"bird\"")
                .then()
                .extract().response();  
        
        Assertions.assertEquals(204, response.statusCode());
        
    }


}