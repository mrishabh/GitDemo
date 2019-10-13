package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import junit.framework.Assert;
import pageObjects.Landingpage;
import resources.base;

public class validateTitle extends base {
	
	public static Logger Log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest	
	public void initialize() throws IOException
	{
		driver=intializeDriver();
		Log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home page");
	}
	
	@Test
	
	public void validateAppTitle() throws IOException
	{
				
		Landingpage l=new Landingpage(driver);
		System.out.println(l.gettitle().getText());
		Assert.assertEquals(l.gettitle().getText(), "FEATURED COURSES");
		Log.info("Succefully validated Text Message ");
				
	}
       
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
       
	
}
