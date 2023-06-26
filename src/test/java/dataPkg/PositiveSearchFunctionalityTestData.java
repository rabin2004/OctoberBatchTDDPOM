package dataPkg;

import org.testng.annotations.DataProvider;

public class PositiveSearchFunctionalityTestData {
	
	@DataProvider
	public String[] positiveSearchData() {
		String[] data = {	"andriod",
//							"note",
//							"ios"
							};
		return data;
	}

}
