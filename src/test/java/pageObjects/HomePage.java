package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy(xpath= "//a[@title='My Account']")
	WebElement inkMyaccount;
	
	@FindBy(xpath= "//a[normalize-space()='Register']")
	WebElement inkRegister;
	
	@FindBy(xpath= "//a[normalize-space()='Login']")
	WebElement inkLogin;


	
	
	public void ClickMyAccount ()
	{
		inkMyaccount.click();;
	}
	
	public void ClickRegister ()
	{
		inkRegister.click();
	}
	
	public void ClickLogin()
	{
		inkLogin.click();
	}
}
