package com.OrangeHRM.TestCases;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Base.ReadandWriteExcell;
import com.OrangeHRM.Base.WebTable;
import com.OrangeHRM.Pages.HomePage;
import com.OrangeHRM.Pages.LoginPage;
import com.OrangeHRM.Pages.SaveSystemUserPage;
import com.OrangeHRM.Pages.ViewSystemUsersPage;

public class SaveSystemUserTextCase extends Base {
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	ViewSystemUsersPage viewSystemUsersPage;
	SaveSystemUserPage saveSystemUserPage;
	ReadandWriteExcell readexcell;
	WebTable webtable;
	
	String usernametext;

	@BeforeMethod
	public void setUp() {
		driver = initinalization();
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		viewSystemUsersPage = new ViewSystemUsersPage(driver);
		saveSystemUserPage = new SaveSystemUserPage(driver);
		webtable=new WebTable(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider
	public Object[][] getdataforAddUser() {
		readexcell=new ReadandWriteExcell();
		Object[][] data = readexcell.readFromExcellFile("SaveSystemUser");
		return data;

	}

	@Test(dataProvider = "getdataforAddUser", priority = 1)
	public void verifyAddUser
			(String loginuserName, String loginpassword, String userRole, 
			String employeename,String userName, String status, String password, 
			String confirmPassword,String ExpectedText) 
	{
		try
		{
		loginpage.txt_userName(loginuserName);
		loginpage.txt_password(loginpassword);
		loginpage.btn_login();
		
		homepage.moveToAdmin();
		homepage.moveToUserManagment();
		homepage.menu_clickOnUser();
		
		viewSystemUsersPage.btnclickOnAdd();
		
		saveSystemUserPage.ddl_Select_UesrRole(userRole);
		saveSystemUserPage.search_EmployeeName(employeename);
		saveSystemUserPage.username(userName);
		saveSystemUserPage.ddl_Status(status);
		saveSystemUserPage.password(password);
		saveSystemUserPage.confirm_password(confirmPassword);
		viewSystemUsersPage=saveSystemUserPage.clickAdd();
		usernametext=webtable.getTextFromWebTable(ExpectedText);
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
		finally{
			Assert.assertEquals(usernametext, ExpectedText);
		}
		

	}
	
	
	@DataProvider
	public Object[][] getdataforEditUser() {
		readexcell=new ReadandWriteExcell();
		Object[][] data = readexcell.readFromExcellFile("EditSaveSystemUserPWChange");
		return data;

	}
	
	@Test(dataProvider = "getdataforEditUser", priority = 2,enabled=false)
	public void verifyEditUser
			(String loginuserName, String loginpassword,String clickUser, String userRole, 
			String employeename,String userName, String status, String password, 
			String confirmPassword,String ExpectedText) 
	{
		try
		{
		loginpage.txt_userName(loginuserName);
		loginpage.txt_password(loginpassword);
		loginpage.btn_login();
		
		homepage.moveToAdmin();
		homepage.moveToUserManagment();
		homepage.menu_clickOnUser();
		
		webtable.clickOnUserOfWebTable(clickUser);
		saveSystemUserPage.clickOnEdit();
		
		saveSystemUserPage.ddl_Select_UesrRole(userRole);
		saveSystemUserPage.search_EmployeeName(employeename);
		saveSystemUserPage.username(userName);
		saveSystemUserPage.ddl_Status(status);
		saveSystemUserPage.changepasswordcheckbox();
		saveSystemUserPage.password(password);
		saveSystemUserPage.confirm_password(confirmPassword);
		saveSystemUserPage.clickAdd();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			Assert.assertEquals(usernametext, ExpectedText);
		}
		

	}

}
