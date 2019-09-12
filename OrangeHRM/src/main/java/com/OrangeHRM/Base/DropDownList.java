package com.OrangeHRM.Base;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownList extends Base {
	WebDriver driver;
	public DropDownList(WebDriver driver){
		this.driver=driver;
	}
	Select select;
	public void selectByVisibleText(WebElement element,String text){
		select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element,int Index){
		select=new Select(element);
		select.selectByIndex(Index);
	}
	
	public void selectByValue(WebElement element,String text){
		select=new Select(element);
		select.selectByValue(text);
	}
	public List<WebElement> getOptions(WebElement element,String text){
		select=new Select(element);
		List<WebElement> totalOption=select.getOptions();
		return totalOption;
	}
	

}
