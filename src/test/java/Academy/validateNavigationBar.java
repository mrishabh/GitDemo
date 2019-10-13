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

public class validateNavigationBar extends base {
	public static Logger Log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest	
	public void initialize() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validateAppNavBar() throws IOException
	{
		
		Landingpage l=new Landingpage(driver);		
		Assert.assertTrue(l.getNavigationbar().isDisplayed());
		Log.info("Navigationbar is displayed ");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
            
	
}
