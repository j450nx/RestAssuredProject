import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
public class JSONSchemaValidator {

	@Test
	public void testGet() {
		
		baseURI = "http://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			assertThat().
			body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("Michael", "Lindsay"));
	}
}
