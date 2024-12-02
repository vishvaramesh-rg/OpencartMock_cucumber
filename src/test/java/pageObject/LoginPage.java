package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-email']")   WebElement inp_email_loc;
	@FindBy(xpath="//input[@id='input-password']")   WebElement inp_pass_loc;
	@FindBy(xpath="//input[@value='Login']")   WebElement inp_log_loc;
	@FindBy(xpath="//h2[normalize-space()='My Account']")  WebElement h2_myaccount_loc;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")  WebElement btn_logout_loc;
	
	
	//actions
	public void setUsername(String user) {
		inp_email_loc.sendKeys(user);
	}
	
	public void setPassword(String pass) {
		inp_pass_loc.sendKeys(pass);
	}
	
	public void clickLogin() {
		inp_log_loc.click();
	}
	
	public boolean verifylogin() {
		boolean displayed = h2_myaccount_loc.isDisplayed();
		return displayed;
	}
	
	public void clickLogout() {
		btn_logout_loc.click();
	}

}
