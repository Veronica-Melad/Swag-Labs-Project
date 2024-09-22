package loginPage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

import homePage.HomePageWebElement;
import utility.ConfigerLoader;
import utility.ExcelUtils;
import utility.WaitingMethod;




public class LoginPageComp extends LoginPageWebElement {
	
	
	
	public void CheckLoginPageOpened() {
		
		logger.debug("Check if login page opened");
		
		//logo 
		String title=driver.getTitle();
		Checkequals(title, "Swag Labs");
		
		//URL
		String URL= driver.getCurrentUrl();
		 Checkequals(URL,"https://www.saucedemo.com/");
		 
		 //Container
		  WebElement  Container =  GetLoginContainer();
		   CheckNotNull(Container, "Container");
		   
		
			
		 
		 
		 
	}
	
	public void CheckFieldsAddedToWebSite() {
		
		logger.debug("Check fields added to login page");
		
		//Check username field
		WebElement username=GetUserNameField();
		CheckNotNull(username," username field");
		String UserNamePlaceholder=GetUserNameField().getAttribute("placeholder");
		Checkequals(UserNamePlaceholder, "Username");
		
		//check password field
		WebElement Password=GetPasswordField();
		CheckNotNull(Password,"Password field");
		String PasswordPlaceholder=GetPasswordField().getAttribute("placeholder");
		Checkequals(PasswordPlaceholder, "Password");
		
		//check login button
		WebElement btn=GetLoginBtn();
		CheckIfButtonIsEnable(btn, "Login button");
		//check  color
		String color=GetLoginBtn().getCssValue("Background");
		System.out.println(color);}
	
	
	
	public void CheckValidData() {
		
		logger.debug("Check enter valid data");
		
		WebElement username=GetUserNameField();
		username.sendKeys("standard_user");
		WebElement Password=GetPasswordField();
		Password.sendKeys("secret_sauce");
		WebElement btn=GetLoginBtn();
		btn.click();
		//check login successfully
			String URL= driver.getCurrentUrl();
			System.out.println(URL);
  		   Checkequals(URL,"https://www.saucedemo.com/inventory.html");
		
	}
	public void CheckInvalidData() {
		
		logger.debug("Check enter invalid data at login page");
		
		WebElement username=GetUserNameField();
		username.sendKeys("vgvhbvgv");
		WebElement Password=GetPasswordField();
		Password.sendKeys("hvgvge");
		WebElement btn=GetLoginBtn();
		btn.click();
		String ErrorMessage=GetErrorMessage().getText();
		System.out.println(ErrorMessage);
		Checkequals(ErrorMessage,"Epic sadface: Username and password do not match any user in this service");
		
	}
	public void CheckAllUserNamesContainer() {
		WebElement container=GetAllUserNamesContainer();
		 CheckNotNull(container, "Container");
		 //Check container color
		 WebElement  Container =  GetLoginContainer();
		  CheckNotNull(Container, "Container");
		 
	}
	
	
	
	public void CheckAllUserNames() {
		
		logger.debug("Check input all usernames");
		
		List<String>AcceptedUserName=Arrays.asList(
				"standard_user",
				"locked_out_user",
				"problem_user",
				"performance_glitch_user",
				"error_user",
				"visual_user");
		
		for(String username: AcceptedUserName) {
			driver.navigate().to("https://www.saucedemo.com/");
			GetUserNameField().sendKeys(username);
			GetPasswordField().sendKeys("secret_sauce");
			GetLoginBtn().click();
			//check login successfully
			String URL= driver.getCurrentUrl();
			System.out.println(URL);
			
		;
  		   if(URL.equals("https://www.saucedemo.com/inventory.html" )){
  			   System.out.println("Login successful for username: " + username);
  		   }
  		   else  {
  			 System.out.println("Login failed for username: " + username);
             String ErrorMessage=GetErrorMessage().getText();
     		System.out.println(ErrorMessage);
     		Checkequals(ErrorMessage,"Epic sadface: Sorry, this user has been locked out.");
     		
  		   }
               
               
               
               driver.navigate().back();
               }
	
		}
	public void ExcelFileAnotherWay() {
		
		logger.debug("Excel File");
		 String excelFilePath = "./Resources/";  
	       String excelFilename = "LoginData.xlsx";  
	       String sheetName = "loginData";  

	       
	       ExcelUtils ExcelData = new ExcelUtils();
	       String username = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 1, 0);
	       System.out.println("Username: " + username);

	       WebElement userNameField = GetUserNameField();
	       userNameField.sendKeys(username);
	      
	       String password = ExcelData.getExcelData(excelFilePath, excelFilename, sheetName, 1, 1);
	       System.out.println("Password: " + password);
	       
	       WebElement passwordField = GetPasswordField();
	       passwordField.sendKeys(password);
	       
	       WebElement loginButton = GetLoginBtn();
	       loginButton.click();
		}
	

	
	
	public void ExcelFileAnotherWayForAllData() {
		logger.debug("Excel File");
		 String excelFilePath = "./Resources/";  
	        String excelFilename = "LoginData.xlsx";  
	        String sheetName = "loginData";  
	        
	        ExcelUtils ExcelData = new ExcelUtils();
	        ExcelData.getAllExcelData(excelFilePath, excelFilename, sheetName);
	    
	}
	public void LoginWithConfig() throws InterruptedException {
	    logger.debug("Login With Config Data");
	    
	    ConfigerLoader config=new ConfigerLoader();

	    System.out.println("The Name Is: " +config.getConfigValue("config", "UserName"));

	    WebElement UserNameField = GetUserNameField();
	    WebElement PasswordField = GetPasswordField();
	    WebElement loginButton = GetLoginBtn();
	    
	   WaitingMethod wait =new WaitingMethod();
	    

	    UserNameField.sendKeys(config.getConfigValue("config", "UserName"));
	    PasswordField.sendKeys(config.getConfigValue("config", "Password"));
	    

	    // Add code to click the login button here
	    loginButton.click();
	    
	    HomePageWebElement home=new HomePageWebElement();
	    wait.explicitlyWaitForVisibility(home.GetAllProductsContainer());
	}
		
	

	
	public void CloseBrowser() throws InterruptedException {
    	Thread.sleep(2000);
    	driver.quit();
		
	}
}