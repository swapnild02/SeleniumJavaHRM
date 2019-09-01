package com.OrangeHRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.Base.Base;
import com.OrangeHRM.Base.Wait;
import com.OrangeHRM.Base.WebTable;

public class ViewSystemUsersPage extends Base {
	WebDriver driver;
	HomePage homepage;
	SaveSystemUserPage saveSystemUserPage;
	WebElement element;
	Wait wait;
	WebTable webtable;

	String getusername_Name;
	String Names;

	String btn_Search_Id = "searchBtn";
	String btn_Reset_Id = "resetBtn";
	String btn_Add_Id = "btnAdd";
	String btn_Delete_Id = "btnDelete";
	String chkBox_CheckAll_Id = "ohrmList_chkSelectAll";
	String halfXpathofusername1 = "//a[text()='";
	String halfXpathofusername2 = "']";
	String beforeXpath = "//*[@id='resultTable']/tbody/tr[";
	String afterXpath = "]/td[";
	String afterXpath1 = "]";

	public ViewSystemUsersPage(WebDriver driver) {
		this.driver = driver;
		wait = new Wait(driver);
		webtable = new WebTable(driver);
		homepage = new HomePage(driver);
	}

	public SaveSystemUserPage btnclickOnAdd() {

		element = driver.findElement(By.id(btn_Add_Id));
		element.click();
		saveSystemUserPage = new SaveSystemUserPage(driver);
		return saveSystemUserPage;

	}

	public SaveSystemUserPage clickOnUserNameWebColumn(String username) {

		int lastrow = webtable.getTotalRow();
		for (int i = 1; i <= lastrow; i++) {
			for (int j = 2; j <= 2; j++) {
				String actualpath = beforeXpath + i + afterXpath + j + afterXpath1;
				element = driver.findElement(By.xpath(actualpath));
				getusername_Name = element.getText();

				element = driver.findElement(By.xpath(halfXpathofusername1 + getusername_Name + halfXpathofusername2));
				if (getusername_Name.equalsIgnoreCase(username)) {
					element.click();
				}
			}
			System.out.println();
		}
		saveSystemUserPage = new SaveSystemUserPage(driver);
		return saveSystemUserPage;

	}
}
