/* Prerequisites
 * npm install -g json-server
 * json-server --watch db.json
 */

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ExamplesOnLocalAPI {
	
	static String baseUrl = "http://localhost:3000/";


	@Test
	public void test_get() {
		baseURI = baseUrl;
		given().
			param("name", "Automation").
			get("subjects").
		then().
			statusCode(200).
			log().all();
	}
	
//	@Test
	public void test_post() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Jaycee");
		request.put("lastName", "Liu");
		request.put("subjectId", 1);

		baseURI = baseUrl;
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("users").
		then().
			statusCode(201).
			log().all();
	}
	
//	@Test
	public void test_patch() {
		JSONObject request = new JSONObject();
		request.put("lastName", "Lieu");

		baseURI = baseUrl;
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("users/4").
		then().
			statusCode(200).
			log().all();
	}
	
//	@Test
	public void test_put() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Bernice");
		request.put("lastName", "Liu");
		request.put("subjectId", 1);

		baseURI = baseUrl;
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("users/4").
		then().
			statusCode(200).
			log().all();
	}
	
//	@Test
	public void test_detele() {
		baseURI = baseUrl;
		given().
		when().
			delete("users/4").
		then().
			statusCode(200);
	}
}
