package vTiger.Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationPratice {

	public static void main(String[] args) {
		
		//Launch the browser
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Deeptirani Mishra\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Create new organization with  mandatory information and save
		driver.findElement(By.name("accountname")).sendKeys("Qspiders12");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
