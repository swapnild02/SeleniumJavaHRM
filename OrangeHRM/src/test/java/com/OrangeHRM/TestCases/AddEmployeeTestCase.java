package com.OrangeHRM.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Pages.LoginPage;

public class AddEmployeeTestCase extends Base {
	WebDriver driver;
	LoginPage loginpage;
	@BeforeTest
	public void setUp(){
		driver=initinalization();
		loginpage=new LoginPage(driver);
	}
	@Test(priority=0)
	public void login(){
		loginpage.txt_userName(prop.getProperty("PostiveUserName"));
		loginpage.txt_password(prop.getProperty("PostivePassword"));
		loginpage.btn_login();
	}
	
	public void clickOnUser(){
		
	}

}
