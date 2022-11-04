package demo;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExample extends DataForTests{
	
	static String baseUrl = "http://localhost:3000/";
	
//	@DataProvider(name = "DataForPost")
//	public Object[][] dataForPost() {
//		Object[][] data = new Object[2][4];
//		data[0][0] = "Jayko";
//		data[0][1] = "Liu";
//		data[0][2] = 2;
//		
//		data[1][0] = "Uncle";
//		data[1][1] = "Sam";
//		data[1][2] = 2;
//		
//		return data;
		
//		return new Object[][] {
//			{"Grandfather", "Peter", 2},
//			{"Grandmother", "Tracy", 1},
//			{"Grandpa", "Holiday", 1},
//			{"Grandma", "Ming", 2}
//		};
//	}
	
//	@Test(dataProvider = "DataForPost")
	public void test_post(String firstName, String lastName, int subjectId) {
		JSONObject request = new JSONObject();
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);

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
	
//	@DataProvider(name = "DataForDelete")
//	public Object[] dataForDelete() {
//		return new Object[] {
//				8, 9, 10
//		};
//	}
	
//	@Test(dataProvider = "DataForDelete")
	public void test_detele(int id) {
		baseURI = baseUrl;
		given().
		when().
			delete("users/" + id).
		then().
			statusCode(200);
	}
	
	@Parameters({"id"})
	@Test
	public void test_detele2(int id) {
		baseURI = baseUrl;
		given().
		when().
			delete("users/" + id).
		then().
			statusCode(200);
	}
}
