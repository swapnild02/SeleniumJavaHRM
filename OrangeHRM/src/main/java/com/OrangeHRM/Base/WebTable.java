package com.OrangeHRM.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTable extends Base {
	WebDriver driver;
	WebElement element;
	
	int lastrow=0;
	String getusername_Name;
	String Names;
	
	String rowpath="//*[@id='resultTable']/tbody/tr";
	String colpath="//*[@id='resultTable']/tbody/tr[1]/td";//Not in use
	String colpath1="//*[@id='resultTable']/tbody/tr[";
	String colpath2="]/td";
	String halfXpathofusername1="//a[text()='";
	String halfXpathofusername2="']";
	String beforeXpath="//*[@id='resultTable']/tbody/tr[";
	String afterXpath="]/td[";
	String afterXpath1="]";
	public  WebTable(WebDriver driver){
		this.driver=driver;
	}
	
	public int getTotalRow(){
		lastrow=driver.findElements(By.xpath(rowpath)).size();
		System.out.println("Total rows are "+lastrow);
		return lastrow;
	}

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
	
	public void clickOnUserOfWebTable(String name) 
	{
		int lastrow = getTotalRow();
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
					element.click();
					break;

				}

			}

		}
	}
	public String getTextFromWebTable(String name) {
		int lastrow = getTotalRow();
		for (int i = 1; i <= lastrow; i++) {
			for (int j = 2; j <= 2; j++) {
				String actualpath = beforeXpath + i + afterXpath + j + afterXpath1;
				element = driver.findElement(By.xpath(actualpath));
				getusername_Name = element.getText();
				if(getusername_Name.equalsIgnoreCase(name)){
					 Names=getusername_Name;
					 break;
				}
			}

		}
		return Names;
	}

}
