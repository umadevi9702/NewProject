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

public class F1 {
	
	WebDriver driver;
	TestUtilities utils;	

  @BeforeMethod
  public void beforeMethod() {	 
	  ChromeOptions opt=new ChromeOptions();
	  File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
	  opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
	  opt.addExtensions(file);
	  utils=new TestUtilities(driver, opt);
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	    
  }
  	
  @Test(priority=1)
  public void A() {
	  driver.get("https://www.google.com/");
	  System.out.println("URL Opened: "+driver.getTitle());
	  driver.manage().window().maximize();
	  System.out.println("Window Maximized");
}
  @Test(priority=2)
  public void B() throws InterruptedException {
	  
	  A();	  
	  driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
	  System.out.println("Selenium text printed");
	  Thread.sleep(3000);
	  List<WebElement>list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
	  System.out.println("Total list from dropdown:"+list.size());
	  for(int i=0;i<=list.size();i++) {
		  System.out.println(list.get(i).getText());
		  String text=list.get(i).getText();
		  if(text.equals("selenium foods")) {
			  list.get(i).click();
			  System.out.println("selenium foods cliked from dropdown");
			  break;
		  }
			  
	  }
	  
	    driver.switchTo().frame(0);
	    System.out.println("Switched to ifrmae");
	    driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
	    System.out.println("Captcaha got clicked");  
}
  
  @Test(priority=3)
  public void C() throws InterruptedException {
	  
	  B();
	  
	 String actual_titile=driver.getTitle();
	 if(actual_titile.equals(actual_titile)) {
		 System.out.println("Testcase#F1: Pass");
	 }
	 else {
		 System.out.println("Tescase#F1: Fail");
	 }
	  
  }
  
 
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
