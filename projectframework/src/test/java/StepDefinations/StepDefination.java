package StepDefinations;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import ConstantsData.Constants;
import PageRepositry.LogOut;
import PageRepositry.LoginPage;
import PageRepositry.NewAccountCreation;
import PageRepositry.NewCustomerPage;
import Utilites.BaseClass;
import Utilites.FetchCustomerIdFromExcel;
import Utilites.StoreAccountIdToExcel;
import Utilites.StoreCustomerIdToExcel;
import Utilites.WriteDataToExcel;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseClass {
	WebDriver driver =BaseClass.initializationDriver();
	LoginPage obj =new LoginPage(driver);
	NewCustomerPage obj1 =new NewCustomerPage(driver);
	NewAccountCreation obj2=new NewAccountCreation(driver);
	LogOut obj3=new LogOut(driver);
	 public static String customerId;
	
	@Given("user opens the browser URL")
	public void user_opens_the_browser_url() throws InterruptedException {
	   System.out.println(getTitle()); 
		
	}

	@Given("user enters the username as {string}")
	public void user_enters_the_username_as(String username) {
		obj.enterUserName(username);
		
	}

	@Given("user enters the password as {string}")
	public void user_enters_the_password_as(String password) {
		obj.enterPassword(password);
		
	}

	@When("user click on the login button")
	public void user_click_on_the_login_button() {
	    obj.clickLogin();
	}

	@Then("validate user navigate to the Homepage of applications")
	public void validate_user_navigate_to_the_homepage_of_applications() {
	    
		String URL1=getCurrentURL();
		if(URL1.contains("homepage")) {
			System.out.println("user navigated to correct page");
		}
		else {
			Assert.assertTrue(URL1.contains("homepage"),
			        "Page navigation is not successful");	}	
	}
	@Given("user is on the homepage of the application")
	public void user_is_on_the_homepage_of_the_application() {
		getTitle();
	    }
	@Given("user click on the new customer link")
	public void user_click_on_the_new_customer_link() {
	obj1.clickonnewcust();
	    }

	@When("user enters the customer details")
	public void user_enters_the_customer_details(io.cucumber.datatable.DataTable dataTable) {
	    
		 List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
Map<String,String>row =data.get(0);
		    obj1.enterusername(row.get("cust_name"));
            obj1.clickonGender();
		    obj1.enterdob(row.get("dob"));
		    obj1.enterAddress(row.get("address"));
		    obj1.city(row.get("city"));
		    obj1.enterstate(row.get("state"));
		    obj1.enterpin(row.get("pin"));
		    obj1.enterMobile(row.get("mobile"));

		    // dynamic email logic (your existing logic improved)
		    String dynamicEmail = row.get("email") + System.currentTimeMillis() + "@gmail.com";
		    obj1.enteremail(dynamicEmail);

		    obj1.enterpassword(row.get("password"));

		    System.out.println("Generated Email: " + dynamicEmail);
		
	}

	@Then("user caputures the customerId")
	public void user_caputures_the_customer_id()throws Exception {
		customerId = obj1.getCustomerId();
	    System.out.println("Captured Customer ID: " + customerId);

	    String filePath = "D:/Cust_Id.xlsx";

	    WriteDataToExcel.writeCustomerId(
	            filePath,
	            "Sheet1",
	            1,      // row number
	            0,      // column number
	            customerId
	    );
	
	}
	
	@When("user click on the submit button")
	public void user_click_on_the_submit_button() {
		obj1.clicksubmit();
	    }

	@Then("a new customer will be created")
	public void a_new_customer_will_be_created() {
		
	}

	
	@Given("user click on new account link")
	public void user_click_on_new_account_link() {
      obj2.clickonaccount();
	}
	@Given("user enters the customer id from excel")
	public void user_enters_the_customer_id_from_excel() throws Exception {
		 String customerId = FetchCustomerIdFromExcel.writeCustomerId(1, 0);

		    System.out.println("Customer ID from Excel: " + customerId);

		    obj2.customerId(customerId);
		    System.out.println("Customer ID before entering: " + customerId);	    
	}

	@Given("user selects account type as {string}")
	public void user_selects_account_type_as(String AccountType) {
		obj2.selectaccount(AccountType);
	
	}

	@Given("user enters initial deposit as {string}")
	public void user_enters_initial_deposit_as(String Deposit) {
	    obj2.enterammount(Deposit);
	}

	@When("user click on account submit button")
	public void user_click_on_account_submit_button() {
	   obj2.clickonsubmit();
	   scrollPage();
	}

	@Then("account should be created successfully")
	public void account_should_be_created_successfully() {
         getTitle();
	}

	@Then("user captures the account id")
	public void user_captures_the_account_id()throws Exception {
		//accountIdText
		customerId = obj2.getAccountId();
	    System.out.println("Captured Account ID: " + customerId);

	    String filePath = "D:/Cust_Id.xlsx";

	    WriteDataToExcel.writeCustomerId(
	            filePath,
	            "Sheet1",
	            2,      // row number
	            1,      // column number
	            customerId
	    );
	
	}
	@Then("verify customerId in excel sheet")
	public void verify_customer_id_in_excel_sheet() throws Exception {
	    
		String customerId = obj1.getCustomerId();
	    System.out.println("Captured Customer ID: " + customerId);

	    String path = Constants.Store_Customer_Id_Excel;

	    StoreCustomerIdToExcel.writeCustomerId(path, "Sheet1", customerId);
	}

	@Then("verify account id in excel sheet")
	public void verify_account_id_in_excel_sheet() throws Exception {
		String AccountId = obj1.getCustomerId();
	    System.out.println("Captured Customer ID: " + AccountId);

	    String path = Constants.Store_Account_Id_excel;

	    StoreAccountIdToExcel.writeCustomerId(path, "Sheet1", AccountId);
	
	}

	@Given("user enters the logout button")
	public void user_enters_the_logout_button() {
		obj3.clickLogout();
	    }

	@Given("user enters click on ok button")
	public void user_enters_click_on_ok_button() {
		obj3.clickOnOk();
	   }

	
	
	

	@Given("user verifies alert message")
	public void user_verifies_alert_message() {
		String alertText = obj3.alerthandlegettext();
	    System.out.println("Alert Message: " + alertText);
		
	
	}

	


	@Then("user closes the browser")
	public void user_closes_the_browser() throws InterruptedException {
		closeBrowser();
	   }

	}


