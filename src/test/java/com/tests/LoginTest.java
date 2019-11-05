package com.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
		
		WebDriver driver;
		Logger log = Logger.getLogger(LoginTest.class);	
		
		
		
		@BeforeMethod
		public void setup(){
			log.info("****************************** Starting test cases execution  *****************************************");
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://ui.freecrm.com/");
			log.info("entering application URL");
			log.warn("Hey this just a warning message");
			log.fatal("hey this is just fatal error message");
			log.debug("this is debug message");
			
}
		
		
		@Test(priority=1)
		public void loginPageTitleTest(){
			
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** freeCrmTitleTest *****************************************");
			
			String title = driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Cogmento CRM");
			
			log.info("****************************** ending test case *****************************************");
			log.info("****************************** freeCrmTitleTest *****************************************");
		}
		
		@Test(priority=2)
		public void logoTest() {
			
			log.info("****************************** starting test case *****************************************");
			log.info("****************************** freemCRMLogoTest *****************************************");
			
		driver.findElement(By.xpath("//input[@placeholder='E-mail address']")).sendKeys("manojkarmkar091@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Vicky8123");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		boolean bol = driver.findElement(By.xpath("//div[@class='header item']")).isDisplayed();
		Assert.assertTrue(bol);
		
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");

		}
		
		@AfterMethod
		public void tearDown(){
			
			driver.close();
		}	
}
