package cartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import homePage.HomePageComp;
import utility.WaitingMethod;

public class CartPageComp extends CartPageWebElement {
	

	
	
	
	public void CheckCartPageOPened() {
		//Check URL
		String url=driver.getCurrentUrl();
		assertEquals(url,"https://www.saucedemo.com/cart.html");
		
		//Check the container
		WebElement Container= getCartContentContainer();
		assertNotNull(Container);
	}
	
	
	
	public void CheckQuantityTiltle() {
		String Quantity=GetQuantityTitle().getText();
		System.out.println(Quantity);
		assertEquals(Quantity,"QTY");
	}
	
	
	public void CheckDescriptionTitle() {
		String Description=GetDescriptionTitle().getText();
		System.out.println(Description);
		assertEquals(Description,"Description");}
	
	
	public void CheckProductInfo() {
		WebElement Item=GetCartItem();
		String ProductDetails=Item.getText();
		System.out.println(ProductDetails);
		
	}
	
	public void ClickRemoveBtn() {
		WebElement Remove=GetRemoveButton();
		Remove.click();
		
		
	}
	
	
	
	public void CheckCartItems() {
	WebElement Container= getCartContentContainer();
    List<WebElement>Items=Container.findElements(By.className("cart_item"));
		int i=6;
	
		for(WebElement Item:Items ) {
			
			i--;
			
			//Get Product Details
			String ProductDetails=Item.getText();
			System.out.println(ProductDetails);
			
			//Click on Remove button
			WebElement Remove=GetRemoveButton();
			Remove.click();
			WaitingMethod wait=new WaitingMethod();
			wait.explicitlyWaitForVisibility(GetCartButtonNumber());
			
			//Cart number decrease
			String CartNumber=GetCartButtonNumber().getText();
			System.out.println(CartNumber);
			assertEquals(String.valueOf(i),CartNumber);
			
			
		}
		}
	
	
	public void ClickContinueShoppingButton() {
		GetContinueShoppingButton().click();
		String URL=driver.getCurrentUrl();
		assertEquals(URL,"https://www.saucedemo.com/inventory.html");
	}
	
	
	public void ClickCheckoutButton() {
		logger.debug("Check Checkout Button");
		String color=GetCheckOutButton().getCssValue("Background");
		System.out.println(color);
		GetCheckOutButton().click();
		String URL=driver.getCurrentUrl();
		assertEquals(URL,"https://www.saucedemo.com/checkout-step-one.html");
		
	}
	
	}


