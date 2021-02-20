package Zen.Test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Zen.Test.Base.ElementActions;
import Zen.Test.Utils.ReadYamlConfig;


public class LoginPage {

	WebDriver driver;
	ElementActions elementActions;
	// 1. By locators - Page Objects
     By email = By.xpath("//input[@id='user_email']");
	 By password = By.xpath("//input[@id='user_password']");
	 By signin= By.xpath("//input[@id='sign-in-submit-button']");
	 By loggedinuser=By.xpath("//a[normalize-space()='Melissa Wylie']");
	 By userMessageContent=By.id("userMessageContent");
	 By alerterror=By.xpath("//li[normalize-space()='Email is required']");
	

	// 2. Constructor of page class:
	public LoginPage(WebDriver driver) 
	{ 
		this.driver = driver; 
	   elementActions = new ElementActions(this.driver);
	}
	 

		// 3. page actions/methods:
		public   String getPageTitle() {
			return elementActions.doGetPageTitle();
			
		}

	    public  void doLogin(String emailId, String pwd) throws InterruptedException {
			 System.out.println("Entering doLogin");
			 elementActions.switchtoiframe(0);
			 Thread.sleep(300);
		     elementActions.doSendKeys(email, emailId);
		     elementActions.waitelementtoload();
			 elementActions.doSendKeys(password, pwd);
			 elementActions.waitelementtoload();
			 elementActions.doClick(signin);
			 elementActions.waitelementtoload();
			
		} 
	    
	    public void TicketUrl() {
	    	driver.get(ReadYamlConfig.ticketurl());
	    }
	public String getCurrentUrl(){
		return elementActions.doGetCurrentUrl();
}
	public String getLoggeduser() throws InterruptedException {
		elementActions.waitelementtoload();
		return elementActions.doGetText(loggedinuser);

	}
	public String getusermessage(){
		return elementActions.doGetText(userMessageContent);
	}
	public String geterrorText() {
		return elementActions.doGetText(alerterror);
	}

}
