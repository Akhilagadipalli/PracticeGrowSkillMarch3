package PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilites.BaseClass;

public class LoginPage extends BaseClass {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
	  	this.driver =driver;
	  	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name=\"uid\"]")
	WebElement username;
	
	@FindBy(xpath="//input[@type=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement submit;
	
	public void enterUserName(String usernamevalue ) {
		username.sendKeys(usernamevalue);
	}
	
	public void enterPassword(String passwordvalue) {
		password.sendKeys(passwordvalue);
	}
	
	public void clickLogin() {
		submit.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
