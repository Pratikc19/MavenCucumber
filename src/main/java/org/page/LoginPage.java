package org.page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;

public class LoginPage {
  
	WebDriver driver = null;
	//WebElemets
	
	@FindBy(id = "username")
	private WebElement uNameTxtField ;
	
	@FindBy(css = ".textField.pwdfield")
	private WebElement pwdTxtField ;
	
	@FindBy(css = "#loginButton>div")
	private WebElement loginButton ;
	
	@FindBy(id = "keepLoggedInCheckBox")
	private WebElement keepMeLogInCheckBox ;
	
	@FindBy(css = "#logoContainer img")
	private List<WebElement> loginLogosImages ;
	
	@FindBy(id = "logoutLink")
	private WebElement logoutLink;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	//	PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
	}

	//Page Action Method

	public boolean isUsernameIsDisplayed() {
		return uNameTxtField.isDisplayed();
		//Test
	}
	public boolean isPasswordFieldDisplayed() {
		return pwdTxtField.isDisplayed();
	}
	public boolean isLoginBtnDisplayed() {
		return loginButton.isDisplayed();
	}
	public boolean iskeepMeLogInCheckBoxDisplayed() {
		return keepMeLogInCheckBox.isDisplayed();
	}
	public boolean isLoginLogoesDisplayed() {
		if(loginLogosImages.size() == 2) {
			return true;
		}else {
			return false;
		}
	}
	public void enterUserName(String uName) {
		uNameTxtField.sendKeys(uName);
	}
	public void enterPassword(String pwd) {
		pwdTxtField.sendKeys(pwd);
	}
	public void clickOnLoginBtn() {
		loginButton.click();
		BaseUtility bu = new BaseUtility();
		bu.waitForVisibilityOfElementLocated(driver, 15, "id", "logoutLink");
		
	}
//	public void doLogin() {
//		ConfigReader cr = new ConfigReader();
//		uNameTxtField.sendKeys(cr.getTestData("userName"));
//		pwdTxtField.sendKeys(cr.getTestData("password"));
//		loginButton.click();
//	}
	
	public void verifyLoginPageTitle(String expTitle) {
		String actTitle = driver.getTitle();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	public void verifyLoginpageURL(String expURL) {
		String actURL = driver.getCurrentUrl();
		Assert.assertEquals(expURL, actURL);
	
}
}