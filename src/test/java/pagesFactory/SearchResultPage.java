package pagesFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath="//*[@id='search']/span/div/h1/div/div[1]/div/div/span[3]")
	WebElement searchResultHeaderMsg;
	@FindBy(xpath="//span[text()='No results for ']")
	WebElement noResultHeaderMsg;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateSearchResultHeaderMsgDisplay() {
		return searchResultHeaderMsg.isDisplayed();
	}
	
	public boolean validateSearchResultProductTxt(String product) {
		return searchResultHeaderMsg.getText().contains(product);
	}
	
	public String actualSearchResultPageTitle() {
		return driver.getTitle();
	}
	
	public String expectedSearchResultPageTitle(String product) {
		String expectedPageTitle = "Amazon.com : ".concat(product);
		return expectedPageTitle;
	}
	
	public boolean validateNoResultHeaderMsgDisplay() {
		return noResultHeaderMsg.isDisplayed();
	}
	
	public boolean validateNoResultHeaderProductNameDisplay(String invalidProduct) {
		WebElement noResultHeaderProductName = driver.findElement(By.
				xpath("//span[text()='" + invalidProduct + "']"));
		return noResultHeaderProductName.isDisplayed();
	}

}
