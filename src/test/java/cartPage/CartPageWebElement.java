package cartPage;

import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class CartPageWebElement extends FindingElements {
	

	public WebElement getCartContentContainer() {return findingElementById("cart_contents_container");}
	public WebElement GetCartItem() {return findingElementByClassName("cart_item");}
	public WebElement GetQuantityTitle() {return findingElementByClassName("cart_quantity_label");}
	public WebElement GetDescriptionTitle() {return findingElementByClassName("cart_desc_label");}
	public WebElement GetRemoveButton() {return findingElementByClassName("cart_button");}
	public WebElement GetCheckOutButton() {return findingElementById("checkout");}
	public WebElement GetContinueShoppingButton() {return findingElementById("continue-shopping");}
	public WebElement GetCartButtonNumber() {return findingElementByClassName("shopping_cart_badge");}
	public WebElement GetCartButton() {return findingElementByClassName("shopping_cart_link");}
	
	

}
