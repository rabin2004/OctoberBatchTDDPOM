package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pagesFactory.CommonFunctionalities;
import pagesFactory.LoginFunctionalityPage;

public class LoginFunctionalityTest extends BaseClass {
	CommonFunctionalities cf;
	LoginFunctionalityPage lfp;
	
	@BeforeMethod(alwaysRun=true)
	public void loadApp() {
		initialization();
		cf = new CommonFunctionalities();
		lfp = new LoginFunctionalityPage();
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		tearDown();
	}
	
	@Test(dataProviderClass=dataPkg.LoginFunctionalityData.class, 
			dataProvider="negativeLoginCredentials", 
			groups= {"Regression Test","E2E Test", "Integration Test"})
	  public void negativeLoginFunctionalityTest(String invalidUsername, String invalidPassword) {
		  	lfp.clickAccountListLink();
			lfp.enterUsername(invalidUsername);
			lfp.clickContinueBtn();
			lfp.enterPassword(invalidPassword);
			lfp.clickSignInBtn();
			Assert.assertTrue(lfp.validateVisibilityOfLoginWarningMsg());
			Assert.assertTrue(lfp.validateVisibilityOfLoginErrorMsg());
	  }
	
	@Test(dataProviderClass=dataPkg.LoginFunctionalityData.class, 
			dataProvider="negativeLoginCredentials", 
			groups= {"Regression Test","E2E Test", "Integration Test"})
	  public void negativeLoginFunctionalityTestUsingKeyboardKeys(String invalidUsername, String invalidPassword) {
		  	lfp.clickAccountListLink();
			lfp.enterUsername(invalidUsername);
			cf.hitEnterKey();
			lfp.enterPassword(invalidPassword);
			cf.hitEnterKey();
			Assert.assertTrue(lfp.validateVisibilityOfLoginWarningMsg());
			Assert.assertTrue(lfp.validateVisibilityOfLoginErrorMsg());
	  }
	
	// Test method accepting parameter from XML file -> need to use @Parameters
//	@Parameters({"invalidUsername","invalidPassword"})
//	@Test(groups= {"Regression Test","E2E Test", "Integration Test"})
//	  public void negativeLoginFunctionalityTestUsingXMLparameters(String invalidUsername, 
//			  String invalidPassword) {
//		  	lfp.clickAccountListLink();
//			lfp.enterUsername(invalidUsername);
//			cf.hitEnterKey();
//			lfp.enterPassword(invalidPassword);
//			cf.hitEnterKey();
//			Assert.assertTrue(lfp.validateVisibilityOfLoginWarningMsg());
//			Assert.assertTrue(lfp.validateVisibilityOfLoginErrorMsg());
//	  }

}
