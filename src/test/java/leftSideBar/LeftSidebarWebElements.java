package leftSideBar;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.FindingElements;

public class LeftSidebarWebElements extends FindingElements{
	
	public WebElement GetSideBarListContainer() {return findingElementByClassName("bm-item-list");}
	public WebElement GetMenuButtonContainer() {return findingElementById("menu_button_container");}
	public WebElement GetBurgerButton() { return findingElementById("react-burger-menu-btn");}
	public WebElement GetAllItemsContainer() {return findingElementById("inventory_sidebar_link");}
	public WebElement GetAboutContainer() { return findingElementById("about_sidebar_link");}
	public WebElement GetLogoutContainer() {return findingElementById("logout_sidebar_link");}
	public WebElement GetResetAppStateContainer() {return findingElementById("reset_sidebar_link");}

}
