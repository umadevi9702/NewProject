package TestNG;

import org.testng.annotations.Test;

public class Firsttestcase {
	
	
	/*
	   Open app
	   Login
	   Logout
	 */
	

	
	
	
	
	@Test(priority=1)
	void Openapp()
	{
		System.out.println("Open app...");
	}
	
	@Test(priority=2)
	void Login()
	{
		System.out.println("Loging the application...");
	}
	@Test(priority=3)
	void Logout()
	{
		System.out.println("Logout the application.....");
	}
	
	
	
	
	
	
	
	
	
	
	

}
