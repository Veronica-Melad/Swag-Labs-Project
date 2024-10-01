package loginPage_Test;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import loginPage.LoginPageComp;
import utility.SettingUpWebDriver;

public class LoginPageCompTest extends LoginPageComp{

	
	@BeforeMethod
	public void OpenBrowser(ITestResult result) throws Exception {
		SettingUpWebDriver Browser=new SettingUpWebDriver();
		Browser.OpenBrowser(result);
	}
	
	
	@Test(priority = 1)
	public void CheckIfLoginPageOpened() {
		
	CheckLoginPageOpened();
	
		
	}
	
	@Test(priority = 2)
	public void CheckIfFieldsAddedToWebSite() {
		
		CheckLoginPageOpened();
		CheckFieldsAddedToWebSite();
	}
	
	
	
	@Test(priority = 3)
	public void CheckValidDataLogin() {
		
	CheckLoginPageOpened();
	CheckFieldsAddedToWebSite();
	CheckValidData();
		
	}
	
	@Test(priority = 5)
	public void CheckInvalid() {
		
		CheckLoginPageOpened();
		CheckFieldsAddedToWebSite();
		CheckInvalidData();
	}
	
	
	@Test(priority =4)
	public void CheckAllUserNamesLogin() {
			
	  CheckLoginPageOpened();
	  CheckFieldsAddedToWebSite();
	  CheckValidData();
      CheckAllUserNames();
      
	}
	@Test(priority =5)
	public void LoginWithExcelFile() {
		ExcelFileAnotherWay();
	}
	@Test(priority =6)
	public void LoginWithExcelFileForAllData() throws IOException {
		ExcelFileAnotherWayForAllData();
	}
	@Test(priority =7)
	public void configer() throws InterruptedException {
		LoginWithConfig();
	}
	@Test(priority =8)
	public void LoginWithJason() throws  IOException, InterruptedException {
		CheckLoginWithValidDataByJson();
	}
	@Test(priority =9)
	public void checkLoginWithJavaFakerData() throws  IOException, InterruptedException {
		checkLoginWithJavaFaker();
	}
	
	
	
	@AfterMethod
	public void Close(ITestResult result) throws Exception {
     CloseDriver(result);
}
	
}
