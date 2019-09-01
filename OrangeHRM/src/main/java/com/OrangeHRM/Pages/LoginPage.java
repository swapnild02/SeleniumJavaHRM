package com.OrangeHRM.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Base.Links;
import com.OrangeHRM.Base.Wait;


public class LoginPage extends Base {
	
	WebDriver driver;
	HomePage homepage;
	Wait wait;
	Links link;
	WebElement ele;
	String text;
	
	String titleofPage=null;
	String username_id="txtUsername";
	String password_id="txtPassword";
	String login_btn="btnLogin";
	String forgetPassword="//a[text()='Forgot your password?']";
	String logoImage="//img[@src='/orangehrm/symfony/web/webres_5d186a4a987cc7.73469913/themes/default/images/login/logo.png']";
	String linkIn="//img[@src='/orangehrm/symfony/web/webres_5d186a4a987cc7.73469913/themes/default/images/login/linkedin.png' and @alt='LinkedIn OrangeHRM group']";
	String facebook="//img[@src='/orangehrm/symfony/web/webres_5d186a4a987cc7.73469913/themes/default/images/login/facebook.png' and @alt='OrangeHRM on Facebook']";
	String twiter="//img[@src='/orangehrm/symfony/web/webres_5d186a4a987cc7.73469913/themes/default/images/login/twiter.png' and @alt='OrangeHRM on twitter']";
	String youtube="//img[@src='/orangehrm/symfony/web/webres_5d186a4a987cc7.73469913/themes/default/images/login/youtube.png' and @alt='OrangeHRM on youtube']";
	
	String ErrorMsg="//span[@id='spanMessage']";
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		link=new Links(driver);
		}
	
	public String title(){
		titleofPage= driver.getTitle();
		return titleofPage;
		}
	
	public boolean image(){
		boolean image=driver.findElement(By.xpath(logoImage)).isDisplayed();
		return image;
		}
	
	public void linkedIn(){
		driver.findElement(By.xpath(logoImage)).click();
		}
	
	public void facebook(){
		driver.findElement(By.xpath(facebook)).click();
		}
	
	public void twiter(){
		driver.findElement(By.xpath(twiter)).click();
		}
	
	public void youtube(){
		driver.findElement(By.xpath(youtube)).click();
		}
	
	public void txt_userName(String username){
		ele=driver.findElement(By.id(username_id));
		ele.sendKeys(username);
		}
	
	public void txt_password(String password){
		ele=driver.findElement(By.id(password_id));
		ele.sendKeys(password);
		}
	
	public HomePage btn_login(){
		ele = driver.findElement(By.id(login_btn));
		ele.click();
		homepage = new HomePage(driver);
		return homepage;
		}
	
	public void forgetPassword(){
		driver.findElement(By.xpath(forgetPassword));
		}
	
	public int totallinks(){
		int numberofLinks=link.totallinks();
		return numberofLinks;
		}
	
	//Not Yet Implemented
	public int Brokenlinks(){
		List<WebElement> totallinks=driver.findElements(By.tagName("a"));
		int totallink=totallinks.size();
		return totallink;
		}
	
	public String getErrorMsgText(){
		ele=driver.findElement(By.xpath(ErrorMsg));
		text=ele.getText();
		return text;
	}

}
