package productPage_Test;

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
import productPage.ProductPageComp;
import utility.SettingUpWebDriver;

public class ProductPageCompTest extends ProductPageComp {
	@BeforeMethod
public void ProductPage(ITestResult result) throws Exception {
		
		SettingUpWebDriver Browser=new SettingUpWebDriver();
		Browser.OpenBrowser(result);
		LoginPageComp loginPage=new LoginPageComp();
		loginPage.CheckValidData();
		HomePageComp homePage=new HomePageComp();
		homePage.CheckProductRandomly();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@Test(priority = 1)
	public void CheckIfProductPageOpened() {
		CheckProductPageOpened();
	}
	@Test(priority = 2)
	public void CheckHeader()  {
		CheckProductPageOpened();
		HeaderComp header=new HeaderComp();
		header.CheckCartButtonContainer();
		header.CheckMenuButtonContainer();
		header.CheckBackToProductsBtnColor();
		header.ClickBackToProductBtn();
		
	}
	
		

	
	@Test(priority = 3)
	public void CheckProductInfo() {
		CheckProductPageOpened();
		CheckProductDetails();
	}
	@Test(priority = 4)
	public void CheckProductImageAppeared() {
		CheckProductPageOpened();
		CheckProductImage();
	}
	@Test(priority = 5)
	public void ClickOnAddOrRemoveBtn() {
		CheckProductPageOpened();
		ClickRemoveBtn();
	}
	@Test(priority = 6)
	public void CheckFooterAddedToWebsite() {
		CheckProductPageOpened();
		FooterComp footer=new FooterComp();
		footer.CheckFooterContainerAddedToWebsite();
	}
	
	
	
	
	
	@AfterMethod
	public void Close(ITestResult result) throws Exception {
     CloseDriver(result);
}

}
