package DatePickerPractice;

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

import GoogleHomeworks.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class B {
	WebDriver driver;
	TestUtilities utils;

  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	 // opt.addArguments("--headless=new");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
  }

 
	
  @Test(priority=1)
  public void A() {
	  
	  driver.get("https://jqueryui.com/datepicker/");
	  System.out.println(driver.getTitle());
	  driver.manage().window().maximize();
	  
  }
  
  @Test(priority=2)
  public void B()
  {
	 A(); 
	 
	 driver.switchTo().frame(0);
	
	 
	 /*String year="2025";
	 String month="May";
	 String date="17";*/
	 
	  String year="2025";
	  String month="May";
	  String date="16";	
	 
	 driver.findElement(By.xpath("//input[@id='datepicker']")).click();
	 System.out.println("Datepicker box clicked");
	 
	 while(true) 
	 {
		String currentmonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String currentyear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
		if(currentmonth.equals(month) && currentyear.equals(year)){		
			break;
		}
		 
		 
		   driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//Next
		 //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//previous
	 }
	 
		 List<WebElement>alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		 
		 for(WebElement dt:alldates)                             
		 {
			if(dt.getText().equals(date)) 
			{
			    dt.click();
			    System.out.println("Selected date: " + date +" " + month +" "+ year);			                     
			    break;
			}
			 
		 }
			 
	 }
 
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
