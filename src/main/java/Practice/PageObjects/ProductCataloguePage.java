package Practice.PageObjects;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Practice.AbstractComponent.AbstractComponent;

public class ProductCataloguePage extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(xpath="//div[@class='card-body']/h5")
	List<WebElement> productsList;
	
	@FindBy(xpath = "//div[@aria-label='Product Added To Cart']")
	WebElement toasterMessage;
	
	By selectedProduct =By.xpath("following-sibling::button[@class='btn w-10 rounded']");
	
	String Url ="https://rahulshettyacademy.com/client/dashboard/dash";
	
	By toasterContainer = By.id("toast-container");
	
	
	
	public List<WebElement> getAllProductsList()
	{
		WaitforThePagetoAppear(Url);
		List<WebElement> products = productsList;
		return products;
		
	}
	
	public void addProductToCart(String reqiredname)
	{
		List<WebElement> products = getAllProductsList();
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();

			if (name.contains(reqiredname)) {
				System.out.println(name);
				products.get(i).findElement(selectedProduct).click();
				break;
			}
		}
	}
	
	public String getToasterMessage() throws InterruptedException
	{
	//	WaitforTheElementToAppear(toasterContainer);
	//	WaitforTheElementToDisAppear(spinner);
		Thread.sleep(2000);
		String toaster = toasterMessage.getText();
		return toaster;
	
	}
	
	
	
	
	

}
