package com_tutorialninja_qa_testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_tutorial_ninja.Utility;
import com_tutorialninja_qa_base.Base;

public class Register extends Base {
	
	WebDriver driver;
	
 	
	
	@Test(priority = 1)
	public void verifyMandatoryFieldWithVallidCredential() {
		
		driver=initializedBrowserAndOpenApplicationURL("edge");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();  
        driver.findElement(By.id("input-firstname")).sendKeys("Prawin");
        driver.findElement(By.id("input-lastname")).sendKeys("kumar");
        driver.findElement(By.id("input-email")).sendKeys(Utility.generateEmailWithTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys("8757104019");
        driver.findElement(By.id("input-password")).sendKeys("Prawin@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Prawin@123");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
       
        String actualheading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(actualheading, "Your Account Has Been Created!","account created");
        
        driver.quit();
        
	}
	@Test(priority = 2)
	public void VerifyingTheRegisterByGivingField() {
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Prawin");
        driver.findElement(By.id("input-lastname")).sendKeys("kumar");
        driver.findElement(By.id("input-email")).sendKeys(Utility.generateEmailWithTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys("8757104019");
        driver.findElement(By.id("input-password")).sendKeys("Prawin@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Prawin@123");
        driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        String actualheading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(actualheading, "Your Account Has Been Created!","account created");
        
        driver.quit();
       
		}
	   
	@Test(priority = 3)
	  public void VerifyingAccountWithExistingEmail() {
		  
		  WebDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        
	        driver.get("https://tutorialsninja.com/demo/");
	        driver.findElement(By.xpath("//a[@title='My Account']")).click();
	        driver.findElement(By.linkText("Register")).click();
	        driver.findElement(By.id("input-firstname")).sendKeys("PRAWIN");
	        driver.findElement(By.id("input-lastname")).sendKeys("KUMAR");
	        driver.findElement(By.id("input-email")).sendKeys(Utility.generateEmailWithTimeStamp());
	        driver.findElement(By.id("input-telephone")).sendKeys("8757104019");
	        driver.findElement(By.id("input-password")).sendKeys("Prawin@123");
	        driver.findElement(By.id("input-confirm")).sendKeys("Prawin@123");
	        driver.findElement(By.xpath("//input[@name='newsletter'][@value=0]")).click();
	        driver.findElement(By.name("agree")).click();
	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
	        String actaulWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		    Assert.assertEquals(actaulWarning, "Warning: E-Mail Address is already registered!","Warning msg is not display");
		    
		    
	        driver.quit();
		  
	  }
	
        
  }
	

