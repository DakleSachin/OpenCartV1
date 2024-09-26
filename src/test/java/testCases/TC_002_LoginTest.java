package testCases;



import org.junit.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity", "Regression", "Master"})
	public void verify_account_Login () {
		
		logger.info("*** Starting TC_002_LoginTest ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on my account Link.....");
		hp.ClickLogin();
		logger.info("Clicked on Login link..... ");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setLoginEmail(p.getProperty("email"));
		logger.info("Login Email will be enter.... ");
		lp.setLoginPassword(p.getProperty("password"));
		logger.info("Login password will be enter....");
		lp.ClickLoginSubmit();
		logger.info("Clicked on submit button..... ");
		
		MyAccountPage myac=new MyAccountPage(driver);
		
		boolean myacc=myac.isMyAccountPageExeists();
	
		Assert.assertEquals(myacc, true);
		
		System.out.println("Account Login Sucessfully... ");
		}
		catch(Exception e)
		{
			Assert.fail();
			System.out.println("Account Login Failed... ");
		}
		
		logger.info("*** Finished TC_002_LoginTest *** ");
		
	}
	

}
