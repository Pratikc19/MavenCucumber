package org.page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.utilities.BaseUtility;

public class DashBoardPage {
  
	WebDriver driver = null;
	//WebElemets
	
	@FindBy(id = "logoutLink")
	private WebElement logoutLink ;
	
	
	//Constructor
	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
	//	PageFactory.initElements(driver, DashBoardPage.class);
		PageFactory.initElements(driver, this);
	}

	//Page Action Method
	public void verifyDashboardPageTitle(String expTitle) {
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	public void verifyDashboardURL(String expURL) {
		BaseUtility bu = new BaseUtility();
		bu.waitForUrlContains(driver,15,"submit_tt.do");
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(expURL, actURL);
	}
}
	

