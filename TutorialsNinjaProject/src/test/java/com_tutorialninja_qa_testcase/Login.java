 package com_tutorialninja_qa_testcase;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_tutorial_ninja.Utility;
import com_tutorialninja_qa_base.Base;

public class Login extends Base{
	WebDriver driver;
	
	@BeforeMethod
	public void Setup() {
		
		
		driver=initializedBrowserAndOpenApplicationURL("chrome");
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
	}
	@AfterMethod
	public void TearDown() {
      
		driver.quit();
	
	}
	
	@Test(priority = 1)
	public void loginWithVallidcredential() {
	    
		driver.findElement(By.id("input-email")).sendKeys("prawinkumar.222@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	
	}


@Test(priority = 2)
public void loginWithInVallidcredential() {
	
	driver.findElement(By.id("input-email")).sendKeys(Utility.generateEmailWithTimeStamp());
	driver.findElement(By.id("input-password")).sendKeys("12345");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
    Assert.assertTrue(driver.findElement(By.linkText("Edit your account information abc")).isDisplayed());

	String actualWarningmessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
    String expectedwarningMessage="Warning: No match for E-Mail Address and/or Password.";
    Assert.assertEquals(actualWarningmessage.contains(expectedwarningMessage), "Expected warning message is not display");
    
	

}
@Test(priority = 3)
public void loginWithInvalidEmailAndValidPassword() {
    
	driver.findElement(By.id("input-email")).sendKeys(Utility.generateEmailWithTimeStamp());
	driver.findElement(By.id("input-password")).sendKeys("12345");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	String actualWarningmessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
    String expectedwarningMessage="Warning: No match for E-Mail Address and/or Password.";
    Assert.assertEquals(actualWarningmessage.contains(expectedwarningMessage), "Expected warning message is not display");
	
}
@Test(priority = 4)
public void LoginWithInvalidEmailAndInvalidPassword() {
	
   
	driver.findElement(By.id("input-email")).sendKeys("prawinkumar.2221@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("123456");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	String actualWarningmessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
    String expectedwarningMessage="Warning: No match for E-Mail Address and/or Password.";
    Assert.assertEquals(actualWarningmessage.contains(expectedwarningMessage), "Expected warning message is not display");
	
	
}
     public String generateTimeStamp() {
    	 Date date=new Date();
		return date.toString().replace(":", "_");
    	 
     }
}

