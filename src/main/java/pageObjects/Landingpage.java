package pageObjects;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {

	public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	By NavBar=By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(signin);
	}
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	
	
	public WebElement getNavigationbar()
	{
		return driver.findElement(NavBar);
	}
	

	public int getPopUpSize()
	{
		return driver.findElements(popup).size();
	}
	
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}
	
}
