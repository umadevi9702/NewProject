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

public class C {
	WebDriver driver;
	TestUtilities utils;
	
 
  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	  opt.addArguments("--headless=new");
	  utils=new TestUtilities(driver, opt);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	  
  }

  @Test(priority=1)
  public void A() {
	  
	  driver.get("https://www.google.com/");
	  System.out.println("Url opened: "+driver.getTitle());
	  driver.manage().window().maximize();
  }
  
  @Test(priority=2)
  public void B() throws InterruptedException {
	  
	A();
	driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
	System.out.println("Text Printed in searchbox");
	Thread.sleep(5000);
	List<WebElement>list=driver.findElements(By.xpath("//div[contains(@class, 'wM6W7d')]//span"));
	System.out.println("Total list from dropdown: "  +list.size());
	
	
	for(int i=0;i<=list.size();i++)
	{
		System.out.println(list.get(i).getText());
		String text=list.get(i).getText();
		if(text.equals("selenium toxicity"))
		{
			list.get(i).click();
			System.out.println(driver.getTitle());
			break;
		}
		
	}
  
  }
  
  @Test(priority=3)
  public void C() throws InterruptedException {
	  
	  B();
	  String text=driver.findElement(By.xpath("//div[contains(text(),'Images')]")).getText();
	  if(text.equals("Images"))
	  {System.out.println("Test Pass: " +driver.getTitle());}
	  else
	  {System.out.println("Test Fail");}
    
  }
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
