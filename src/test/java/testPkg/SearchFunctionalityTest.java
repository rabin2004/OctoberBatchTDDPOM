package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.BaseClass;
import pagesFactory.CommonFunctionalities;
import pagesFactory.SearchFunctionalityPage;
import pagesFactory.SearchResultPage;

public class SearchFunctionalityTest extends BaseClass{
	SearchFunctionalityPage sfp;
	SearchResultPage srp;
	CommonFunctionalities cf;
	
	@BeforeMethod(alwaysRun=true)
	public void loadApp() {
		initialization();
		sfp = new SearchFunctionalityPage();
		srp = new SearchResultPage();
		cf = new CommonFunctionalities();
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		tearDown();
	}
	
	@Test(dataProviderClass=dataPkg.PositiveSearchFunctionalityTestData.class, 
			dataProvider="positiveSearchData", enabled=false, groups= {"Regression Test","E2E Test"}) // enabled=false -> test method execution will ignored
	public void positiveSearchFunctionalityTestByClickingSearchBtn(String product) {
//		WebElement searchTxtBox = driver.findElement(By.id("twotabsearchtextbox"));
//		searchTxtBox.sendKeys(product);
		sfp.enterProductInSearchTxtBox(product);

//		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
//		searchBtn.click();
		sfp.clickSearchBtn();

//		WebElement searchResultHeaderMsg = driver
//				.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]"));
//
//		Assert.assertTrue(searchResultHeaderMsg.isDisplayed());
		Assert.assertTrue(srp.validateSearchResultHeaderMsgDisplay());
//		String searchResultProduct = searchResultHeaderMsg.getText();
//		Assert.assertTrue(searchResultProduct.contains(product));
		Assert.assertTrue(srp.validateSearchResultProductTxt(product));
		
//		String actualPageTitle = driver.getTitle();
//		String expectedPageTitle = "Amazon.com : ".concat(product);
//		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		Assert.assertEquals(srp.actualSearchResultPageTitle(), srp.expectedSearchResultPageTitle(product));
	}
	
	@Test(dataProviderClass=dataPkg.PositiveSearchFunctionalityTestData.class, 
			dataProvider="positiveSearchData", enabled=true, priority=0, 
			dependsOnMethods="validateSearchTxtBoxEnabled", groups= {"Regression Test","E2E Test"}) // dependsOnMethods -> depending will be skipped if primary method fails
	public void positiveSearchFunctionalityTestHittingEnterKey(String product) {
		sfp.enterProductInSearchTxtBox(product);
		cf.hitEnterKey();
		Assert.assertTrue(srp.validateSearchResultHeaderMsgDisplay());
		Assert.assertTrue(srp.validateSearchResultProductTxt(product));
		Assert.assertEquals(srp.actualSearchResultPageTitle(), srp.expectedSearchResultPageTitle(product));
	}
	
	// default method execution sequence -> alphabetic order by method name
	// define execution sequence -> priority=0...
	
	@Test(dataProviderClass=dataPkg.NegativeSearchFunctionalityTestData.class, 
			dataProvider="negativeSearchData", enabled=true, priority=1,
			dependsOnMethods="validateSearchTxtBoxEnabled", groups= {"Regression Test","E2E Test"})
	public void negativeSearchFunctionalityTestByClickSearchBtn(String invalidProduct) {
		sfp.enterProductInSearchTxtBox(invalidProduct);
		sfp.clickSearchBtn();
		Assert.assertTrue(srp.validateNoResultHeaderMsgDisplay());
		Assert.assertTrue(srp.validateNoResultHeaderProductNameDisplay(invalidProduct));
	}
	
	@Test(groups="Smoke Test")
	public void validateSearchTxtBoxEnabled() {
		Assert.assertFalse(sfp.validateSearchTxtBoxFunctional());
	}

}
