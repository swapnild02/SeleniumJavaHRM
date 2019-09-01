package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;

import com.OrangeHRM.Base.Base;

public class ViewEmployeeListPage extends Base {
	WebDriver driver;
	String searchBox_Employee_Name_Id="empsearch_employee_name_empName";
	String txtBox_Id_Id="empsearch_id";
	String DDL_EmploymentStatus="";
	String DDL_Include="";
	String txtBox_SupervisorName_Id="empsearch_supervisor_name";
	String DDL_JobTitle="";
	String DDL_SubUnit="//input[@value='Search' and @id='searchBtn']";
	String btn_Add_Xpath="//input[@name='btnAdd' and @id='btnAdd']";
	String btn_Delete_Xpath="//input[@class='delete' and @id='btnDelete']";
	
	

}
