package Practice.PageObjects;

import java.security.PublicKey;
import java.time.Duration;
import java.util.List;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Practice.AbstractComponent.AbstractComponent;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	String url = "https://rahulshettyacademy.com/client/dashboard/cart";

	@FindBy(xpath = "//div[@class='cart']/ul")
	List<WebElement> cartItems;

	@FindBy(xpath = "//li[@class='totalRow']/button")
	WebElement checkOutElement;

	public CartPage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CheckOutPage goToCheckOut() {
		 
		return new CheckOutPage(driver);

	}

	public void verifyProductDisplay(String reqiredname) {

		WaitforThePagetoAppear(url);

		for (WebElement item : cartItems) {
			String itemName = item.findElement(By.tagName("h3")).getText();
			if (itemName.equals(reqiredname)) {
				scrollToElement(checkOutElement);
				checkOutElement.click();
			}

		}

	}

}
