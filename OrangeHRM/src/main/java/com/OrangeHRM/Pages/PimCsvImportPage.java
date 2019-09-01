package com.OrangeHRM.Pages;

import org.openqa.selenium.WebDriver;

import com.OrangeHRM.Base.Base;

public class PimCsvImportPage extends Base {
	WebDriver driver;
	String btn_Upload_Xpath="//input[@name='btnSave' and @id='btnSave']";
	String btn_ChooseFile_Xapth="//input[@name='pimCsvImport[csvFile]' and @id='pimCsvImport_csvFile']";
	String link_Download_Xpath="//a[text()='Download']";

}
