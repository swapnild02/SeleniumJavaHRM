package com.OrangeHRM.Base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShot extends Base
{
	public static void takeScreenShot(String methodName)
	{
		File scFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		FileUtils.copyFile(scFile, new File("C:\\Users\\uumak\\git\\SeleniumJavaHRM\\OrangeHRM\\src\\main\\java\\FailedScreenShoot\\"+methodName+".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
