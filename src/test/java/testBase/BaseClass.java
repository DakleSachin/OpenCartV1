package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	  
	  @BeforeClass (groups={"sanity", "Regression", "Master"})
	  @Parameters({"os","browser"})
	  public void setup(String os, String br) throws IOException, InterruptedException {
		  
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		  
		logger=LogManager.getLogger(this.getClass());
		
		switch( br.toLowerCase()) {
		
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		
		default : System.out.println("Invalid browser name..."); break;
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();	
		
		Thread.sleep(3000);
	}
	
	  @AfterClass (groups={"sanity", "Regression", "Master"})
	  public void tearDown() {
	    driver.quit();
	}
	  
	  

		public String captureScreen(String tname) throws IOException
		{
			
			String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=(System.getProperty("user.dir")+"/Screenshots/"+ tname + ".png");
			File targetFile=new File (targetFilePath);
			source.renameTo(targetFile);
			return targetFilePath;
		}
	
	
	
    public String rnadomeString() {
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	return generatedstring;
}

    public String rnadomeNumber() {
	String generatednumber=RandomStringUtils.randomNumeric(10);
	return generatednumber;
}


    public String rnadomeAlphaNumeric() {
	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	String generatednumber=RandomStringUtils.randomNumeric(10);
	return (generatedstring+"@"+generatednumber);
}
                       

}
