package com_tutorialninja_qa_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com_tutorialninja_qa_base.Base;

public class forgatted_password extends Base{
	
	WebDriver driver;
	
	@Test
	public void RetreivePassword() {
		
	   driver=initializedBrowserAndOpenApplicationURL("chrome");
	   driver.findElement(By.partialLinkText("Forgotten Password"));
	  
	   driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("prawin@gmail.com");
	   
	   driver.findElement(By.xpath("//input[@value='Continue']")).click();
	 
	   String actualnewcustomer = driver.findElement(By.linkText("Continue")).getText();
	   Assert.assertEquals(actualnewcustomer, "new customer is found");
	   
	   
	   
	   
	}

}
