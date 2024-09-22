package homePage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class HomePageWebElement extends FindingElements {
	
	public  WebElement GetAllProductsContainer(){return  findingElementById("inventory_container");}
	public WebElement product() {return findingElementByClassName("inventory_item");}
	public WebElement GetproductImage() {return findingElementByClassName("inventory_item_img");}
	public WebElement GetProductName() {return findingElementByClassName("inventory_item_name");}
	public WebElement GetAddToCart() { return findingElementByClassName("btn_inventory");}
	public WebElement GetRemove() { return findingElementByClassName("btn_inventory");}
	public WebElement GetCartButtonNumber() {return findingElementByClassName("shopping_cart_badge");}
	public List<WebElement>AllProductsList(){return  findingElementByClassNameInList("inventory_item");  }
	public WebElement GetTestAllThingProduct() {return findingElementById("item_3_title_link");}


}
