package Classwork;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;

public class Day1_Classwork {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		// Open Url https://demo.opencart.com/
		driver.get("https://demo.opencart.com/");
		
		//Validate title should be "Your Store"
		
		String act_title=driver.getTitle();
		if (act_title.equals("Your Store"))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		//Close the browser
		driver.quit();

	}

}
