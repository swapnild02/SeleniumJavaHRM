package com.OrangeHRM.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mousehover extends Base {
	WebDriver driver;
	Actions act;
	public Mousehover(WebDriver driver){
		this.driver=driver;
	}
	
	public void mouseHover(WebElement element){
		act=new Actions(driver);
		act.moveToElement(element).perform();
	}

}
