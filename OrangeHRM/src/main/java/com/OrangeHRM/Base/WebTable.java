package com.OrangeHRM.Base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTable extends Base {
	WebDriver driver;
	WebElement element,table,rows,col,header;
	
	int lastrow=0;
	String getusername_Name;
	String Names;
	List<WebElement> tags1,chk_Box;
	
	String webtables_Id="resultTable";
	String rowpath="//*[@id='resultTable']/tbody/tr";
	String colpath="//*[@id='resultTable']/tbody/tr[1]/td";//Not in use
	String colpath1="//*[@id='resultTable']/tbody/tr[";
	String colpath2="]/td";
	String halfXpathofusername1="//a[text()='";
	String halfXpathofusername2="']";
	String beforeXpath="//*[@id='resultTable']/tbody/tr[";
	String afterXpath="]/td[";
	String afterXpath1="]";
	String checkBox="//input[@type='checkbox']";
	/*
	 * This is web table path by Id
	 */
	String table_Id="webtables_Id";
	public  WebTable(WebDriver driver){
		this.driver=driver;
	}
	/*
	 * This "getTotalRow" method find the total number of rows present in web Table
	 */
	public int getTotalRow(){
		lastrow=driver.findElements(By.xpath(rowpath)).size();
		System.out.println("Total rows are "+lastrow);
		return lastrow;
	}
	
	/*
	 * This "getTotalColumn" method find the total number of columns present in web Table.
	 */

	public int getTotalColumn(){
		int lastcol=0;
		for (int i=1;i<=lastrow;i++){
			if(i==1){
				lastcol=driver.findElements(By.xpath(colpath1+i+colpath2)).size();
				System.out.println(lastcol);
				break;
			}
			else{
				System.out.println("No Rows are there");
			}
		}
		return lastcol;
	}
	/*
	 * This is 1st approach to click on username link present in web Table
	 */
	public String clickOnUserOfWebTable(String name) 
	{
		int lastrow = getTotalRow();
		outer:
		for (int i = 1; i <= lastrow; i++) 
		{
			for (int j = 2; j <= 2; j++) 
			{
				String actualpath = beforeXpath + i + afterXpath + j + afterXpath1;
				element = driver.findElement(By.xpath(actualpath));
				String getusername_Name = element.getText();

				element = driver.findElement(By.xpath(halfXpathofusername1 + getusername_Name + halfXpathofusername2));
				if (getusername_Name.equalsIgnoreCase(name)) 
				{
					Names=getusername_Name;
					element.click();
					break outer;

				}

			}

		}
		return Names;
	}
	/*
	 * This "getTextFromWebTable" return name of the text present in web table.
	 */
	public String getTextFromWebTable(String name) {
		int lastrow = getTotalRow();
		outer:
		for (int i = 1; i <= lastrow; i++) {
			for (int j = 2; j <= 2; j++) {
				String actualpath = beforeXpath + i + afterXpath + j + afterXpath1;
				element = driver.findElement(By.xpath(actualpath));
				getusername_Name = element.getText();
				if(getusername_Name.equalsIgnoreCase(name)){
					 Names=getusername_Name;
					 break outer;
				}
			}

		}
		return Names;
	}
	
	public void clickOnCheckbox(String name1,String name2)
	{
		
		chk_Box=driver.findElements(By.xpath(checkBox));
		System.out.println("Total Number of ChkBox  "+chk_Box.size());
		int lastrow = getTotalRow();
		
		for (int i = 2; i <= lastrow; i++) {
			for (int j = 2; j <= 2; j++) {
				String actualpath = beforeXpath + i + afterXpath + j + afterXpath1;
				element = driver.findElement(By.xpath(actualpath));
				getusername_Name = element.getText();
				System.out.println(getusername_Name);
				if(getusername_Name.equalsIgnoreCase(name1) ||getusername_Name.equalsIgnoreCase(name2)){
					chk_Box.get(i-1).click();
					 break ;
				}
			}

		}
		
	
	}
	
	/* 
	 * This is 2nd approach to click on username link present in web Table
	 * This approch is not use.
	 *  
	 */
	public void clickOnUseNameLink(String username)
	{
		tags1=driver.findElement(By.id(table_Id)).findElements(By.tagName("a"));
		for(WebElement ele:tags1){
			System.out.println(ele.getText());
			if(ele.getText().equalsIgnoreCase(username)){
				ele.click();
				break;
			}
		}
	}

}
