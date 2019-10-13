package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Loginpage;
import resources.base;

public class HomePage extends base {
	public static Logger Log=LogManager.getLogger(base.class.getName());
	@BeforeTest	
	public void initialize() throws IOException
	{
		driver=intializeDriver();
		
	}	
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String password,String text) throws IOException
	{
				
		driver.get(prop.getProperty("url"));
		Landingpage l=new Landingpage(driver);
		l.getLogin().click();
		
		Loginpage lp=new Loginpage(driver);
		lp.getemail().sendKeys(username);
		lp.getpassword().sendKeys(password);
		
		Log.info(text);
		
		lp.getLogin().click();
		}
	
		
	
      @DataProvider
      public Object[][] getData()
      {
    	  // Row stands for how many different data type test should run
    	  //colum stands for how many values per each test
    	 Object[][] data=new Object[2][3];
    	 data[0][0]="nonrestricted@qa.com";
    	 data[0][1]="12345";
    	 data[0][2]="Restriciteduser";
    	 
         data[1][0]="restricted@qa.com";
         data[1][1]="34567";
         data[1][2]="non restricteduser";
    	
    	 return data;
      }
      
      
      @AfterTest
  	public void teardown()
  	{
  		driver.close();
  		driver=null;
  	}
         
	
}
