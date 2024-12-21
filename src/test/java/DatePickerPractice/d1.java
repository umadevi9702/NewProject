package DatePickerPractice;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class d1 {

	public static void main(String[] args) {
		
		WebDriver driver;

		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		File file = new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
		opt.addExtensions(file);
		// opt.addArguments("--headless=new");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Navigate to the datepicker page
		driver.get("https://jqueryui.com/datepicker/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();

		// Desired date
		String year = "2035";
		String month = "May";
		String date = "16";

		// Switch to the frame containing the datepicker
		driver.switchTo().frame(0);

		// Open the datepicker
		driver.findElement(By.id("datepicker")).click();
		System.out.println("Datepicker opened");

		// Loop until the correct month and year are displayed
		while (true) {
		    String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		    String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

		    if (currentMonth.equals(month) && currentYear.equals(year)) {
		        // Break the loop when the correct month and year are displayed
		        break;
		    }

		    // Navigate to the next month
		    driver.findElement(By.className("ui-icon-circle-triangle-e")).click();
		}

		// Select the desired date
		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a"));

		for (WebElement dt : allDates) {
		    if (dt.getText().equals(date)) {
		        dt.click();
		        System.out.println("Selected date: " + date + " " + month + " " + year);
		        break;
		    }
		}

		// Close the browser
		driver.quit();

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	}

}
