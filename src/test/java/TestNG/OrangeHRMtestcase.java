package TestNG;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



/*
1) Open application
2) test logo presence
3) login
4) close
*/



public class OrangeHRMtestcase {
	

  WebDriver driver;
	
	@Test(priority=1)
	void openapp()
	{
     driver=new ChromeDriver();	 
	 driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();		
		
	}
	
	@Test(priority=2)
	void testlogo() throws Exception
	{
		Thread.sleep(3000);
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo is Displayed..."+status);
	}
	
	@Test(priority=3)
	void login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority=4)
	void Close()
	{
		driver.quit();
	}
	
	
	









}