package com.OrangeHRM.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Pages.HomePage;
import com.OrangeHRM.Pages.LoginPage;

public class HomePageTestCase extends Base {
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	@BeforeMethod(groups={"smoke","sanity","regration"})
	public void setUp(){
		driver=initinalization();
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.txt_userName(prop.getProperty("PostiveUserName"));
		loginpage.txt_password(prop.getProperty("PostivePassword"));
		loginpage.btn_login();
	}
	@Test(priority=1,groups={"smoke"})
	public void logoutTest(){
		homepage.clickOnWelcome();
		loginpage=homepage.logout();
		boolean flag=loginpage.image();
		Assert.assertTrue(flag);
		}
	@Test(priority=2,groups={"sanity","regration"})
	public void totallinks(){
		int	totallinks=homepage.totallinks();
		Assert.assertEquals(totallinks, 74);
	
	}
	
	@AfterMethod(groups={"smoke","sanity","regration"})
	public void tearDown(){
		driver.quit();
	}

}
