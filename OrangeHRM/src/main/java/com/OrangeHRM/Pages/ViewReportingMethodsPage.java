package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;

import com.OrangeHRM.Base.Base;

public class ViewReportingMethodsPage extends Base {
	WebDriver driver;
	
	String btn_Add_Xpath="//input[@class='addbutton' and @id='btnAdd']";
	String btn_Delete_Xpath="//input[@class='delete' and @id='btnDel']";
	String txtBox_Name_Xpath="//input[@name='reportingMethod[name]' and @id='reportingMethod_name']";
	

}
