package Practice.PageObjects;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Practice.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement login;
	
	//ng-tns-c4-3 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error
	
	@FindBy(css= "[class*='ng-trigger-flyInOut']")
	WebElement errorMessage;
	
	
	public String getErrorMessage()
	{
		WaitforTheElement(errorMessage);
		return   errorMessage.getText();
	}
	
	public ProductCataloguePage Login(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		return new ProductCataloguePage(driver);
	}
	
	
	
	public void goTo(WebDriver driver)
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	
	
	
	
	

}
