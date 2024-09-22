package checkoutOverviewPage;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CheckoutOverviewPageComp extends CheckoutOverviewPageWebElement{
	
	
	public void CheckCheckoutSummaryContainer() {
		WebElement Container=GetCheckoutSummaryContainer();
		CheckNotNull(Container,"CheckoutSummaryContainer");
	}
	
	public void CheckPaymentSummaryInfo() {
		String PaymentInfo=GetSummaryInfo().getText();
		System.out.println(PaymentInfo);
	}
	
	public void CheckCartItems() {
		List<WebElement>items=GetCartItems();
		
		//Check number of items
		int ItemsNumber=items.size();
		System.out.println("Number of items= "+ItemsNumber);
		String CartNumber=GetCartBadgeNumber().getText();
		Checkequals(String.valueOf(ItemsNumber), CartNumber);
		
		for(WebElement item : items) {
			
			//Check Items info
			String ItemInfo=item.getText();
			System.out.println(ItemInfo);
			
			
		}
	}
	
	public void ClickFinishButton() {
		
		//Check the color
		String color=GetFinishButton().getCssValue("Background");
		System.out.println(color);
		
		//Check the button is enabled
		boolean btn=GetFinishButton().isEnabled();
		System.out.println(btn);
		
		//Click on the button and check redirected to the next page
		GetFinishButton().click();
		Checkequals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
		
	}
	
	public void ClickCancelButton() {
		//Check the color
		String color=GetCancelButton().getCssValue("Background");
		System.out.println(color);
				
		//Check the button is enabled
		boolean btn=GetCancelButton().isEnabled();
		System.out.println(btn);
				
		//Click on the button and check redirected to the Home page
		GetCancelButton().click();
		Checkequals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
				
		
	}

}
