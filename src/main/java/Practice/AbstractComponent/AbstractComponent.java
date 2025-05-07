package Practice.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Practice.PageObjects.CartPage;
import Practice.PageObjects.OrderPage;

public class AbstractComponent {

	WebDriver driver;

	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderButton;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	public void WaitforThePagetoAppear(String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.urlToBe(url));

	}

	public void WaitforTheElementToAppear(By toasterContainer) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toasterContainer));

	}
	public void WaitforTheElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void WaitforTheElementToDisAppear(WebElement spinner) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.invisibilityOf(spinner));

	}

	public CartPage goToCartPage() {

		cartButton.click();
		return 	new CartPage(driver);
		
	}
	public OrderPage goToOrderPage() {

		orderButton.click();
		return 	new OrderPage(driver);
		
	}


	public void scrollToElement(WebElement scroll) {

		Actions a = new Actions(driver);
		a.scrollToElement(scroll).build().perform();

	}

}
