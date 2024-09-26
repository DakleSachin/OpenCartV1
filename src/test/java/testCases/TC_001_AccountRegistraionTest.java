package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistraionTest<AccountRegistation> extends BaseClass {
	
	
	
	@Test(groups= {"Regression", "Master"})
	public void verify_account_registation() {
		

		
		logger.info("****** Starting TC_001_AccountRegistraionTest ****** ");
		
		try {
		
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("* Clicked on MyAccount Link * ");
		hp.ClickRegister();
		logger.info("* Clicked on Register Link * ");
		
		AccountRegistrationPage rp=new AccountRegistrationPage (driver);
		
		logger.info("* Provide registation info * ");
		
		rp.setFirstName(rnadomeString().toUpperCase());
		logger.info("* First Name * ");
		rp.setLastName(rnadomeString().toUpperCase());
		logger.info("* Last Name * ");
		rp.setEmail(rnadomeString()+"@gmail.com");
		logger.info("* Randome Email * ");
		rp.setTelephone(rnadomeNumber());
		logger.info("* Randome Telephone Number * ");
		String password=rnadomeAlphaNumeric();
		
		rp.setpassword(password);
		rp.setConfirmPassword(password);
		logger.info("* RandomXe Password and Confirm Password * ");
		rp.setPolicy();
		logger.info("* Clicked Check Box * ");
		rp.setContinue();
		logger.info("* Submit Information * ");
		
     String confmsg= rp.getConfirmationMsg();
     
     if (confmsg.equals( "Your Account Has Been Created!")) {
 
    	 Assert.assertTrue(true);
    	 System.out.println("** Account Register Sucessfully.... **");
    	
     }else {
    	 
    	 System.out.println("**Test case is fail in browser**");
    	 logger.error("Test failed...");
		 logger.debug("Debug logs...");
    	 Assert.assertTrue(false);
    	 
     }
      
    // Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		
		logger.info("****** Finished TC_001_AccountRegistraionTest ******");
		
	}	   
		

}






































