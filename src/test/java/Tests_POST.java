import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
// static import
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Tests_POST {
	
	@Test
	public void test_1_post() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Jason");
//		map.put("job", "developer");
//		System.out.println(map);
		
//		JSONObject request = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Jason");
		request.put("job", "developer");
		
//		System.out.println(request);
//		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}
	
	@Test
	public void test_2_put() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Jason");
		request.put("job", "developer");
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void test_3_patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Jason");
		request.put("job", "developer");
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void test_4_delete() {
		when().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
