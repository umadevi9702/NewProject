package DatePickerPractice;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//import GoogleHomeworks.TestUtilities;
//import GoogleHomeworks.TestUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Aa {

	public static void main(String[] args) {
		
		WebDriver driver;
		//TestUtilities utils;
		
		
		ChromeOptions opt=new ChromeOptions();		
		File file=new File("\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
		opt.addExtensions(file);
		opt.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//utils=new TestUtilities(driver, opt);
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(opt);
		driver.get("https://jqueryui.com/datepicker/");
		System.out.println("URl opened: " +driver.getTitle());		
		driver.manage().window().maximize();
		System.out.println("Window maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		System.out.println("datepicker clicked");
		
		String year = "2025";
		String month = "May";
		String date	= "18";
		
		while(true) {
			
			String currentmonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(currentmonth.equals(month)&&currentyear.equals(year)) {
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//next button
			//System.out.println("Next button clicked");
			//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//previous button
			//System.out.println("Previous button clicked");
		}
	
		List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));
		
		for(WebElement dt:alldates) {
			
			if(dt.getText().equals(date)) {
				
				dt.click();
				System.out.println("Current result: " +date+" "+month+" "+year);
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.quit();
		System.out.println("Window closed");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
