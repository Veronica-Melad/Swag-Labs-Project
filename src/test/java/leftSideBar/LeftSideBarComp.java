package leftSideBar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utility.WaitingMethod;

public class LeftSideBarComp extends LeftSidebarWebElements {
	
	 public void CheckLeftSideBarContainer() {
		 logger.debug("check left side bar container");
		WebElement container= GetSideBarListContainer();
		 CheckNotNull(container,"Left side bar container");
	 }
	 public void ClickMenuBtn() {
			//check menu button container
			WebElement container= GetMenuButtonContainer();
			CheckIfButtonIsEnable(container," menu button");
			
			//click on menu button
			GetBurgerButton().click();
			
		}
	
	
     public void ClickAllItemsBtn() throws InterruptedException {
    	 logger.debug("check all items button");
    	 //check the container
    	 
		Actions action=new Actions(driver);
		WebElement AllItem=GetAllItemsContainer();
		
		CheckIfButtonIsEnable(AllItem,"all items button");
		
		//click on all items button
		Thread.sleep(1000);
		action.moveToElement(AllItem).build().perform();
		AllItem.click();
		Checkequals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
		System.out.println(driver.getCurrentUrl());
}
     
      public void ClickAboutBtn() throws InterruptedException {
    	  logger.debug("check About button");
    	//check the container
		Actions action=new Actions(driver);
		WebElement About=GetAboutContainer();
		CheckIfButtonIsEnable(About,"About button");
		//click on About button
		action.moveToElement(About).perform();
		About.click();
		Thread.sleep(2000);
		Checkequals(driver.getCurrentUrl(),"https://saucelabs.com/");
		System.out.println(driver.getCurrentUrl());
	}
      
      public void ClickLogoutBtn() throws InterruptedException {
    	  logger.debug("check logout button");
    	  //check the container
  		Actions action=new Actions(driver);
  		WebElement Logout=GetLogoutContainer();
  		CheckIfButtonIsEnable(Logout,"logout button");
  		//click on logout button
  		Thread.sleep(1000);
  		action.moveToElement(Logout).perform();
  		Logout.click();
  		Checkequals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
  		
      }
      
      public void ClickResetAppStateBtn() {	
    	  logger.debug("check Reset app state button");
    	  //check the container
    		Actions action=new Actions(driver);
    		WebElement ResetAppState=GetResetAppStateContainer();
    		CheckIfButtonIsEnable(ResetAppState,"Reset app state button");
    		
    		//click on add to cart button
    	    WebElement AddToCart=findingElementById("add-to-cart-sauce-labs-backpack");
    	    AddToCart.click();
    	   
    	    //click on reset app state
    		action.moveToElement(ResetAppState).perform();
    		ResetAppState.click();
    		
    		//locate the cart button
    	    WebElement CartBtn=findingElementByClassName("shopping_cart_badge");
    	    
    		assertTrue(AddToCart.getText().contains("Add to cart"));
    		CheckNull(CartBtn,"cart button");
    		
    		
    		
    		
        }
      

}
