package checkoutPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.WebElement;

import utility.ExcelUtils;

public class CheckoutPageComp extends CheckoutPageWebElement {
	
	
	
	public void CheckCheckoutInfoContainer() {
		
		WebElement Container=GetCheckoutInfoContainer();
		assertNotNull(Container);
		
	}
	
	public void CheckFieldsContainer() {
		//Check First Name Field
		String FirstName=GetFirstNameField().getAttribute("placeholder");
		System.out.println(FirstName);
		assertEquals(FirstName,"First Name");
		//Check Last Name Field
		String LastName=GetLastNameField().getAttribute("placeholder");
		System.out.println(LastName);
		assertEquals(LastName,"Last Name");
		//Check Zip Field
		String Zip=GetZipField().getAttribute("placeholder");
		System.out.println(Zip);
		assertEquals(Zip,"Zip/Postal Code");
	}
	
	public void CheckValidData() {
		logger.debug("Enter valid Data in Checkout Page fields");
		GetFirstNameField().sendKeys("Verooo");
		GetLastNameField().sendKeys("Melad");
		GetZipField().sendKeys("56478");
		GetContiueBtn().click();
		//Check Checkout overview Page is opened
		assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
	}
	
	public void CheckEmptyFirstName() {
		GetFirstNameField().sendKeys("");
		GetLastNameField().sendKeys("bhbgchj");
		GetZipField().sendKeys("56478");
		GetContiueBtn().click();
		String ErrorMessage=GetErrorMessageContainer().getText();
		System.out.println(ErrorMessage);
		assertEquals(ErrorMessage,"Error: First Name is required");
		
	}
	
	public void CheckEmptyLastName() {
		GetFirstNameField().sendKeys("dfsdfds");
		GetLastNameField().sendKeys("");
		GetZipField().sendKeys("56478");
		GetContiueBtn().click();
		String ErrorMessage=GetErrorMessageContainer().getText();
		System.out.println(ErrorMessage);
		assertEquals(ErrorMessage,"Error: Last Name is required");
	}
	
	public void CheckEmptyZip() {
		GetFirstNameField().sendKeys("dfsdfds");
		GetLastNameField().sendKeys("cwcd");
		GetZipField().sendKeys("");
		GetContiueBtn().click();
		String ErrorMessage=GetErrorMessageContainer().getText();
		System.out.println(ErrorMessage);
		assertEquals(ErrorMessage,"Error: Postal Code is required");
	}
	public void CheckCancelBtn() {
		GetCancelBtn().click();
		//Check Redirected to Cart Page
		assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
	}
	public void ExcelFileForAllData() throws InterruptedException  {
		logger.debug("Excel File");
		 String excelFilePath = "./Resources/";  
	        String excelFilename = "LoginData.xlsx";  
	        String sheetName = "CheckoutData";  
	        
	        ExcelUtils ExcelData = new ExcelUtils();
	        ExcelData.getAllExcelDataCheckout(excelFilePath, excelFilename, sheetName);
	    
	}
	
	
	
	


}