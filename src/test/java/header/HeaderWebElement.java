package header;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import loginPage.LoginPageWebElement;
import utility.FindingElements;


public class HeaderWebElement extends FindingElements{
	
	
	public WebElement CheckHeaderContainer() { return findingElementById("header_container");}
	public WebElement CheckLogoContainer() { return findingElementByClassName("app_logo");}
	public WebElement CheckMenuButtonContainer() {return findingElementById("menu_button_container");}
	public WebElement CheckCartButtonContainer() {return findingElementById("shopping_cart_container");}
	public WebElement CheckProductTitleContainer() {return findingElementByClassName("title");}
	public WebElement CheckDropdownListContainer() {return findingElementByClassName("select_container");}
	public WebElement GetBackToProductsButton() {return findingElementByClassName("left_component");}
	public WebElement GetDropDownContainer() {return findingElementByClassName("product_sort_container");}
	public WebElement AtoZ() { return findingElementByXpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]");}
	public WebElement ZtoA() { return findingElementByXpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]");}
	public WebElement LowToHigh() {return findingElementByXpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[3]");}
	public WebElement HighToLow() {return findingElementByXpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[4]");}
	public  List<WebElement> AllProducts(){return  driver.findElements(By.id("inventory_container"));}
	public WebElement GetYourCartTitle() {return findingElementByClassName("title");}
	public WebElement GetCheckoutTitle() {return findingElementByClassName("title");}
	public WebElement GetCheckoutOverviewTiltle() { return findingElementByClassName("title");}
	
	
	

}
