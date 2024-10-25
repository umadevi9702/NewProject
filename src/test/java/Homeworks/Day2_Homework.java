package Homeworks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2_Homework {

	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.scrumalliance.org/");
		//System.out.println("Scrum Url Opened...");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
