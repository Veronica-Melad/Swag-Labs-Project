package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import checkoutOverviewPage_Test.CheckoutOverviewPageCompTest;
import checkoutPage.CheckoutPageWebElement;
import loginPage.LoginPageWebElement;

public class ExcelUtils {
	

		
	public static String getExcelData(String excelFilePath, String excelFilename, String sheetName, int rowNum,
			int colNum) {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		String cellData;
 
		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFilename);
			workbook = new XSSFWorkbook(file);
 
			sheet = workbook.getSheet(sheetName);
 
			// Get the data from the specified cell
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
 
			workbook.close();
			return cellData;
		} catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
			return null;
		}
	}
	public static String getAllExcelData(String excelFilePath, String excelFilename, String sheetName) {
		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFilename);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
 
			// Iterate through all the rows in the Excel sheet
			Iterator<Row> rowIterator = sheet.iterator();
 
 
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
 
				// Fetch username and password from the current row
				String userName = row.getCell(0).getStringCellValue();  // ---> Column 0 (Username)
				String Password = row.getCell(1).getStringCellValue();  // ---> Column 1 (Password)
 
 
 
 
				System.out.println("Username: " + userName + ", Password: " + Password);
 
				LoginPageWebElement webELement =new  LoginPageWebElement();
				WebElement userNameElement= webELement.GetUserNameField();
				WebElement PasswordElement = webELement.GetPasswordField();
				WebElement loginButton = webELement.GetLoginContainer();
 
				userNameElement.clear();
				userNameElement.sendKeys(userName);
				PasswordElement.clear();
				PasswordElement.sendKeys(Password);
				loginButton.click();
				SettingUpWebDriver.getDriver().navigate().back();
 
			}
 
 
			workbook.close();
 
 
		} catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
		}
 
		return null;
	}
	public static String getAllExcelDataCheckout(String excelFilePath, String excelFilename, String sheetName) throws InterruptedException  {
		try {
			// Load the Excel file
			FileInputStream file = new FileInputStream(excelFilePath + excelFilename);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet(sheetName);
 
			// Iterate through all the rows in the Excel sheet
			Iterator<Row> rowIterator = sheet.iterator();
 
 
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
 
				// Fetch username and password from the current row
				String userName = row.getCell(0).toString();  // ---> Column 0 (Username)
				String Password = row.getCell(1).toString();  // ---> Column 1 (Password)
                String Zip=row.getCell(2).toString();  // ---> Column 2 (Zip)
 
 
 
				System.out.println("Username: " + userName + ", Password: " + Password +", Zip: " +Zip);
 
				CheckoutPageWebElement webELement =new  CheckoutPageWebElement();
				WebElement userNameElement= webELement.GetFirstNameField();
				WebElement PasswordElement = webELement.GetLastNameField();
				WebElement ZipElement=webELement.GetZipField();
				WebElement ContinueButton = webELement.GetContiueBtn();
 
				userNameElement.clear();
				userNameElement.sendKeys(userName);
				PasswordElement.clear();
				PasswordElement.sendKeys(Password);
				ZipElement.clear();
				ZipElement.sendKeys(Zip);
				ContinueButton.click();
				Thread.sleep(1000);
				SettingUpWebDriver.getDriver().navigate().back();
 
			}
 
 
			workbook.close();
 
 
		} catch (IOException e) {
			System.out.println("Error reading Excel file: " + e.getMessage());
		}
 
		return null;
	}
 
}