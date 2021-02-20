package Zen.Test;

import Zen.Test.Base.BasePage;
import Zen.Test.Pages.HomePage;
import Zen.Test.Pages.LoginPage;
import Zen.Test.Utils.Log;
import Zen.Test.Utils.ReadYamlConfig;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_2_CreateChildTicket extends BasePage{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;

    @Test
    public void loginTest() throws InterruptedException {
        driver=init_driver();
        loginPage=new LoginPage(driver);
        homepage=new HomePage(driver);
        
        Log.info("Executing : "+this.getClass().getName());
		loginPage.doLogin(ReadYamlConfig.getEmail(),ReadYamlConfig.getPassword());
		loginPage.TicketUrl();
		homepage.clickonapps();
		homepage.clickonmakeproject();
		homepage.singleticket();
		homepage.createsingleticket();
		
		

		
	}


}
