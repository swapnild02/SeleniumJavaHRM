package com.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Base.Links;
import com.OrangeHRM.Base.Mousehover;
import com.OrangeHRM.Base.Wait;

public class HomePage extends Base {
	WebDriver driver;
	Wait wait;
	ViewSystemUsersPage viewsystemuserspage;
	Mousehover mousehover;
	WebElement element;
	LoginPage login;
	Links link;
	
	String logout_Xpath="//a[text()='Logout']";
	String Dashboard_Xpath="//h1[text()='Dashboard']";
	String link_Welcome_Xpath="//a[@id='welcome']";
	String Admin_Xpath="//b[text()='Admin']";
	String User_Managment="//a[@id='menu_admin_UserManagement']";
	String User="//a[@id='menu_admin_viewSystemUsers']";
	
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		mousehover=new Mousehover(driver);
		link=new Links(driver);
		
	}
	
	public LoginPage logout(){
		wait=new Wait(driver);
		WebElement element=driver.findElement(By.xpath(logout_Xpath));
		wait.elementToBeClickable(element, 30);
		element.click();
		login=new LoginPage(driver);
		return login;
	}
	
	public void clickOnWelcome(){
		driver.findElement(By.xpath(link_Welcome_Xpath)).click();
	}
	
	public WebElement Dashboard(){
		WebElement Dashboard=driver.findElement(By.xpath(Dashboard_Xpath));
		return Dashboard;
	}
	public String getTextDashboard(){
		WebElement Dashboard=driver.findElement(By.xpath(Dashboard_Xpath));
		String text=Dashboard.getText();
		return text;
	}
	
	public void moveToAdmin(){
		element=driver.findElement(By.xpath(Admin_Xpath));
		mousehover.mouseHover(element);
	}
	
	public void moveToUserManagment(){
		element=driver.findElement(By.xpath(User_Managment));
		mousehover.mouseHover(element);
	}
	
	public void menu_clickOnUser(){
		element=driver.findElement(By.xpath(User));
		element.click();
//		viewsystemuserspage=new ViewSystemUsersPage(driver);
//		return viewsystemuserspage;
	}
	
	public int totallinks(){
		int numberofLinks=link.totallinks();
		return numberofLinks;
		}

}
