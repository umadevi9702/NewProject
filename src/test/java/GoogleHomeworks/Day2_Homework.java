package GoogleHomeworks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2_Homework {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.scrumalliance.org/");
		System.out.println("Scrum Url Opened...");
		driver.manage().window().maximize();
		
		String act_title =driver.getTitle();
		if (act_title.equals("Scrum Alliance - Find Courses for Scrum and Agile Certifications"))
		{System.out.println("Test Pass");}
		else
		{
			System.out.println("Test Fail");
		}

		
		driver.quit();
		//System.out.println("Application Closed");
		
		
		
		
		
	}

}
