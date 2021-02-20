package Zen.Test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Zen.Test.Base.ElementActions;

import java.util.Iterator;
import java.util.Set;

public class HomePage {
    WebDriver driver;
    ElementActions elementActions;

    By AppButton= By.xpath("//button[normalize-space()='Apps']");
    By Makeaproject=By.xpath("//div[@class='centered']/Button");
    By singleticket=By.xpath("//button[@class='parent displayForm ember-view btn']");
    By createticket=By.className("submitSpoke ember-view btn");
    
    String str="app_APP_ticket_sidebar_2c30aa06-0c41-4375-bdda-7e0df85b9b84";
   
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        elementActions = new ElementActions(this.driver);
    }
    
    public void clickonapps() throws InterruptedException {
    	elementActions.waitelementtoload();
    	elementActions.doClick(AppButton);
    	elementActions.waitelementtoload();
    	elementActions.switchtoiframe(1);;
   
    }

    public void clickonmakeproject() throws InterruptedException {
    	
    	elementActions.waitelementtoload();
    	Thread.sleep(400);
    	elementActions.doClick(Makeaproject);
    }
    
    public void singleticket() throws InterruptedException {
    	
    	elementActions.doClick(singleticket);
    	elementActions.waitelementtoload();
 	    elementActions.Scrollpage();
    }
   public void createsingleticket() throws InterruptedException {
	   
	   elementActions.waitelementtoload();
	   elementActions.scrolltoelement(createticket);
	   elementActions.doClick(createticket);
   }

}
