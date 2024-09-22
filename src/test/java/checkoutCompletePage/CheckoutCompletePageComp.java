package checkoutCompletePage;

import org.openqa.selenium.WebElement;

public class CheckoutCompletePageComp extends CheckoutCompletePageWebelement {
	
	public void CheckCheckoutCompletePageOpened() {
		//Check URL
		String url=driver.getCurrentUrl();
		Checkequals(url, "https://www.saucedemo.com/checkout-complete.html");
		
		//Check container
		WebElement container=GetCheckoutCompleteContainer();
		CheckNotNull(container, "Checkout complete page container");
	}
	
	public void CheckTitle() {
		logger.debug("Check Complete Title");
		String title= GEtCheckoutCompleteTitle().getText();
		System.out.println(title);
		Checkequals(title, "Checkout: Complete!");
	}
	
	public void CheckImageAddedToWebsite() {
	  WebElement image=GetImage();
	  CheckIsDisplayed(image, "Checkout Complete page image");
		
	}
	
	public void CheckCheckoutCompleteText() {
		String text=GetCompleteText().getText();
		System.out.println(text);
		Checkequals(text, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
	}
	
	public void CheckBackhomeButton() {
		//check the button is enable
		WebElement BackHomeButton=GetBackHomeBtn();
		CheckIfButtonIsEnable(BackHomeButton,"Back Home button");
		
		//check when click on the button home page opened
		GetBackHomeBtn().click();
		String url=driver.getCurrentUrl();
		Checkequals(url, "https://www.saucedemo.com/inventory.html");
	}
	
	

}
