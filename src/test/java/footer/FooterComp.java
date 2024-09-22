package footer;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class FooterComp extends FooterWebElement{
	
	public void CheckScrollDownToFooter() {
		WebElement Container=GetFooterContainer();
		//scroll down to footer
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", Container);
		
	}
	
	public void CheckFooterContainerAddedToWebsite() {
		WebElement Container=GetFooterContainer();
		JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", Container);
		CheckNotNull(Container, "Footer Container");
		//Check the color
		String color=GetFooterContainer().getCssValue("Background");
		System.out.println(color);
		
	}
	
	public void ClickTwitterBtn() {
		GetTwitterBtn().click();
		// Switch to the new window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(driver.getWindowHandle())) {
                driver.switchTo().window(window);
                String url=driver.getCurrentUrl();
        //Check Twitter website opened
        		Checkequals(url, "https://x.com/saucelabs");
                break;
            }
	
	}}
	
	public void ClickFacebookBtn() {
		GetFacebookBtn().click();
		// Switch to the new window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(driver.getWindowHandle())) {
                driver.switchTo().window(window);
		//Check Facebook website opened
              String url=driver.getCurrentUrl();
	       	Checkequals(url, "https://www.facebook.com/saucelabs");
	}}}
	
	public void ClickLinkedInBtn() {
		GetLinkedInBtn().click();
		// Switch to the new window
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(driver.getWindowHandle())) {
                driver.switchTo().window(window);
		//Check LinkedIn website opened
		String url=driver.getCurrentUrl();
		Checkequals(url, "https://www.linkedin.com/company/sauce-labs/");
	}}}
	
	public void CheckFooterText() {
		String text=GetFooterText().getText();
		System.out.println(text);
		Checkequals(text, "© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
	}
	
	

}
