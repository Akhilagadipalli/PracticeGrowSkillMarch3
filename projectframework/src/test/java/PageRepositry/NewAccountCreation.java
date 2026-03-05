package PageRepositry;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountCreation {
	
	WebDriver driver;
	
	public NewAccountCreation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=\"New Account\"]")	
	WebElement ClickOnNewAccount;
	@FindBy(xpath="//input[@name=\"cusid\"]")
	WebElement Customerid;
	@FindBy(xpath="//select[@name=\"selaccount\"]")
	WebElement SelectAccount;
	@FindBy(xpath="//input[@name=\"inideposit\"]")
	WebElement ammount;
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement submit;
	
	@FindBy(xpath="//td[text()='Account ID']/following-sibling::td")
	WebElement accountIdText;
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement CaptureAccountId;
	
	public void clickonaccount() {
		ClickOnNewAccount.click();;
	}
	public void customerId(String customerid) {
		Customerid.sendKeys(customerid);
	}
	public void selectaccount(String selectdrop) {
		 Select select = new Select(SelectAccount);
	        select.selectByVisibleText(selectdrop);
	}
	
	public void enterammount(String amount) {	
		ammount.sendKeys(amount);
	}
	public void clickonsubmit() {
		submit.click();
	}
	public void captureaccountId() {
		CaptureAccountId.getText();
	}
		
	public String getAccountId() {
	  
		return accountIdText.getText();
	}
		
		
		
		
		
		
		
		
		
		
		
	
	

}
