package productPage;

import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class ProductPageWebElement extends FindingElements{
	
	public WebElement GetProductDetailsContainer() {return findingElementByClassName("inventory_details_container");}
	public WebElement GetProductImage() {return findingElementByClassName("inventory_details_img_container");}
	public WebElement GetRemoveBtn() {return findingElementByClassName("btn_inventory");}

}
