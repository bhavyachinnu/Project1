package Practice.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Practice.PageObjects.CartPage;
import Practice.PageObjects.CheckOutPage;
import Practice.PageObjects.ProductCataloguePage;
import Practice.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest{

	 @Test(groups = {"Smoke"})
     public void loginErrorMessage() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String reqiredname = "ADIDAS ORIGINAL";
		landingPage.Login("AbhiRam@gmail.com", "Testing1123");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
		
	}
	 @Test
     public void productErrorMessage() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		String reqiredname = "ADIDAS ORIGINAL";
		
		ProductCataloguePage productCatalogue = landingPage.Login("AbhiRama@gmail.com", "Testing123");
		
		productCatalogue.addProductToCart(reqiredname);
		String toaster = productCatalogue.getToasterMessage();
		Assert.assertEquals(toaster, "Product Added To Cart");
		
		
	}
	
}