package checkoutOverviewPage_Test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cartPage.CartPageComp;
import checkoutOverviewPage.CheckoutOverviewPageComp;
import checkoutPage.CheckoutPageComp;
import header.HeaderComp;
import homePage.HomePageComp;
import loginPage.LoginPageComp;
import utility.SettingUpWebDriver;

public class CheckoutOverviewPageCompTest extends CheckoutOverviewPageComp{
	

	@BeforeMethod
	public void OpenCheckoutOverviewPage()  {
		//open swag labs
		SettingUpWebDriver Browser=new SettingUpWebDriver();
		Browser.OpenBrowser();
		//enter valid data
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		//add products to the cart
		HomePageComp homePage=new HomePageComp();
		 homePage.CheckProductRandomly();
		//click on cart button in home Page
		HeaderComp Header=new HeaderComp();
		Header.CheckCartButton();
		//click on Checkout button in cart page
		CartPageComp CartPage=new CartPageComp();
		CartPage.ClickCheckoutButton();
		//enter valid data in checkout your information page redirected to checkout overview page
		CheckoutPageComp Checkout=new CheckoutPageComp();
		Checkout.CheckValidData();
		
		
	}
	
	@Test(priority = 1)
	public void CheckHeader() {
		HeaderComp header=new HeaderComp();
		header.CheckMenuBtn();
		header.CheckCkeckoutOverviewTitle();
	}
	
	@Test(priority = 2)
	public void CheckSummaryContainer() {
		CheckCheckoutSummaryContainer();
	}
	 @Test(priority = 3)
	 public void CheckItems(){
		 CheckCheckoutSummaryContainer();
		 CheckCartItems();
		
	 }
	 
	 @Test(priority = 4)
	 public void CheckPaymentInfo(){
		 CheckCheckoutSummaryContainer();
		 CheckCartItems();
		 CheckPaymentSummaryInfo();
		
	 }
	 @Test(priority = 5)
	 public void ClickFinishBtn(){
		 CheckCheckoutSummaryContainer();
		 CheckCartItems();
		 ClickFinishButton();
		
	 }
	 @Test(priority = 6)
	 public void ClickCancelBtn(){
		 CheckCheckoutSummaryContainer();
		 CheckCartItems();
		 ClickCancelButton();
		
	 }
	
	
	
	


		@AfterMethod
		public void Close(ITestResult result) throws InterruptedException {
	     CloseDriver(result);
	}
	
	
	

}
