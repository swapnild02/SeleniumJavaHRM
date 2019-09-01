package com.OrangeHRM.TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Pages.HomePage;
import com.OrangeHRM.Pages.LoginPage;
import com.OrangeHRM.Pages.ViewSystemUsersPage;

public class ViewSystemUsersTestCase extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ViewSystemUsersPage viewSystemUsersPage;
	@BeforeTest
	public void setUp(){
		driver=initinalization();
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		viewSystemUsersPage=new ViewSystemUsersPage(driver);
	}
	@Test(priority=0)
	public void login(){
		loginpage.txt_userName(prop.getProperty("PostiveUserName"));
		loginpage.txt_password(prop.getProperty("PostivePassword"));
		loginpage.btn_login();
		
	}
//	@Test(priority=1)
//	public void clickOnAddButton(){
//		viewSystemUsersPage=new ViewSystemUsersPage(driver);
//		viewSystemUsersPage.btnclickOnAdd();
//		
//	}
//	@Test(priority=1)
//	public void clickOnWebTable(){
//		viewSystemUsersPage.clickOnUserNameWebColumn();
//	}
	
//	@AfterTest
//	public void tearDown(){
//		driver.quit();
//	}

}
