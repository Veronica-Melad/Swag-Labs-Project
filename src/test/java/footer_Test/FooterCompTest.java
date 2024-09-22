package footer_Test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import footer.FooterComp;
import homePage.HomePageComp;
import loginPage.LoginPageComp;
import utility.SettingUpWebDriver;

public class FooterCompTest extends FooterComp {
	@BeforeMethod()
	public void OpenHeader() {
		
		   //Open Swag Labs
		    SettingUpWebDriver Browser=new SettingUpWebDriver();
		    Browser.OpenBrowser();
		    //Open Login Page and enter valid data
			LoginPageComp LoginPage=new LoginPageComp();
			LoginPage.CheckValidData();
			//open Home page
			HomePageComp HomePage=new HomePageComp();
			HomePage.CheckHomePageOpened();
			
		}
	
	
@Test(priority = 1)
public void CheckFooterContainer() {
	CheckScrollDownToFooter();
	CheckFooterContainerAddedToWebsite();
}

@Test(priority = 2)
public void ClickOnTwitter() {
	CheckScrollDownToFooter();
	CheckFooterContainerAddedToWebsite();
	ClickTwitterBtn();
}

@Test(priority = 3)
public void ClickOnFacebook() {
	CheckScrollDownToFooter();
	CheckFooterContainerAddedToWebsite();
	ClickFacebookBtn();
}
@Test(priority = 4)
public void ClickOnLinkedIn() {
	CheckScrollDownToFooter();
	CheckFooterContainerAddedToWebsite();
	ClickLinkedInBtn();
}
@Test(priority = 5)
public void CheckFooterTextAppeared() {
	CheckScrollDownToFooter();
	CheckFooterContainerAddedToWebsite();
	CheckFooterText();
}




@AfterMethod
public void Close(ITestResult result) throws InterruptedException {
 CloseDriver(result);
}
}
