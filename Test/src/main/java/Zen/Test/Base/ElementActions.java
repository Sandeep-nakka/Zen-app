package Zen.Test.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class ElementActions {

 WebDriver driver;
 Actions action;



  public ElementActions(WebDriver driver)
  { this.driver=driver;
  action = new Actions(this.driver);
  }
 
  
  public  WebElement getElement(By locator) {
		WebElement element=driver.findElement(locator);
		return element;
		
	}
	public  void doClick(By locator) {
		getElement(locator).click();
	}
	
	public  void doSendKeys(By locator , String text){
		getElement(locator).sendKeys(text);
	}
	public void doActionsSendKeys(By locator, String value) {
		action.sendKeys(getElement(locator), value).build().perform();
	}
	 
	
    public  void doClose() {
			 driver.close();
		 }
		 public void doQuit() {
			 driver.quit();
		 }
	
   
     public  String doGetPageTitle() {
	   return driver.getTitle();
}
public String doGetCurrentUrl(){
  	return driver.getCurrentUrl();
}
public String doGetText(By locator){
  	return getElement(locator).getText();
}
public void Switchnexttab(){
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
}
public void Switchprevioustab(){
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");

}
public void Scrollpage(){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1000)");
}
public void getDefaultContent(){
  	driver.switchTo().defaultContent();
}
public String windowhandle(){
  	return driver.getWindowHandle();
}
public Set<String> windowhandles(){
  	Set<String> handles=driver.getWindowHandles();
  	return handles;
}
public void switchwindow(String window){
  	driver.switchTo().window(window);
}

public void waitelementtoload() throws InterruptedException {
  	Thread.sleep(400);
}

public void switchtoiframe(int i) {
	
	driver.switchTo().frame(i);
}

public void switchtoappiframe(String S) {
	
	driver.switchTo().frame(S);
}
public void scrolltoelement(By locator) {
	WebElement element = driver.findElement(locator);
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
}

}
