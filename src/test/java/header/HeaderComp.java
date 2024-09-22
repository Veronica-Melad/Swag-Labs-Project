package header;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utility.WaitingMethod;

public class HeaderComp extends HeaderWebElement {
	

	
	public void CheckMenuBtn() {
		logger.debug("Check Menu button");
		//check menu button
		logger.debug("Check Menu Button");
		WebElement container= CheckMenuButtonContainer();
		assertNotNull(container);
		
		
		driver.findElement(By.id("react-burger-menu-btn")).click();
		assertNotNull(driver.findElement(By.className("bm-menu-wrap")));
	}
	
	
	public void CheckProductTitle() {
		logger.debug("Check Product title");
		String ProductTiltle= CheckProductTitleContainer().getText();
		System.out.println(ProductTiltle);
		assertEquals(ProductTiltle, "Products");
		
	}
	
	public void CheckCartButton() {
		logger.debug("Check Cart Button");
		WebElement container= CheckCartButtonContainer();
		assertNotNull(container);
		//check cart page opened
		driver.findElement(By.className("shopping_cart_link")).click();
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://www.saucedemo.com/cart.html");
	}
	

	
	public void ClickBackToProductBtn()  {
		logger.debug(" Check Back to products button");
		WebElement BackToProductBtn=GetBackToProductsButton();
		CheckIfButtonIsEnable(BackToProductBtn, "Back to products button");
		
		Actions action =new Actions(driver);
		action.moveToElement(BackToProductBtn).build().perform();

		WaitingMethod wait=new WaitingMethod();
		wait.explicitlyWaitForVisibility(BackToProductBtn);
		
		//Click on the button and redirected to the home page
		BackToProductBtn.click();
		String url=driver.getCurrentUrl();
		System.out.println(url);
		Checkequals(url, "https://www.saucedemo.com/inventory.html");
	}
	public void CheckBackToProductsBtnColor() {
		logger.debug("Check Back To Products Btn color");
		//Check color of the product name before moving to it
		WebElement BackToProductBtn=GetBackToProductsButton();
		String BackToProductBtnColorBeforeMoving=BackToProductBtn.getCssValue("Color");
		System.out.println("color of Back to products button before moving to it= "+BackToProductBtnColorBeforeMoving);
		//Check color of the product name change after moving to it
		Actions action =new Actions(driver);
		action.moveToElement(BackToProductBtn).build().perform();
		
		WaitingMethod wait=new WaitingMethod();
		wait.explicitlyWaitForVisibility(BackToProductBtn);
		
		String BackToProductBtnColorAfterMoving=BackToProductBtn.getCssValue("Color");
		System.out.println("color of Back to products button After moving to it= "+BackToProductBtnColorAfterMoving);
		
		CheckNotequals(BackToProductBtnColorBeforeMoving, BackToProductBtnColorAfterMoving);
	}
	
	public void CheckDropDownContainer() {
		logger.debug("Check dropdown list container");
		//Check the container
		WebElement Container=GetDropDownContainer();
		assertNotNull(Container);
		
	}
	
	public void CheckDropDown_AtoZ() {
		logger.debug("Check A to Z sorting");
		Select sort =new Select(GetDropDownContainer()) ;
		sort.selectByIndex(0);
		assertEquals(AtoZ().getText(), "Name (A to Z)");
		String FirstProduct=AllProducts().getFirst().getText();
		System.out.println(FirstProduct);
		assertTrue(FirstProduct.contains("Backpack"));
	    
	}
	public void CheckDropDown_ZtoA() {
		logger.debug("Check Z to A sorting");
		Select sort =new Select(GetDropDownContainer()) ;
		sort.selectByIndex(1);
		assertEquals(ZtoA().getText(), "Name (Z to A)");
		String FirstProduct=AllProducts().getFirst().getText();
		System.out.println(FirstProduct);
		assertTrue(FirstProduct.contains("Test"));
	    
	}
	public void CheckDropDown_LowtoHigh() {
		logger.debug("Check Low to High Price sorting");
		Select sort =new Select(GetDropDownContainer()) ;
		sort.selectByIndex(2);
		assertEquals(LowToHigh().getText(), "Price (low to high)");
		String FirstProduct=AllProducts().getFirst().getText();
		System.out.println(FirstProduct);
		assertTrue(FirstProduct.contains("$7.99"));
	
	
	}
	public void CheckDropDown_HighToLow() {
		logger.debug("Check High to Low Price sorting");
		Select sort= new Select(GetDropDownContainer());
		sort.selectByIndex(3);
		assertEquals(HighToLow().getText(),"Price (high to low)");
		String FirstProduct=AllProducts().getFirst().getText();
		System.out.println(FirstProduct);
		assertTrue(FirstProduct.contains("$49.99"));
	}
	
     public void CheckDropDownRandomly() {
		
		// Locate For All DropDown Options
		List<WebElement> DropDown =driver.findElements(By.tagName("option"));
		
		// Get Size For DropDown Options 
		int Options = DropDown.size();
		System.out.println("The Size Of DropDown Is: " +DropDown.size());
		
		// Select DropDown Using Random
			Random random = new Random();
			int RandomButtons = random.nextInt(Options);
			
		// Knowing what I selected 
			System.out.println("The Number Of Button Click Is = " +RandomButtons);
			String Text = DropDown.get(RandomButtons).getText();
			System.out.println(Text);
			
		// Then Clicked On It
			DropDown.get(RandomButtons).click();
			
//		// Get All Information About User Login
//			Set<Cookie> cookies = driver.manage().getCookies();
//			System.out.println(cookies);
			
		// Get All Products
			 List<WebElement> AllProducts = driver.findElements(By.xpath("//div[@class=\"inventory_item\"]"));
			 System.out.println(AllProducts.size());
			 
		// Get All The Text For Product
			 System.out.println(AllProducts.getFirst().getText());
			 
		// Check The Products Arranged Success When Selected One Option
			if(Text.contains("Z to A")) {
				assertTrue(AllProducts.getFirst().getText().contains("Test"));
				System.out.println("Selected Z to A");
				
			}else if (Text.contains("A to Z")) {
				assertTrue(AllProducts.getFirst().getText().contains("Sauce"));
				System.out.println("Selected A to Z");
				
			}else if (Text.contains("Price (low to high)")) {
				assertTrue(AllProducts.getFirst().getText().contains("$7.99"));
				System.out.println("Selected low to high");
				
			}else if (Text.contains("Price (high to low)")) {
				assertTrue(AllProducts.getFirst().getText().contains("$49.99"));
				System.out.println("Selected high to low");
				
			}else {
				System.out.println("False");
			}

            
		
		
	}
     public void CheckYourCartTitle() {
 		
 		String YourCart=GetYourCartTitle().getText();
 		System.out.println(YourCart);
 		assertEquals(YourCart,"Your Cart");
 	
 	}
     public void CheckCheckoutTilte() {
 		logger.debug("Check Checkout tilte");
 		String title=GetCheckoutTitle().getText();
 		System.out.println(title);
 		assertEquals(title, "Checkout: Your Information");
 	}
     public void CheckCkeckoutOverviewTitle() {
 		logger.debug("Check Checkout Overview Title");
 		String title=GetCheckoutOverviewTiltle().getText();
 		System.out.println(title);
 		Checkequals(title, "Checkout: Overview");
 	}


}


	


