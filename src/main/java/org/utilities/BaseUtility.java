package org.utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseUtility {
	
private WebDriver driver;                   //Null Value

public WebDriver startUp(String url, String BroweserName) {
		if(BroweserName.equalsIgnoreCase("ch") || 
				BroweserName.equalsIgnoreCase("chrome") )
		{
			System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();        //Upcasting
		}
		else if (BroweserName.equalsIgnoreCase("edge") )
		{	
			System.setProperty("webdriver.edge.driver",
					".\\Driver\\msedgedriver.exe" );	
			driver = new EdgeDriver();         //Upcasting
		}
		else 	
		{
			System.out.println("Invalid Browser Name");
		}
			driver.manage().window().maximize();
			 
			//driver.manage().window().setSize(new Dimension(400, 300));
			//Selenium 4 onwards
			//driver.manage().window().minimize();	
			
//Generic method not created because of once implicit wait apply it will applicable on webdriver till it live		
			//Selenium 3 ImplecitlyWait 
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Selenium 4 Onward
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			driver.get(url);
			
			return driver;
		
						
	}

// Explicit wait generic method

//public void waitForVisibilityOfElementLocated(WebDriver driver, int time, String type, String Locater) {
	
      public void waitForVisibilityOfElementLocated(WebDriver driver, int time, String type, String Locater) {
		WebDriverWait wt = new WebDriverWait(driver, time);
		switch(type) {
		case "id" : wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(Locater))); 
		break;
		
		case "class" : wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(Locater)));
		break;
		
		case "xpath" : wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Locater)));
		break;
		
		case "css" : wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(Locater)));
		break;
		
		// need to add remaning 4 locater
		}
}
//  generic method for ClickByJS
	public void clickByJS(WebElement ele, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", ele);
	}  

//Scroll by js 
	public void scrollByJS(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	


//Scroll by page down key
	public void scrollbyPageDown(WebDriver driver, int num) {
		for(int i=0; i<=num; i++ ) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		}
	}
	
	
//Print all data in DropDown
	public ArrayList<String> getAllTextFromDDL(WebElement ele) {
		ArrayList<String> ar = new ArrayList<String>();
		Select sel = new Select(ele);
//		List<WebElement> allEle = sel.getOptions();
		for(int i=0; i<sel.getOptions().size(); i++) {
			ar.add(sel.getOptions().get(i).getText());			
		}
		return ar;
	}
	
	
//To get All Option form Dropdown list
		public List<WebElement> getAllOptionFromDDL(WebElement ele) {
			Select sel = new Select(ele);		
			return sel.getOptions();
		}
		
//To get Number of Option present 
		public int getNumberOFOptionFromDDL(WebElement ele) {
			Select sel = new Select(ele);		
			return sel.getOptions().size();
		}
	
//For alerts 
		public boolean isAlertIsPresent(WebDriver driver, int time) {
			try {
				WebDriverWait wt = new WebDriverWait(driver, time);
				wt.until(ExpectedConditions.alertIsPresent());
			    return true;
			}
			catch(Exception e){
			    return false;
			}
		}
		
//For wait until Partialurl not contain in URL
		public void waitForUrlContains(WebDriver driver, int time, String partialUrl) {
			WebDriverWait wt = new WebDriverWait(driver, time);
			wt.until(ExpectedConditions.urlContains(partialUrl));
		}
}

