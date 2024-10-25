package Homeworks;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;



public class Day1_Homework {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.bankofamerica.com/?page_msg=signoff&request_locale=en_us");
		driver.manage().window().maximize();		
		String act_title =driver.getTitle();
		if (act_title.equals("Bank of America - Banking, Credit Cards, Loans and Merrill Investing"))
		{System.out.println("Test Pass");}
		else
		{
			System.out.println("Test Fail");
		}
		
		
		driver.quit();
	

	}

}
