package vTiger.OrganizationsTests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;



public class CreateOrganizationTest extends BaseClass {

	public static void main(String[] args) throws IOException, InterruptedException {
	
	//Step 1 : Read the necessary data
	
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		String BROWSER = pObj.getProperty("browser");
//		String URL = pObj.getProperty("url");
//		String USERNAME = pObj.getProperty("username");
//		String PASSWORD = pObj.getProperty("password");
//		
		//Step 1: Create all the objects
//		PropertyFileUtility pUtil = new PropertyFileUtility();
//		JavaUtility jUtil = new JavaUtility();
//		ExcelFileUtility eUtil = new ExcelFileUtility();
//		WebDriverUtility wUtil = new WebDriverUtility();
		
		/*Property File - Common Data*/
		
		String BROWSER = pUtil.readDataFromPropertyFileUtility("browser");
		String URL = pUtil.readDataFromPropertyFileUtility("url");
		String USERNAME = pUtil.readDataFromPropertyFileUtility("username");
		String PASSWORD = pUtil.readDataFromPropertyFileUtility("password");

		
		/*Excel File - Test Data*/
//		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("Organizations");
//		Row rw = sh.getRow(1);
//		Cell ce = rw.getCell(2);
//		String ORGNAME =ce.getStringCellValue();

		
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		
//		WebDriver driver = null;
//		//Step 2 : Launch Browser - RunTime Polymorphism
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			System.out.println("Invalid Browser Name");
//		}
//		
//		//driver.manage().window().maximize();
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		wUtil.maximiseWindow(driver);
//		wUtil.waitForPageLoad(driver);
//		driver.get(URL);
		
		//Step 3 : Login to Application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//Step 4 : Click on Organization Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5 : Click on create organization lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6 : Create new Organization with mandatory information and save
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		
		//Step 7 : Logout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td/span[contains(text(),'Administrator')]/following::td[1]")));
		WebElement ele = driver.findElement(By.xpath("//td/span[contains(text(),'Administrator')]/following::td[1]"));
		//Actions act = new Actions(driver);
		//act.moveToElement(ele).perform();
		
		/*
		 * wUtil.mouseHoverAction(driver, ele); Thread.sleep(5000);
		 * driver.findElement(By.linkText("Sign Out")).click(); Thread.sleep(3000);
		 */
		
		
		
		driver.quit();
		
}
	@Test
	public void CreateOrganisationTest() {
		
		try {
			//Step 1 : get all the properties from property file
			String BROWSER = pUtil.readDataFromPropertyFileUtility("browser");
			String URL = pUtil.readDataFromPropertyFileUtility("url");
			String USERNAME = pUtil.readDataFromPropertyFileUtility("username");
			String PASSWORD = pUtil.readDataFromPropertyFileUtility("password");
			
			//Step2 : get data from excel sheet
			String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
			
			//Step 3 : Click on Organization Link
			driver.findElement(By.linkText("Organizations")).click();
			
			//Step 4 : Click on create organization lookup image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			//Step 5 : Create new Organization with mandatory information and save
			driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
			Thread.sleep(5);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
