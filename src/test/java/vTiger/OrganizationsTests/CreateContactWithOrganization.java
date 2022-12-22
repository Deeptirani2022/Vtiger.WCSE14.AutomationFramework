package vTiger.OrganizationsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.JCommander.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Contacts");
		Row rw = sh.getRow(1);
		Cell ce = rw.getCell(2);
		String ORGNAME =ce.getStringCellValue();
		
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("DeepTam");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		
		String CurrentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows)
		{
			if(!CurrentWindow.equals(window))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		driver.findElement(By.xpath("//a[@id='11']")).click();
		driver.switchTo().window(CurrentWindow);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//span[@class='userName']/following::td[1]/img")))
		.click(driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"))).build().perform();

		driver.quit();
		 
	}

}
