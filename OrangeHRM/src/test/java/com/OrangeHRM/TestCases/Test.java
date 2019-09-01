package com.OrangeHRM.TestCases;


import com.OrangeHRM.Base.ReadandWriteExcell;

public class Test {
//	WebDriver driver;
//	WebElement ele;
	ReadandWriteExcell readexcellss;
	
//	@BeforeMethod
//	public void setUp(){
//		System.setProperty("webdriver.chrome.driver","D:\\TestNG\\OrangeHRM\\src\\main\\java\\Dirvers\\chromedriver.exe");
//		driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://127.0.0.1/orangehrm/symfony/web/index.php/auth/login");
//		
//	}
	
	public void getData(){
		readexcellss =new ReadandWriteExcell();
		Object data1[][]=readexcellss.readFromExcellFile("Login");
		//return data1;
		System.out.println(data1);
	}
	public static void main(String[] args) {
		Test t=new Test();
		t.getData();
	}
	
//	@org.testng.annotations.Test
//	public void LoginIn(String username,String password ){
//		ele=driver.findElement(By.id("txtUsername"));
//		ele.sendKeys(username);
//		ele=driver.findElement(By.id("txtPassword"));
//		ele.sendKeys(password);
//		ele = driver.findElement(By.id("btnLogin"));
//		ele.click();
//		
//	}
//	@AfterMethod
//	public void tearDown(){
//		driver.quit();
//		
//	}

}
