package GoogleHomeworks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Uma1 {
	
	WebDriver driver;
	
	@Test
	void Google() throws InterruptedException
	{		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		driver.navigate().to("https://www.google.com/");
		System.out.println("URL Opened....");		
		driver.manage().window().maximize();			
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		System.out.println("Selenium text printed");			
		Thread.sleep(5000);
		
		List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		System.out.println("Total items from the dropdown:"  +list.size());		
		for(int i=0;i<=list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			 String text=list.get(i).getText();
			 
			         if(text.equals("selenium foods"))
			            {					 
				                 list.get(i).click();
				                 System.out.println("Test Pass..");
				                 break;
			           
			            }
			       		
		}
			
		
		 driver.quit();		
		
		
	}
	
	
	

}
