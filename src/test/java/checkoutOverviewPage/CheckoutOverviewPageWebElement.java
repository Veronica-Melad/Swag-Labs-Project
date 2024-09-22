package checkoutOverviewPage;

import java.util.List;

import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class CheckoutOverviewPageWebElement extends FindingElements {
	
	
	public WebElement GetCheckoutSummaryContainer() {return findingElementById("checkout_summary_container");}
	public List<WebElement>GetCartItems() {return findingElementByClassNameInList("cart_item");}
	public WebElement GetSummaryInfo() {return findingElementByClassName("summary_info");}
	public WebElement GetFinishButton() {return findingElementById("finish");}
	public WebElement GetCancelButton() {return findingElementById("cancel");}
	public WebElement GetCartBadgeNumber() {return findingElementByClassName("shopping_cart_badge");}
	

}
