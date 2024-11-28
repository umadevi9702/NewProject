package GoogleHomeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestUtilities {
	
	WebDriver driver;
	ChromeOptions opt;
	
	//Constructor
  
  public TestUtilities(WebDriver driver, ChromeOptions opt ) {	  
	 this.driver=driver;
	 this.opt=opt;	  
	  
  }
  
  public void launchApplication(String url) 
  {
	  driver.get(url);
	  driver.manage().window().maximize();
	  
  }
  
  
  
  
  
  
  
  
  
}
