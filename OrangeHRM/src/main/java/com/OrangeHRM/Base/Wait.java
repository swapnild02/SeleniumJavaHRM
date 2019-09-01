package com.OrangeHRM.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait extends Base {
	WebDriver driver;
	WebDriverWait webdriverwait;
	
	public Wait(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void visibilityOf(WebElement element,int Time){
		webdriverwait=new WebDriverWait(driver, Time);
		webdriverwait.until(ExpectedConditions.visibilityOf(element));
		
	}public void elementToBeClickable(WebElement element,int Time){
		webdriverwait=new WebDriverWait(driver, Time);
		webdriverwait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

}
