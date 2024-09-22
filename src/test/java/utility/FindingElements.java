package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindingElements extends TestMethod {
	
	
	
	public WebElement findingElementById(String id) {WebElement webElement =driver.findElement(By.id(id));
	return webElement ;}
	public WebElement findingElementByClassName(String ClassName) {WebElement webElement =driver.findElement(By.className(ClassName));
	return webElement ;}
	public WebElement findingElementByXpath(String Xpath) {WebElement webElement =driver.findElement(By.xpath(Xpath));
	return webElement ;}
	public WebElement findingElementByTagName(String tagName) {WebElement webElement =driver.findElement(By.tagName(tagName));
	return webElement ;}
	public WebElement findingElementBycssSelector(String cssSelector) {WebElement webElement =driver.findElement(By.tagName(cssSelector));
	return webElement ;}
	public List<WebElement>findingElementByClassNameInList(String ClassName) {List<WebElement>webElement =driver.findElements(By.className(ClassName));
	return webElement ;}
	
	
	

}
