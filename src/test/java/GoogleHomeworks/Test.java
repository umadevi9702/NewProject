package GoogleHomeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		
		
		
		
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});//Enabling Automated wording
		WebDriverManager.chromedriver().setup();		
		//ChromeDriver driver=new ChromeDriver(option);//No need to write this one, if write WebDrivermanager to setup the chromedriver;
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://google.com");
		System.out.println("Messsage.." +driver.getTitle());
		driver.manage().window().maximize();
		
		
		
		
		
		
		
		
		
		
		

	}

}
