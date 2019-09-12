package com.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Base.DropDownList;
import com.OrangeHRM.Base.Wait;

public class SaveSystemUserPage extends Base {
	
	ViewSystemUsersPage viewsystemuserspage;
	
	WebDriver driver;
	WebElement element;
	DropDownList dropDownList;
	Wait wait;
	
	boolean isdispalyed;
	
	
	String DDL_UserRole_Id="systemUser_userType";
	String SearchBox_EmployeeName_Id="systemUser_employeeName_empName";
	
	String textbox_UserName_Id="systemUser_userName";
	String DDL_Status="systemUser_status";
	String Password_Id="systemUser_password";
	String Confirm_Password_Id="systemUser_confirmPassword";
	//String btn_Save_Id="btnSave";
	String btn_Cancel_Id="btnCancel";
	
	String btn_Add_Xpath="//input[@id='btnSave' and @value='Save']"; 
	String btn_Edit_Xpath="//input[@id='btnSave' and @value='Edit']";
	
	String chk_ChangePassword="//input[@id='systemUser_chkChangePassword']";
	
	//This is constructor
	
	public SaveSystemUserPage(WebDriver driver){
		this.driver=driver;
		dropDownList=new DropDownList(driver);
		wait=new Wait(driver);
	}
	
	public void ddl_Select_UesrRole(String userRole){
		element=driver.findElement(By.id(DDL_UserRole_Id));
		dropDownList.selectByVisibleText(element, userRole);
	}
	
	public void search_EmployeeName(String Text){
		element=driver.findElement(By.id(SearchBox_EmployeeName_Id));
		element.clear();
		element.sendKeys(Text);
		element.click();
	}
	
	public void username(String Text){
		element=driver.findElement(By.id(textbox_UserName_Id));
		element.clear();
		element.sendKeys(Text);
	}
	public void changepasswordcheckbox(){
		driver.findElement(By.xpath(chk_ChangePassword)).click();
	}
	
	public void ddl_Status(String status){
		element=driver.findElement(By.id(DDL_Status));
		dropDownList.selectByVisibleText(element, status);
	}
	
	public void password(String Text){
		driver.findElement(By.id(Password_Id)).sendKeys(Text);
	}
	public void confirm_password(String Text){
		driver.findElement(By.id(Confirm_Password_Id)).sendKeys(Text);
	}
	public ViewSystemUsersPage clickAdd(){
		try 
		{
			element=driver.findElement(By.xpath(btn_Add_Xpath));
			element.click();
		}
		catch (StaleElementReferenceException e) 
		{
			e.printStackTrace();
		}
		
		element=driver.findElement(By.xpath(btn_Add_Xpath));
		viewsystemuserspage =new ViewSystemUsersPage(driver);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return viewsystemuserspage;
	}
	
	public void clickOnEdit(){
		try {
			Thread.sleep(3000);
			element=driver.findElement(By.xpath(btn_Edit_Xpath));
			element.click();
		} catch (InterruptedException e1) 
		{
			e1.printStackTrace();
		}
		catch (StaleElementReferenceException e){
			e.printStackTrace();
			
		}
		catch (NoSuchElementException e){
			e.printStackTrace();
		}	
	}
	
	public ViewSystemUsersPage clickOnCancel(){
		try{
			driver.findElement(By.id(btn_Cancel_Id)).click();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		viewsystemuserspage =new ViewSystemUsersPage(driver);
		return viewsystemuserspage;
	}
	

}
