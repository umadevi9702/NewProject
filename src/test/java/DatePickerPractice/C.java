package DatePickerPractice;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import GoogleHomeworks.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class C {
	WebDriver driver;
	TestUtilities utils;
	
	
  @Test
  public void A() {
	  
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  File file=new File("\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.addExtensions(file);
	  utils=new TestUtilities(driver, opt);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://jqueryui.com/datepicker/");
	  System.out.println("URL: "+driver.getTitle());
	  driver.manage().window().maximize();
	  
	  driver.switchTo().frame(0);//iframe switch
	  driver.findElement(By.xpath("//input[@id='datepicker']")).click();//date picker box
	  System.out.println("datepicker box cliked");
	  
	  String year="2025";
	  String month="May";
	  String date="20";
	  
	  while(true) {
		  
		 String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		 String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		 
		 if(currentmonth.equals(month)&&currentyear.equals(year)) {
			 break;
		 }
		 
		 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//Next button
		 //driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//Previous button
		  
	  }
	  
	  List<WebElement>alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
	  for(WebElement dt:alldates) {
		  
		  if(dt.getText().equals(date)) {
			  
			  dt.click();
			  System.out.println("Current date: " +month+" "+date+" "+year);
			  break;
			  
		  }
 	  
	  }
		  
	  
	  driver.quit();
	 
	  
  }
 
  
  
}
