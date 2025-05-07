package Practice.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Practice.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	String orderPageUrl = "https://rahulshettyacademy.com/client/dashboard/myorders";

	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> orderItems;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean verifyorderDisplay(String reqiredname) {
		Boolean match = orderItems.stream().anyMatch(orderItem -> orderItem.getText().equalsIgnoreCase(reqiredname));
		return match;

	}
}
