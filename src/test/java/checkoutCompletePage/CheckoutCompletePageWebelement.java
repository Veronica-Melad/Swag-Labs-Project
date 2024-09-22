package checkoutCompletePage;

import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class CheckoutCompletePageWebelement extends FindingElements{
	public WebElement GEtCheckoutCompleteTitle() {return findingElementByClassName("title");}
	public WebElement GetCheckoutCompleteContainer() {return findingElementById("checkout_complete_container");}
	public  WebElement GetImage() {return findingElementByClassName("pony_express");}
	public WebElement GetCompleteText() {return findingElementByClassName("complete-text");}
	public WebElement GetBackHomeBtn() {return findingElementById("back-to-products");}

}
