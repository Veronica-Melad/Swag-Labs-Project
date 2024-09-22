package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

public class SettingUpWebDriver extends E2E_Logger{
	
	public static WebDriver driver;
	public void OpenBrowser() {
	driver=new ChromeDriver();
	ConfigerLoader load=new ConfigerLoader();
	driver.navigate().to(load.getConfigValue("config", "url"));
	driver.manage().window().maximize();

}
	public static WebDriver getDriver() {
        return driver;

    }
	public void CloseDriver(ITestResult result) throws InterruptedException {
		
		if(!result.isSuccess()) {
			String testClassName = result.getTestClass().getName();
	        String testMethodName = result.getMethod().getMethodName();
	        ScreenShots.captureScreenShot(driver, testClassName, testMethodName);  
		}
 
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}
