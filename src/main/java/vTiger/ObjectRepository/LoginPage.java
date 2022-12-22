package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule 1
	
	//rule 2:- Declaration
	@FindBy(name = "user_name")
	private WebElement usernameEdt;
	
	@FindBy (name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	//rule 3:- Initialisation
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public void setUsernameEdt(WebElement usernameEdt) {
		this.usernameEdt = usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public void setPasswordEdt(WebElement passwordEdt) {
		this.passwordEdt = passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}

	public void loginToApp(String uSERNAME, String pASSWORD) {
		usernameEdt.sendKeys(uSERNAME);
		passwordEdt.sendKeys(pASSWORD);
		submitBtn.click();
		
	}
	
	//rule 4 :- Utilisation
	
	

}
