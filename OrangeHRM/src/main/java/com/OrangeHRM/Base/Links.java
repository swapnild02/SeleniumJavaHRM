package com.OrangeHRM.Base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links {
	
	WebDriver driver;
	int respondcode;
	HttpURLConnection URLConnection = null;
	URL url = null;
	Links links;
	
	public Links(WebDriver driver){
		this.driver=driver;
	}
	
	public void brokenLinks(){

		List<WebElement> totallinks=driver.findElements(By.tagName("a"));
		System.out.println("Total no of links are"+totallinks.size());
		int totalnumberlinks=links.totallinks();
		
		for(int j=0;j<totalnumberlinks;j++){
		System.out.println("Links Name are "+totallinks.get(j).getAttribute("href"));
		}
		System.out.println("---------------------------------------------------------------------------------");
		for (int i=0;i<totallinks.size();i++){
			String lintxt = totallinks.get(i).getAttribute("href");
			//driver.navigate().to(lintxt);
			
			if(lintxt.isEmpty()){
				System.out.println("Empty link");
			}
			else{
				
				try {
					url = new URL(lintxt);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					URLConnection = (HttpURLConnection) url.openConnection();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					URLConnection.connect();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					respondcode = URLConnection.getResponseCode();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					respondcode = URLConnection.getResponseCode();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					if(respondcode==400){
						System.out.println(lintxt+' '+"is brokrnlink");
					}
			}
		}

	}
	
	public int totallinks(){
		List<WebElement> totallinks=driver.findElements(By.tagName("a"));
		int totallink=totallinks.size();
		return totallink;
	} 
}
