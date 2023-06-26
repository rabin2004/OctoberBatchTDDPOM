package dataPkg;

import org.testng.annotations.DataProvider;

public class NegativeSearchFunctionalityTestData {
	
	@DataProvider
	public String[] negativeSearchData() {
		String[] data = {	"@(*&@*$#@#&*(&*23482394823482",
//							"@(*&@*$#@#&*(&*23482394823481",
//							"@(*&@*$#@#&*(&*23482394823483"
				};
		return data;
	}
	

}
