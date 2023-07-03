package pagesFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.BaseClass;

public class LoginFunctionalityPage extends BaseClass{
	
	@FindBy(id="nav-link-accountList")
	WebElement accountListLink;
	@FindBy(name="email")
	WebElement usernameTxtField;
	@FindBy(id="continue")
	WebElement continueBtn;
	@FindBy(id="ap_password")
	WebElement passwordTxtField;
	@FindBy(id="signInSubmit")
	WebElement signInBtn;
	@FindBy(id="auth-error-message-box")
	WebElement loginErrorMsg;
	@FindBy(id="auth-warning-message-box")
	WebElement loginWarningMsg;

	public LoginFunctionalityPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickAccountListLink() {
		accountListLink.click();
	}
	
	public void enterUsername(String username) {
		usernameTxtField.sendKeys(username);;
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
	public void enterPassword(String password) {
		passwordTxtField.sendKeys(password);;
	}
	
	public void clickSignInBtn() {
		signInBtn.click();
	}
	
	public boolean validateVisibilityOfLoginWarningMsg() {
		return loginWarningMsg.isDisplayed();
	}
	
	public boolean validateVisibilityOfLoginErrorMsg() {
		return loginErrorMsg.isDisplayed();
	}

}
