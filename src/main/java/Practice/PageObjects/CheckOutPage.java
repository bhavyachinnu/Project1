package Practice.PageObjects;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Practice.AbstractComponent.AbstractComponent;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CheckOutPage extends AbstractComponent {

	WebDriver driver;
	
	String country ="India";
	String countryKey ="Ind";
	
	@FindBy(xpath = "//input[@placeholder='Select Country']" )
	WebElement countryElement;
	
	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button"  )
	List<WebElement> countryOptions;
	
	@FindBy(css =".action__submit")
	WebElement scroll;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;

	public CheckOutPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getCountry()
	{
		getCountryOptions();
		for(int i=0;i<countryOptions.size();i++)
		{
			String countryName =countryOptions.get(i).getText();
			if(countryName.equalsIgnoreCase(country))
			{
				countryOptions.get(i).click();
				break;
			}
			
		}
	}
	
	
	public void getCountryOptions()
	{
		countryElement.sendKeys(countryKey);
		scrollToElement(scroll);
	}

	public void getSubmitButton() {
		
		submit.click();
	}
	
	public String getConfirmationMessage() {
		
	return	confirmationMessage.getText();
		
	}
	
	
}
