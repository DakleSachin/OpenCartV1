package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003_LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp)//
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
			
				
			HomePage hp=new HomePage(driver);

			hp.ClickMyAccount();
			logger.info("Clicked on my account Link.....");
			
			hp.ClickLogin();
			logger.info("Clicked on Login link..... ");
			
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setLoginEmail(email);
			logger.info("Login Email will be enter.... ");
			
			lp.setLoginPassword(password);
			logger.info("Login password will be enter....");
			
			lp.ClickLoginSubmit();
			logger.info("Clicked on submit button..... ");
			
			
			MyAccountPage myac=new MyAccountPage(driver);
			
			boolean targetPage=myac.isMyAccountPageExeists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					myac.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					myac.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}