package demo;
import org.testng.annotations.DataProvider;

public class DataForTests {
	
	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost() {
		return new Object[][] {
			{"Grandfather", "Peter", 2},
			{"Grandmother", "Tracy", 1},
			{"Grandpa", "Holiday", 1},
			{"Grandma", "Ming", 2}
		};
	}
	
	@DataProvider(name = "DataForDelete")
	public Object[] dataForDelete() {
		return new Object[] {
				8, 9, 10, 11
		};
	}
}
