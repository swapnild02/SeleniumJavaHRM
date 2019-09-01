package com.OrangeHRM.TestCases;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Pages.HomePage;
import com.OrangeHRM.Pages.LoginPage;
import com.OrangeHRM.Base.*;

public class LoginTestCase extends Base{
	
	
	LoginPage login;
	WebDriver driver;
	HomePage homepage;
	Wait wait;
	WebElement element;
	ReadandWriteExcell readexcell;
	String text;
	
	
	@BeforeMethod(groups={"smoke","sanity","regration"})
	public void setUp(){
		driver=initinalization();
		login=new LoginPage(driver);
		homepage=new HomePage(driver);
	}
	
	@DataProvider
	public Object[][] getlogindatafromExcell(){
		readexcell=new ReadandWriteExcell();
		Object data[][]=readexcell.readFromExcellFile("PositiveLogin");
		return data;
	}
	
	@DataProvider
	public Object[][] getlogindataforNegative(){
		readexcell=new ReadandWriteExcell();
		Object data[][]=readexcell.readFromExcellFile("NegativeLogin");
		return data;
	}
	
	@Test(dataProvider="getlogindatafromExcell",priority=1,groups={"smoke","regration","sanity"})
	public void logIn(String username,String password){
		try{
		login.txt_userName(username);
		login.txt_password(password);
		login.btn_login();
		element = homepage.Dashboard();
		wait = new Wait(driver);
		wait.visibilityOf(element, 30);
	    text = homepage.getTextDashboard();
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}	
		finally{
			Assert.assertEquals(text, "Dashboard");
		}
	}
	
	@Test(dataProvider="getlogindataforNegative",priority=2,groups={"regration"})
	public void logInNegative(String username,String password,String expectedResult){
		try{
		login.txt_userName(username);
		login.txt_password(password);
		login.btn_login();
		text=login.getErrorMsgText();
		System.out.println(text);
		
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		finally{
		Assert.assertEquals(text, expectedResult);
		}
	}	
	
	@Test(priority=3,groups={"regration"})
	public void testTitle(){
		String Title=login.title();
		Assert.assertEquals(Title, "OrangeHRM");
	}
	@Test(priority=4,groups={"regration"})
	public void clickOnLinkedInTest(){
		login.linkedIn();
	}
	@Test(priority=5,groups={"regration"})
	public void clickOnFacebookTest(){
		login.facebook();
	}
	@Test(priority=6,groups={"regration"})
	public void clickOnTwiterTest(){
		login.twiter();
	}
	@Test(priority=7,groups={"regration"})
	public void clickOnYoutubeTest(){
		login.youtube();
	}
	
	@Test(priority=8,groups={"regration"})
	public void verfylogoImage(){
		boolean flag=login.image();
		Assert.assertTrue(flag);
	}
	@Test(priority=9,groups={"regration"})
	public void totallinkTest(){
		int totalnumOfLinks=login.totallinks();
		Assert.assertEquals(totalnumOfLinks, 6);
	}
	@AfterMethod(groups={"smoke","sanity","regration"})
	public void tearDown(){
		driver.quit();
	}

}
