package footer;

import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class FooterWebElement extends FindingElements{
	
	public WebElement GetFooterContainer() {return findingElementByClassName("footer");}
	public WebElement GetTwitterBtn() {return findingElementByClassName("social_twitter");}
	public WebElement GetFacebookBtn() {return findingElementByClassName("social_facebook");}
	public WebElement GetLinkedInBtn() {return findingElementByClassName("social_linkedin");}
	public WebElement GetFooterText() {return findingElementByClassName("footer_copy");}
	

}
