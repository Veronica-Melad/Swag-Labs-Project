package utility;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WaitingMethod extends SettingUpWebDriver {

	    static ConfigerLoader Load = new ConfigerLoader();

	    public static void explicitlyWaitForClickability(WebElement element) {
	        new WebDriverWait(driver, Duration.ofMillis(Integer.parseInt(Load.getConfigValue("config", "WAIT_EXPLICIT"))))
	                .until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public static void explicitlyWaitForVisibility(WebElement element) {
	        try {
	            new WebDriverWait(driver, Duration.ofMillis(Integer.parseInt(Load.getConfigValue("config", "WAIT_EXPLICIT"))))
	                    .until(ExpectedConditions.visibilityOf(element));
	        } catch (NoSuchElementException e) {
	            System.out.println("The Element Is: " + e);
	        }
	    }

}
