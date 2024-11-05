package GoogleHomeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Headlessbrowsertest {

	public static void main(String[] args) {
		
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--headless=new");//Headless browser testing
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});//Enabling Automated wording
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://google.com");
		System.out.println("URL returned");
		driver.manage().window().maximize();
		System.out.println("window maximized");
		//driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
