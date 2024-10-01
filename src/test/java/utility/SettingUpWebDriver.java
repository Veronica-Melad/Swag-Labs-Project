package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.internal.annotations.ITest;

public class SettingUpWebDriver extends ConfigerLoader{
	
	public static WebDriver driver;
	public void OpenBrowser(ITestResult result) throws Exception {
	driver=new ChromeDriver();
	ScreenRecord.startRecording(result.getMethod().getMethodName());
	ConfigerLoader load=new ConfigerLoader();
	driver.navigate().to(load.getConfigValue("config", "url"));
	driver.manage().window().maximize();
	
	

}
	public static WebDriver getDriver() {
        return driver;

    }
	
	public static WebDriver getBrowser(String browserType) {
	    switch (browserType.toLowerCase()) {
	        case "chrome":
	            driver = new ChromeDriver();
	            break;
	        case "firefox":
	            driver = new FirefoxDriver();
	            break;
	        case "edge":
	            driver = new EdgeDriver();
	            break;
	        case "safari":
	            driver = new SafariDriver(); // SafariDriver comes pre-installed with macOS
	            break;
	        case "chrome-headless":
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--headless");
	            options.addArguments("--disable-gpu"); // Applicable for Windows
	            options.addArguments("--window-size=1920,1080");
	            driver = new ChromeDriver(options);
	            break;
	        default:
	            System.out.println("Invalid browser type! Please check the input.");
	    }
	    return driver;
	}
	
	public void CloseDriver(ITestResult result) throws Exception {
		
		if(!result.isSuccess()) {
			String testClassName = result.getTestClass().getName();
	        String testMethodName = result.getMethod().getMethodName();
	        ScreenShots.captureScreenShot(driver, testClassName, testMethodName);  
		}
		ScreenRecord.stopRecording();
 
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	
}
