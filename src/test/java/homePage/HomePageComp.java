package homePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.WaitingMethod;

public class HomePageComp extends HomePageWebElement{
	
	
	

	
	public void CheckHomePageOpened() {
		 logger.debug("check Home page opened");
		 
		//Check container
		WebElement container=GetAllProductsContainer();
		CheckNotNull(container, "Home Page Container");
		
		//check URL
		String url=driver.getCurrentUrl();
		Checkequals(url, "https://www.saucedemo.com/inventory.html");
	}
	
	
	public void CheckProductImage() {
		logger.debug("Check Product image");
		boolean ProductIamge=GetproductImage().isDisplayed();
		System.out.println("product image "+ProductIamge);
	}
	
	public void CheckProductinfo() {
		logger.debug("Check product info");
		String ProductInfo=product().getText();
		System.out.println(ProductInfo);
	}
	
	public void CheckProductNameColor()  {
		logger.debug("Check Product name color");
		//Check color of the product name before moving to it
		String ProductNameColorBeforeMoving=GetProductName().getCssValue("Color");
		System.out.println("color of product before moving to it= "+ProductNameColorBeforeMoving);
		//Check color of the product name change after moving to it
		Actions action =new Actions(driver);
		action.moveToElement(GetProductName()).perform();
		
		WaitingMethod wait=new WaitingMethod();
		wait.explicitlyWaitForVisibility(GetProductName());
		
		String ProductNameColorAfterMoving=GetProductName().getCssValue("Color");
		System.out.println("color of product after moving to it= "+ProductNameColorAfterMoving);
		
		CheckNotequals(ProductNameColorBeforeMoving, ProductNameColorAfterMoving);
		
	}
	
	public void ClickOnAddToCartButton() {
		//Check add to cart button is clicked
		logger.debug("Check Add to cart button");
		WebElement AddToCart=GetAddToCart();
		AddToCart.click();
		WaitingMethod wait=new WaitingMethod();
		wait.explicitlyWaitForVisibility(GetRemove());
		
		//Check Remove button appeared
		WebElement Remove=GetRemove();
		System.out.println(Remove.getText());
		assertTrue(Remove.getText().contains("Remove"));
		
		//Check remove button color
		String color=Remove.getCssValue("Color");
		System.out.println(color);
	}
	
	
	
	
	public void CheckProductRandomly() {
		
		//Check product info
		logger.debug("Check product info");
		
		//Locate all Products
		List<WebElement>AllProducts=AllProductsList();
		
		// get options size
		int options=AllProducts.size();
		System.out.println(options);
		
		//select item using random
		Random random=new Random();
		int RandomNamesButton=random.nextInt(options);
		
		//selected item info
		WebElement Name=AllProducts.get(RandomNamesButton).findElement(By.className("inventory_item_name"));
		String ProductName=Name.getText();
		System.out.println("The Selected item is "+ProductName);
		
		//Check add to cart button is clicked
		WebElement AddToCart=AllProducts.get(RandomNamesButton).findElement(By.className("btn_inventory"));
		AddToCart.click();
		
		//Check color of the product name change when moving to it
		Actions action =new Actions(driver);
		action.moveToElement(Name).perform();
		
		WaitingMethod wait=new WaitingMethod();
		wait.explicitlyWaitForVisibility(Name);
		
		//Click on product name and redirected to product Page
		Name.click();
		
	}
	
	public void CheckProductsAddedToWebsite(){
		
		logger.debug("Check all items");
		
		int i=0;
		
		List<WebElement>AllProducts=AllProductsList();
		
		// Get number of products
	    int ProductNumber=AllProducts.size();
		System.out.println("Number of items= "+ProductNumber);
		
		
		for(WebElement product:AllProducts) {
			i++;
			
			
			//check product details
			String ProductDetails=product.getText();
			System.out.println(ProductDetails);
			
			//check product image displayed
			boolean ProductIamge=product.findElement(By.className("inventory_item_img")).isDisplayed();
			System.out.println(ProductIamge);
			
			//Check color of the product name change when moving to it
			WebElement ProductName=product.findElement(By.className("inventory_item_name"));
			Actions action =new Actions(driver);
			action.moveToElement(ProductName).perform();
			
			WaitingMethod wait=new WaitingMethod();
			wait.explicitlyWaitForVisibility(ProductName);
			
			//Check add to cart button is clicked
			WebElement AddToCart=product.findElement(By.className("btn_inventory"));
			AddToCart.click();
			
			wait.explicitlyWaitForVisibility(product.findElement(By.className("btn_inventory")));
			
			//Check Remove button appeared
			WebElement Remove=product.findElement(By.className("btn_inventory"));
			System.out.println(Remove.getText());
			assertTrue(Remove.getText().contains("Remove"));
			
			//Check remove button color
			String color=Remove.getCssValue("Color");
			System.out.println(color);
		
			//Check cart button number 
			WebElement CartNumber=GetCartButtonNumber();
			String Text = CartNumber.getText();
			System.out.println(Text);
			assertEquals(String.valueOf(i),Text);
			
			
		}
	}
  public void CheckScrollDown() {
	  WebElement product=GetTestAllThingProduct();
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", product);
  }
	
	
	
	
	
	}


