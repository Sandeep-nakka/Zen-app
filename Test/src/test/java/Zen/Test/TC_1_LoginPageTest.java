package Zen.Test;

import Zen.Test.Base.BasePage;
import Zen.Test.Pages.LoginPage;
import Zen.Test.Utils.Log;
import Zen.Test.Utils.ReadYamlConfig;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_1_LoginPageTest extends BasePage{
	WebDriver driver;
	LoginPage loginPage;

    @Test
    public void loginTest() throws InterruptedException {
        driver=init_driver();
        loginPage=new LoginPage(driver);
        Log.info("Executing : "+this.getClass().getName());
		loginPage.doLogin(ReadYamlConfig.getEmail(),ReadYamlConfig.getPassword());
		Log.info(loginPage.getPageTitle());
		Assert.assertEquals(loginPage.getPageTitle(),"Zendesk...");

		
	}


}
