package Zen.Test.Base;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import Zen.Test.Utils.Log;
import Zen.Test.Utils.ReadYamlConfig;

public class BasePage {
	

		public static WebDriver driver;
		public static String browserName;
		public static String screenshotName;


		public WebDriver init_driver() {
			browserName= ReadYamlConfig.getbrowser();
			Log.info("Executing the Test case in-- "+ browserName.toUpperCase()+" --browser");
			if (browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
			    driver= new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				
			} else {
				Log.info(browserName + " not found, please pass the right browser Name");
			}
			Log.info("Maximizing the Window");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			Log.info("Opening the URL: "+ReadYamlConfig.geturl());
			driver.get(ReadYamlConfig.geturl());
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			return driver;

		}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		File source =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = testCaseName+"_"+d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String destinationFile = System.getProperty("user.dir")+"/Reports/"+screenshotName;
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
//	@AfterClass
//	public void closebrowser(){
//			Log.info("Closing the Browser");
//			driver.quit();
//	}

		
}
