package Classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop1 {

	public static void main(String[] args) {
		
		ChromeOptions opt=new ChromeOptions();
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver(opt);
	        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
            driver.manage().window().maximize();
            
            WebElement sourceelement=driver.findElement(By.id("box3"));
            WebElement targetelement=driver.findElement(By.id("box103"));
	        
	        Actions act=new Actions(driver);
	        act.dragAndDrop(sourceelement, targetelement).perform();
	        
	        String t1=targetelement.getText();
	        if(t1.equals("United States")) {
	        	System.out.println("Drag and drop successful");
	        }
	        else {
	        	System.out.println("Drag and drop Fail");
	        }
	        
	        
	        driver.quit();
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        

	}

}
