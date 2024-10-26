package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googletestcase {
	
	WebDriver driver;
	
	@Test(priority=1)
	void Openurl()
	{
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println("URL Opened....");	
		driver.manage().window().maximize();
		//driver.quit();			
	}
	
	@Test(priority=2)
	void Checklogo() 
	{
		boolean status=driver.findElement(By.xpath("//img[@alt='Google']")).isDisplayed();
	    System.out.println("Google image Displayed..."+status);	
	}
	
	@Test(priority=3)
	void Logout()
	{
		driver.quit();
		System.out.println("Window closed");
	}
	
	

}
