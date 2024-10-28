package TestNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testautomationpractice {
	
	WebDriver driver;

	
	@Test(priority=1)
	void openurl()
	{
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	} 
	
	@Test(priority=2)
	void checklogo()
	{
		String act_title=driver.getTitle();
		if (act_title.equals("Automation Testing Practice"))
		{
			System.out.println("Title got checked.........");
		}
		else
		{
			System.out.println("Test Fail");
		}
	}
	
	
	@Test(priority=3)
	void close()
	{
		driver.quit();
	}
	 

  
	
  
  
  
  
  
  
}
