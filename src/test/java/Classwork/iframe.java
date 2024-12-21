package Classwork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframe {
  @Test
  public void f() {
	  
	  
	          // Set up WebDriver
	          WebDriverManager.chromedriver().setup();
	          WebDriver driver = new ChromeDriver();

	          try {
	              // Open the Google page or the URL with the iframe
	              driver.get("https://www.google.com/");
	              driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	              // Switch to the iframe containing the "Stay signed out" button
	              WebElement iframe = driver.findElement(By.xpath("//iframe[contains(@src, 'stay-signed-out')]"));
	              driver.switchTo().frame(iframe);
	              System.out.println("Switched to iframe");

	              // Locate and click the "Stay signed out" button
	              WebElement staySignedOutButton = driver.findElement(By.xpath("//button[text()='Stay signed out']"));
	              staySignedOutButton.click();
	              System.out.println("Clicked 'Stay signed out'");

	              // Switch back to the main content
	              driver.switchTo().defaultContent();
	              System.out.println("Switched back to default content");
	          } 
	          catch (Exception e) 
	          {
	              e.printStackTrace();
	          } 
	          
	         /* finally {
	              // Close the browser
	              driver.quit();
	          }*/
	          
	      }
	  

	  
	  
	  
	  
	  
  }
  
  
  
  
  
  
  
  
  
  
  
  

