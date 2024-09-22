package productPage;

import java.awt.event.ActionEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductPageComp extends ProductPageWebElement {
	
	public void CheckProductPageOpened() {
		logger.debug(" Check Product Page is Opened");
		//Check URL
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		//Check Container
		WebElement container=GetProductDetailsContainer();
		CheckNotNull(container, "Product Container");
	}
	
		
	public void CheckProductDetails() {
		logger.debug(" Check Products info");
		String info=GetProductDetailsContainer().getText();
		System.out.println(info);}
	
	public void CheckProductImage() {
		logger.debug(" Check Products Image");
		WebElement image=GetProductImage();
		CheckIsDisplayed(image, "product image");
	}
	public void ClickRemoveBtn() {
		logger.debug(" Click on Add or Remove button");
		CheckIfButtonIsEnable(GetRemoveBtn(), "Add to cart Or Remove button");
		GetRemoveBtn().click();
		
	}

}
