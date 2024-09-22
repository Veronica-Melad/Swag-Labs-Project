package checkoutCompletePage_Test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cartPage.CartPageComp;
import checkoutCompletePage.CheckoutCompletePageComp;
import checkoutOverviewPage.CheckoutOverviewPageComp;
import checkoutPage.CheckoutPageComp;
import header.HeaderComp;
import homePage.HomePageComp;
import loginPage.LoginPageComp;
import utility.SettingUpWebDriver;

public class CheckoutCompletePageCompTest extends CheckoutCompletePageComp{

	@BeforeMethod
	public void OpenCheckoutCompletePage() {
		//open swag labs
		SettingUpWebDriver Browser=new SettingUpWebDriver();
		Browser.OpenBrowser();
		//enter valid data
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		//click on cart button in home Page
		HeaderComp Header=new HeaderComp();
		Header.CheckCartButton();
		//click on Checkout button in cart page
		CartPageComp CartPage=new CartPageComp();
		CartPage.ClickCheckoutButton();
		//enter valid data in checkout your information page redirected to checkout overview page
		CheckoutPageComp Checkout=new CheckoutPageComp();
		Checkout.CheckValidData();
		//Click on finish button in checkout overview page and redirected to checkout complete page
		CheckoutOverviewPageComp overviewPage=new CheckoutOverviewPageComp();
		overviewPage.ClickFinishButton();
}
	@Test(priority = 1)
	public void CheckIfCheckoutCompletePageOpened() {
		CheckCheckoutCompletePageOpened();
	}
	
	@Test(priority = 2)
	public void CheckIfCheckoutCompleteTitleAppeared() {
		CheckCheckoutCompletePageOpened();
		CheckTitle();
	}
	
	@Test(priority = 3)
	public void CheckIfCheckoutCompletePageImageAppeared() {
		CheckCheckoutCompletePageOpened();
		CheckImageAddedToWebsite();
	}
	@Test(priority = 4)
	public void CheckIfCheckoutCompleteTextDisplayed() {
		CheckCheckoutCompletePageOpened();
		CheckCheckoutCompleteText();
		
	}
	
	@Test(priority = 5)
	public void CheckBackToHomeBtn() {
		CheckCheckoutCompletePageOpened();
		CheckBackhomeButton();
		
	}
	
	
	


	@AfterMethod
	public void Close(ITestResult result) throws InterruptedException {
     CloseDriver(result);
}
}