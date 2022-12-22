package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations
 * @author Deeptirani Mishra
 * 
 * **/
public class BaseClass {
 
	
	public static PropertyFileUtility pUtil = new PropertyFileUtility();
	public static ExcelFileUtility eUtil = new ExcelFileUtility();
	public static JavaUtility jUtil = new JavaUtility();
	public static WebDriverUtility wUtil = new WebDriverUtility();
	
	public static  WebDriver driver = null;
	
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuit"})
	public void bsConfig()
	{
		System.out.println("=====Database Connection Successfull=====");
	}
	
	@BeforeClass
	public void bcConfig() throws IOException {
		String BROWSER = pUtil.readDataFromPropertyFileUtility("browser");
		String URL = pUtil.readDataFromPropertyFileUtility("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER+"---Browser is launched-----");
		}
		
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER+"---Browser is launched-----");
		
		}
		else
		{
			System.out.println("===Invalid browser details===");
		}
		
		wUtil.maximiseWindow(driver);
		wUtilwaitForPageLoad(driver);
		driver.get(URL);
	}
	
	private void wUtilwaitForPageLoad(WebDriver driver2) {
		// TODO Auto-generated method stub
		
	}

	@BeforeMethod
	public void bmConfig() throws IOException
	{
		
		String USERNAME = pUtil.readDataFromPropertyFileUtility("username");
		String PASSWORD = pUtil.readDataFromPropertyFileUtility("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("+++Login to app is successfull+++");
		System.out.println();
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("Logout of app is successfull");
	}
	
	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser is closed");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("Database is closed");
	}
	
}
