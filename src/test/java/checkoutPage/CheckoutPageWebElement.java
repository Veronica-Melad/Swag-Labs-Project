package checkoutPage;

import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class CheckoutPageWebElement extends FindingElements{
	
	
	public WebElement GetCheckoutInfoContainer() {return findingElementById("checkout_info_container");}
	public WebElement GetFirstNameField() {return findingElementById("first-name");}
	public WebElement GetLastNameField() {return findingElementById("last-name");}
	public WebElement GetZipField() {return findingElementById("postal-code");}
	public WebElement GetErrorMessageContainer() {return findingElementByClassName("error-message-container");}
	public WebElement GetCancelBtn() {return findingElementById("cancel");}
	public WebElement GetContiueBtn() {return findingElementById("continue");}
	
	
	
	

}
