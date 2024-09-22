package cartPage_Test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cartPage.CartPageComp;
import header.HeaderComp;
import homePage.HomePageComp;
import homePage_Test.HomePageCompTest;
import loginPage.LoginPageComp;
import loginPage_Test.LoginPageCompTest;
import utility.SettingUpWebDriver;

public class CartPageCompTest extends CartPageComp{
	
	@BeforeMethod
	public void OpenCartPage() {
		SettingUpWebDriver Browser=new SettingUpWebDriver();
		Browser.OpenBrowser();
	
	}
	
	@Test(priority = 1)
	public void CheckIfCartPageOpened() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		GetCartButton().click();
		CheckCartPageOPened();
	}
	
	@Test(priority = 2)
	public void CheckHeader() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		GetCartButton().click();
		CheckCartPageOPened();
		HeaderComp header=new HeaderComp();
		header.CheckYourCartTitle();
		header.CheckMenuBtn();
		
	}
	@Test(priority = 3)
	public void CheckQuantityText() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		GetCartButton().click();
		CheckCartPageOPened();
		CheckQuantityTiltle();
		
	}
	
	@Test(priority = 4)
	public void CheckDescription() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		GetCartButton().click();
		CheckCartPageOPened();
		CheckDescriptionTitle();
		
	}
	@Test(priority = 5)	
	public void CheckCartItem() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		HomePageComp homePage=new HomePageComp();
		homePage.ClickOnAddToCartButton();
		GetCartButton().click();
		CheckCartPageOPened();
		CheckProductInfo();
		ClickRemoveBtn();
		
	}
	
	@Test(priority = 6)
	public void CheckAllItemsDetails() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		HomePageCompTest homePageTest=new HomePageCompTest();
		homePageTest.CheckIfProductsAddedToWebSite();
		GetCartButton().click();
		CheckCartPageOPened();
		CheckCartItems();
	}
	@Test(priority = 7)
	public void CheckContinueShoopingBtn() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		GetCartButton().click();
		CheckCartPageOPened();
		ClickContinueShoppingButton();
	}
	
	@Test(priority = 8)
	public void CheckCheckoutBtn() {
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		GetCartButton().click();
		CheckCartPageOPened();
		ClickCheckoutButton();
	}
	
	
	
	
	
	

	@AfterMethod
	public void Close(ITestResult result) throws InterruptedException {
     CloseDriver(result);
}
	
	
	
	
	
	
	
	
	

}
