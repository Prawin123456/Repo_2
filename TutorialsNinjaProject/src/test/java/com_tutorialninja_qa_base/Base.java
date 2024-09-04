package com_tutorialninja_qa_base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	WebDriver driver;
	
	public WebDriver initializedBrowserAndOpenApplicationURL(String browserName) {
		
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Edge")) {
			driver=new EdgeDriver();
		
		}else if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		}
	//	driver=new ChromeDriver();//it is not required becouse of above we have written
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://tutorialsninja.com/demo/");
		
		
		return driver;
	}
}


