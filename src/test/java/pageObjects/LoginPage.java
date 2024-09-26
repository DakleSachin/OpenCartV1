package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver)
	{
		super (driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement idkLoginEmail;
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement idkLoginPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnLoginSubmit;
	
	
	
	public void setLoginEmail (String LoginEmail)
	{
		idkLoginEmail.sendKeys(LoginEmail);
	
	}
	
	public void setLoginPassword (String LoginPass)
	{
		idkLoginPassword.sendKeys(LoginPass);
	}
	
	public void ClickLoginSubmit()
	{
		btnLoginSubmit.click();
	}
}
