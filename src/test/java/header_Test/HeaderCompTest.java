package header_Test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import header.HeaderComp;
import homePage.HomePageComp;
import leftSideBar.LeftSideBarComp;
import loginPage.LoginPageComp;
import utility.SettingUpWebDriver;


public class HeaderCompTest extends HeaderComp {
	
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
	public void CheckProductTitleAppeared() {
		CheckProductTitle();
	}
	@Test(priority = 2)
	public void CheckCartBtn() {
		CheckCartButton();
		
	}
	
	@Test(priority=3)
	public void CheckMenuButton() {
		CheckMenuBtn();
	}
	@Test(priority = 4)
	public void CheckDropDown() {
		CheckDropDownContainer();
		
	}
	@Test(priority = 5)
	public void CheckLeftSideBarAddedToHeader() {
		LeftSideBarComp LeftSideBar=new LeftSideBarComp();
		LeftSideBar.CheckLeftSideBarContainer();
		
	}
	
	
	

	@AfterMethod
	public void Close(ITestResult result) throws InterruptedException {
     CloseDriver(result);
}

}
