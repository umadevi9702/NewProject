package Homeworks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class U_2 {
	
	
	
	 WebDriver driver;
	
	
  @Test
  void f() throws InterruptedException {
	  
	  ChromeOptions option=new ChromeOptions();
	  option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});	
	  
	  WebDriverManager.chromedriver().setup();	  
	  driver=new ChromeDriver(option);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://google.com");
	  System.out.println("Message: "+driver.getTitle());
	  
	  driver.manage().window().maximize();
	  System.out.println("Message:  Window maximized");
	  
	  driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
	  System.out.println("Text printed......");
	  Thread.sleep(3000);
	  
	  List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class, 'wM6W7d')]//span"));
	  System.out.println("Total list from the dropdown: "   +list.size());
	  
	  for(int i=0; i<=list.size(); i++)
	  {
		  System.out.println(list.get(i).getText());
		  String text=list.get(i).getText();
		  
		  if (text.equals("selenium foods"))
		  {
			  list.get(i).click();
			  break;
		  }
		  
		 
		  
	  }
	  
	  driver.quit();
	
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
}
