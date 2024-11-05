package GoogleHomeworks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class UmaPractice {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		System.out.println("Text got printed:");
		Thread.sleep(3000);
		
		List <WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		System.out.println("Total list from the dropdown:"+list.size());
		
		for(int i=0;i<=list.size();i++)
		{
			   System.out.println(list.get(i).getText());
			   
			    String text=list.get(i).getText();
			    		
			    		if(text.equals("selenium foods"))
			    		{
			    			list.get(i).click();
			    			System.out.println("Test Pass...");
			    			break;
			    		}			    		
				
		}
		
		driver.quit();
	
	}

}
