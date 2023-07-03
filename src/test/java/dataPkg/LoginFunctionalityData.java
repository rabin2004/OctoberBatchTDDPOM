package dataPkg;

import org.testng.annotations.DataProvider;

public class LoginFunctionalityData {

	@DataProvider
	public String[][] negativeLoginCredentials() {
		String[][] data = {	{"test@gmail.com","test123"},
							{"test12@gmail.com","test12"}
				};
		return data;
	}
}
