package Practice.Tests;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("AbhiRam@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Testing123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/client/dashboard/dash"));
		String reqiredname = "IPHONE 13 PRO";
		List<WebElement> cards = driver.findElements(By.xpath("//div[@class='card-body']/h5"));

		for (int i = 0; i < cards.size(); i++) {
			String name = cards.get(i).getText();

			if (name.contains(reqiredname)) {
				System.out.println(name);
				cards.get(i).findElement(By.xpath("following-sibling::button[@class='btn w-10 rounded']")).click();
				break;
			}
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		String toaster = driver.findElement(By.xpath("//div[@aria-label='Product Added To Cart']")).getText();
		Assert.assertEquals(toaster, "Product Added To Cart");
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/client/dashboard/cart"));
		List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class='cart']/ul"));
		
		//cartItems.stream().filter(s->s.findElement(By.tagName("h3")).getText().contains(reqiredname));
		for(WebElement item:cartItems)
		{
			String itemName =item.findElement(By.tagName("h3")).getText();
			if(itemName.equals(reqiredname))
			{
				Actions a1= new Actions(driver);
				 a1.scrollToElement(driver.findElement(By.xpath("//li[@class='totalRow']/button"))).build().perform();
				driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
			}
			
		}
		String country ="India";
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
		List<WebElement> elements =driver.findElements(By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button" ));
	
		System.out.println(elements.size());
	WebElement scroll=	driver.findElement(By.cssSelector(".action__submit"));
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollBy(0,90000)");
	//	js.executeScript("arguments[0].scrollIntoView();", scroll);
	
	
	  Actions a= new Actions(driver);
	  a.scrollToElement(scroll).build().perform();
	 
		for(int i=0;i<elements.size();i++)
		{
			String countryName =elements.get(i).getText();
			if(countryName.equalsIgnoreCase(country))
			{
				elements.get(i).click();
				break;
			}
			
		}
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		driver.quit();
		
	}

}
