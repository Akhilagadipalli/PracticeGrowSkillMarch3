package PageRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	
	WebDriver driver;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()=\"New Customer\"]")
	WebElement clickonnewcustomer;
	@FindBy(xpath="//input[@name='name']")
	WebElement cust_name;
	
	@FindBy(xpath="//input[@name='rad1' and @value='f']")
	WebElement radioButton;
	@FindBy(xpath="//input[@value=\"m\"]")
	WebElement clickonMale;
	@FindBy(xpath="//input[@value=\"f\"]")
	WebElement clickonfMale;
	@FindBy(xpath="//input[@name='dob']")
	WebElement dob;
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement City;
	
	@FindBy (xpath="//input[@name='state']")
	WebElement state;
	
	@FindBy (xpath="//input[@name='pinno']")
	WebElement pin;
	
	@FindBy (xpath="//input[@name='telephoneno']")
	WebElement mobile;
	
	@FindBy (xpath="//input[@name='emailid']")
	WebElement emaiId;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement submit;
	
	@FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
	
	WebElement customerIdText;
	@FindBy(xpath="//td[normalize-space()='Customer ID']/following-sibling::td")
	WebElement captureCustmerId;
	
	public void clickonnewcust() {
		clickonnewcustomer.click();
	}
	public void enterusername(String cname)
	{
		
		cust_name.sendKeys(cname);
	}
	
	public void clickonGender()
	{
		radioButton.click();
		
	}
	
//	public void clickonmale()
//	{
//		clickonMale.click();
//		
//	}
//	public void clickonfmale()
//	{
//		clickonfMale.click();
//		
//	}
	
public void enterdob(String dodb) 
{
		
		dob.sendKeys(dodb);
	}
public void enterAddress(String addess) 
{
		
		address.sendKeys(addess);
	}

public void city(String city) 
{
		
		City.sendKeys(city);
	}

public void enterstate(String State) 
{
		
		state.sendKeys(State);
	}

public void enterpin(String Pin) 
{
		
		pin.sendKeys(Pin);
	}

public void enterMobile(String Mobile) 
{
		
		mobile.sendKeys(Mobile);
	}
public void enteremail(String Emailid) 
{
		
	emaiId.sendKeys(Emailid);
	}
public void enterpassword(String Pass) 
{
		
	pass.sendKeys(Pass);
	}

public void clicksubmit() 
{
		
	submit.click();
	}
public void capturecustid() {
	captureCustmerId.getText();
}

public String getCustomerId() {
    return customerIdText.getText();
}


















}
