package homePage_Test;

import java.time.Duration;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import footer.FooterComp;
import header.HeaderComp;
import homePage.HomePageComp;
import leftSideBar.LeftSideBarComp;
import loginPage.LoginPageComp;
import utility.ScreenRecord;


public class HomePageCompTest extends HomePageComp {
	
	@BeforeMethod
	public void OpenHomePage(ITestResult result) throws Exception {
		OpenBrowser(result);
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@Test(priority = 1)
	public void CheckHeader() {
		HeaderComp header=new HeaderComp();
		header.CheckMenuBtn();
		header.CheckDropDown_AtoZ();
		header.CheckDropDown_ZtoA();
		header.CheckDropDown_LowtoHigh();
		LeftSideBarComp LeftSideBar=new LeftSideBarComp();
		LeftSideBar.CheckLeftSideBarContainer();
		header.CheckCartButton();
	}
	
	@Test(priority = 2)
	
	public void CheckIfHomePageOpened() {
		
	CheckHomePageOpened();
	}
	@Test(priority = 3)
	public void CheckProductImageDisplayed() {
		CheckHomePageOpened();
		CheckProductImage();
	}
	
	@Test(priority = 4)
	public void CheckProductinfoDisplayed() {
		CheckHomePageOpened();
		CheckProductinfo();
	}
	
	@Test(priority = 5)
	public void CheckProductNameColorDisplayed() {
		CheckHomePageOpened();
		CheckProductNameColor();
	}
	@Test(priority = 6)
	public void ClickAddToCartBtn() {
		CheckHomePageOpened();
		ClickOnAddToCartButton();
	}
	
	@Test(priority = 7)
	public void CheckIfProductsAddedToWebSite() {
		
		CheckHomePageOpened();
		CheckProductsAddedToWebsite();
	}
	@Test(priority = 8)
	public void CheckProductItemDetails()  {
		
		CheckHomePageOpened();
		CheckProductRandomly();
	}
	@Test(priority = 9)
	public void CheckScrollDownToElement() {
		CheckHomePageOpened();
		CheckScrollDown();
	}
	@Test(priority = 10)
	public void CheckFooterAddedToWebsite() {
		CheckHomePageOpened();
		FooterComp footer=new FooterComp();
		footer.CheckFooterContainerAddedToWebsite();
	}


	@AfterMethod
	public void Close(ITestResult result) throws Exception {
     CloseDriver(result);
}
	
	
	

}
