package Classwork;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop {

	public static void main(String[] args) {
		
		
		ChromeOptions opt=new ChromeOptions();
		File file=new File("C:\\Automation\\Myworkspaces\\Files\\CRX Files\\SelectorsHub-XPath.crx");
		opt.addExtensions(file);
		
		 WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver(opt);
	        
	        try {
	            // Navigate to the drag-and-drop demo page
	            driver.get("https://jqueryui.com/droppable/");
	            driver.manage().window().maximize();
	            
	            // Switch to the iframe containing the drag-and-drop elements
	            driver.switchTo().frame(0);
	            
	            // Locate the source (draggable) element
	            WebElement sourceElement = driver.findElement(By.id("draggable"));
	               
	            
	            // Locate the target (droppable) element
	            WebElement targetElement = driver.findElement(By.id("droppable"));
	            
	            // Perform drag-and-drop action
	            Actions actions = new Actions(driver);
	            actions.dragAndDrop(sourceElement, targetElement).perform();
	            
	            // Verify if the drop was successful
	            String targetText = targetElement.getText();
	            if (targetText.equals("Dropped!")) {
	                System.out.println("Drag and drop was successful!");
	            } else {
	                System.out.println("Drag and drop failed.");
	            }
	        } 
	        
	        finally {
	            // Close the browser
	           driver.quit();
	        }
		
		
		}

}
