package Practice.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Practice.PageObjects.CartPage;
import Practice.PageObjects.CheckOutPage;
import Practice.PageObjects.OrderPage;
import Practice.PageObjects.ProductCataloguePage;
import Practice.TestComponents.BaseTest;

public class SubmitOrderTest extends BaseTest{

	String reqiredname = "ADIDAS ORIGINAL";
	
	 @Test(dataProvider = "getData", groups = "Purchase")
     public void submitOrder(String email, String password, String productName) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		ProductCataloguePage productCatalogue = landingPage.Login(email, password);
		
		productCatalogue.addProductToCart(productName);
		String toaster = productCatalogue.getToasterMessage();
		Assert.assertEquals(toaster, "Product Added To Cart");
		CartPage cartPage=productCatalogue.goToCartPage();
		

		cartPage.verifyProductDisplay(productName);
		
		CheckOutPage checkOutPage = cartPage.goToCheckOut();
		checkOutPage.getCountry();
		checkOutPage.getSubmitButton();
		String confirmMessage= checkOutPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	
	
	}
	 
	 @Test(dependsOnMethods = "submitOrder")
	 public void orderHistory()
	 {
		 landingPage.Login("AbhiRam@gmail.com", "Testing123");
		OrderPage orderPage = landingPage.goToOrderPage();
		orderPage.verifyorderDisplay(reqiredname);
		 
	 }
	 
	 @DataProvider
	 public Object[][] getData(){
		 
		 return new Object[][] {{"AbhiRam@gmail.com", "Testing123","ADIDAS ORIGINAL"},{"AbhiRama@gmail.com", "Testing123","ZARA COAT 3" }};
	 }
	
	 
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}