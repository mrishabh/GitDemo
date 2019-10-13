package stepDefination;

import org.junit.Assert;

import cucumber.api.java.en.And;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.Landingpage;
import pageObjects.Loginpage;
import pageObjects.portalHomePage;
import resources.base;

public class stepDefination extends base{
	
	@Given("^Intialize the browser with chrome$")
	public void intialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=intializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(arg1);
	}

	@Given("^Click on Login link in Home psge to land on Secure sign in Page$")
	public void click_on_Login_link_in_Home_psge_to_land_on_Secure_sign_in_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Landingpage l=new Landingpage(driver);
		if(l.getPopUpSize()>0)
		{
			l.getPopUp().click();
		}
		l.getLogin().click();
	}
	
	@When("^User enters (.+) and (.+)and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		Loginpage lp=new Loginpage(driver);
		lp.getemail().sendKeys(username);
		lp.getpassword().sendKeys(password);
		lp.getLogin().click();
    }

	

	@Then("^Verify that user is succefully logged in$")
	public void verify_that_user_is_succefully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		portalHomePage p= new portalHomePage(driver);
	   Assert.assertTrue(p.getsearchBox().isDisplayed());
	   
		}

	
	   @And("^Close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	        
	    }

}
