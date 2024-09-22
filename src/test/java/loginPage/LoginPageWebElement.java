package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.FindingElements;

public class LoginPageWebElement extends FindingElements {
	
	
	public WebElement GetLoginContainer() {return findingElementByClassName("login_container");}
	public WebElement GetLogoContainer() { return findingElementByClassName("login_logo"); }
	public WebElement GetUserNameField() {return findingElementById("user-name");}
	public WebElement GetPasswordField() {return findingElementById("password");}
	public WebElement GetLoginBtn() {return findingElementById("login-button");}
	public WebElement GetErrorMessage() {return findingElementByXpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");}
	public WebElement GetAllUserNamesContainer() {return findingElementByClassName("login_credentials_wrap-inner");}
	}
	
	
	


