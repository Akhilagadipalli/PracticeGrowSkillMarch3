package PageRepositry;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut {
WebDriver driver;
	
	public LogOut(WebDriver driver) 
	{
	  	this.driver =driver;
	  	PageFactory.initElements(driver, this);
	}
	public void clickLogout() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    WebElement logout = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//a[@href='Logout.php']")
	            )
	    );

	    ((JavascriptExecutor) driver)
	            .executeScript("arguments[0].click();", logout);
	}
public void clickOnOk() {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.alertIsPresent());

    Alert alert = driver.switchTo().alert();
    alert.accept();
}
public String alerthandlegettext() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.alertIsPresent());

    Alert alert = driver.switchTo().alert();

    String message = alert.getText();
    alert.accept();

    return message;
}

}

