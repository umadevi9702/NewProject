package GoogleHomeworks;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddExtensions {

	public static void main(String[] args) throws InterruptedException {
	
		ChromeOptions option=new ChromeOptions();		
		File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
		option.addExtensions(file);		
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});	
		
		
		
		//ChromeDriver driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://google.com");
		System.out.println("Message displayed: " +driver.getTitle());		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		

	


	
		
		
		
		
		
		
		
		

	}

}
