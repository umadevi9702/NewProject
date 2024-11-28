package GoogleHomeworks;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class N {
	
	WebDriver driver;
	TestUtilities utils;
	
	@BeforeMethod
	public void A()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
		opt.addExtensions(file);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		utils=new TestUtilities(driver, opt);
	}
	
  @Test(priority=1)
  public void launchApplication() {
	  
	  driver.get("https://www.google.com/");	  
	  System.out.println("Message: "+driver.getTitle());
	  driver.manage().window().maximize();
	  System.out.println("Window maximized");
  }
  
  
  @Test(priority=2)
  public void Validate1() throws InterruptedException
  {	
	  launchApplication();
	  System.out.println("Google page opened");
	  
	  driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
	  System.out.println("selenium text printed");
	  Thread.sleep(3000);
	  List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
	  System.out.println("Total list from the dropdown:"  +list.size());
	  
	  for(int i=0;i<=list.size();i++)
	  {
		  System.out.println(list.get(i).getText());
		  String text=list.get(i).getText();
		  if(text.equals("selenium sulfide"))
		  {
			  list.get(i).click();
			  System.out.println("Message: "+driver.getTitle());
			  break;
		  }
	  }
	  
	  
	  
  }
  
  
  @Test(priority=3)
  public void Validate2() throws InterruptedException
  {
	  launchApplication();
	  System.out.println("Google url returned");
	  Validate1();
	  System.out.println("Selenium sulfide page opened");
	  
	  driver.findElement(By.xpath("//div[contains(text(),'Shopping')]")).click();
	  System.out.println("Shopping tab clicked");
	  
	  String text=driver.findElement(By.xpath("//a[@aria-label='Shopping Home']//*[name()='svg']")).getText();
	  if(text.equals(text))
	  {
		  System.out.println("Test Pass:"+driver.getTitle());
	  }
	  else 
	  {
		  System.out.println("Test Fail");
	  }
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
@AfterMethod
public void B()
{
	driver.quit();
}
  
  
  
  
  
  
  
  
  
}

