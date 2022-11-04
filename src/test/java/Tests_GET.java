import org.testng.Assert;
import org.testng.annotations.Test;
// static import
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class Tests_GET {

	String request = "https://reqres.in/api/users?page=2";
	
	@Test
	public void test_1() {
		given()
			.header("Content-Type","application/json")
			.get(request)
				.then()
					.statusCode(200)
					.body("page", equalTo(2))
					.body("per_page", equalTo(6))
					.body("total", equalTo(12))
					.body("total_pages", equalTo(2))
					.body("data[1].id", equalTo(8))
					.body("data[0].first_name", equalTo("Michael"))
					.body("data.last_name", hasItems("Lawson", "Ferguson"))
					.log().all();
	}
}
