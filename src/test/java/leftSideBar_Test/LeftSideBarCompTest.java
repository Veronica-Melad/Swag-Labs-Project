package leftSideBar_Test;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import leftSideBar.LeftSideBarComp;
import loginPage.LoginPageComp;
import utility.SettingUpWebDriver;

public class LeftSideBarCompTest extends LeftSideBarComp{
	

	@BeforeMethod()
	public void OpenHomePage() {
		
		    SettingUpWebDriver Browser=new SettingUpWebDriver();
		    Browser.OpenBrowser();
			LoginPageComp loginPage=new LoginPageComp();
			loginPage.CheckValidData();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}
	
		
	
	
	@Test(priority=1)
	public void CheckIfLeftSideBarContainer() {
		
		ClickMenuBtn();
		CheckLeftSideBarContainer();
		
		
	}
	@Test(priority=2)
   public void CheckAllItems() throws InterruptedException {	
		
		ClickMenuBtn();
		CheckLeftSideBarContainer();
		ClickAllItemsBtn();
		
	}
	@Test(priority=3)
	public void CheckAbout() throws InterruptedException {
			
		ClickMenuBtn();
		CheckLeftSideBarContainer();
		Thread.sleep(2000);
		ClickAboutBtn();
		
	}
	@Test(priority=4)
	public void CheckLogOut() throws InterruptedException {
		
		ClickMenuBtn();
	    CheckLeftSideBarContainer();
	    ClickLogoutBtn();
	}
	
	@Test(priority = 5)
	public void CheckResetBtn() {
		
		ClickMenuBtn();
		CheckLeftSideBarContainer();
		ClickResetAppStateBtn();
	}
	

	@AfterMethod
	public void Close(ITestResult result) throws InterruptedException {
     CloseDriver(result);
}

	

}
