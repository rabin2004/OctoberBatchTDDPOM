package pagesFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class SearchFunctionalityPage extends BaseClass{
	// 1. Create webElement -> @FindBy annotations
	@FindBy(id="twotabsearchtextbox") // WebElement searchTxtBox = driver.findElement(By.id("twotabsearchtextbox"));
	WebElement searchTxtBox;
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	// 2. Initialize all the elements to the driver instance - through constructor
	public SearchFunctionalityPage() {
		PageFactory.initElements(driver, this);
	}
	
	// 3. Method creation for performing any action to the elements or page
	public void enterProductInSearchTxtBox(String product) {
		searchTxtBox.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public boolean validateSearchTxtBoxFunctional() {
		return searchTxtBox.isEnabled();
	}

}