package checkoutPage_Test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cartPage.CartPageWebElement;
import checkoutPage.CheckoutPageComp;
import header.HeaderComp;
import header.HeaderWebElement;
import loginPage.LoginPageComp;
import utility.SettingUpWebDriver;

public class CheckoutPageCompTest extends CheckoutPageComp{
	
	@BeforeMethod
	public void OpenCheckoutPage() {
		//open swag labs
		SettingUpWebDriver Browser=new SettingUpWebDriver();
		Browser.OpenBrowser();
		//enter valid data
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		//click on cart button in home Page
		HeaderWebElement Header=new HeaderWebElement();
		Header.CheckCartButtonContainer().click();
		//click on Checkout button in cart page
		CartPageWebElement CartPage=new CartPageWebElement();
		CartPage.GetCheckOutButton().click();
	}
	
	@Test(priority = 1)
	public void CheckHeader() {
		HeaderComp Header=new HeaderComp();
		Header.CheckMenuBtn();
		Header.CheckCheckoutTilte();
	}
	
	@Test(priority = 2)
	public void CheckContainer() {
		CheckCheckoutInfoContainer();
	}
	@Test(priority = 3)
	public void CheckFieldsContainerAddedToWebsite() {
		CheckCheckoutInfoContainer();
		CheckFieldsContainer();
	}
		
	
	@Test(priority = 4)
	public void CheckEnterValidData() {
		CheckCheckoutInfoContainer();
		CheckValidData();
	}
	@Test(priority = 5)
	public void CheckEnterEmptyFirstName() {
		CheckCheckoutInfoContainer();
		CheckEmptyFirstName();
	}
	
	@Test(priority = 6)
	public void CheckEnterEmptyLastName() {
		CheckCheckoutInfoContainer();
		CheckEmptyLastName();
	}
	@Test(priority = 7)
	public void CheckEnterEmptyZipCode() {
		CheckCheckoutInfoContainer();
		CheckEmptyZip();
	}
	@Test(priority = 8)
	public void CheckCancelButton() {
		CheckCheckoutInfoContainer();
		CheckCancelBtn();
	}
	 @Test(priority = 9)
	 public void CheckExcellFile() throws InterruptedException {
		 CheckCheckoutInfoContainer();
		 ExcelFileForAllData();
		 
	 }
	
	
	
	
	

		@AfterMethod
		public void Close(ITestResult result) throws InterruptedException {
	     CloseDriver(result);
	}
	

}
