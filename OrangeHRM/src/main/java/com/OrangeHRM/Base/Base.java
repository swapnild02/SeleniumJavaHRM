package com.OrangeHRM.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;
	File Configfile,Loginfile;
	FileInputStream Configfilefileinputstrea,loginfilefileinputstrea;
	
	public Base(){
		try{
		BaseProperty();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public WebDriver initinalization(){
		System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromePath"));
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		return driver;
	}
	public void BaseProperty() throws IOException{
		Configfile=new File("D:\\TestNG\\OrangeHRM\\src\\main\\java\\com\\OrangeHRM\\Base\\propertyfiles\\Config.property");
		Loginfile=new File("D:\\TestNG\\OrangeHRM\\src\\main\\java\\com\\OrangeHRM\\Base\\propertyfiles\\Login.property");
		Configfilefileinputstrea = new FileInputStream(Configfile);
		loginfilefileinputstrea = new FileInputStream(Loginfile);
		prop=new Properties();
		prop.load(Configfilefileinputstrea);
		prop.load(loginfilefileinputstrea);
	}

}
