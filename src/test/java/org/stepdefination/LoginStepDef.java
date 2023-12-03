package org.stepdefination;

import org.openqa.selenium.WebDriver;
import org.page.LoginPage;
import org.testng.Assert;
import org.utilities.BaseUtility;
import org.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	
	private BaseUtility bu = new BaseUtility();
	public static WebDriver driver;
	private ConfigReader cr;
	@Given("User is on login page")
	public void user_is_on_login_page() {
	
	cr = new ConfigReader();
	driver = bu.startUp(cr.getTestData("url"),cr.getTestData("BroweserName"));
	//String url, String BroweserName
	}

	@Then("Username field is displayed")
	public void username_field_is_displayed() {
	LoginPage lp_obj = new LoginPage(driver);
	Assert.assertTrue(lp_obj.isUsernameIsDisplayed());
	}
	
	@Then("Password field is displayed")
	public void password_field_is_displayed() {
		LoginPage lp_obj = new LoginPage(driver);
		Assert.assertTrue(lp_obj.isPasswordFieldDisplayed());
	}

	@Then("Login field is displayed")
	public void login_field_is_displayed() {
		LoginPage lp_obj = new LoginPage(driver);
		Assert.assertTrue(lp_obj.isLoginBtnDisplayed());
	}

	@Then("Keep me login checkbox is displayed")
	public void keep_me_login_checkbox_is_displayed() {
		LoginPage lp_obj = new LoginPage(driver);
		Assert.assertTrue(lp_obj.iskeepMeLogInCheckBoxDisplayed());
	}

	@Then("Actitime logo is displayed")
	public void actitime_logo_is_displayed() {
		LoginPage lp_obj = new LoginPage(driver);
		Assert.assertTrue(lp_obj.isLoginLogoesDisplayed());
	}
	

	@When("User enter Username")
	public void user_enter_username() {
		LoginPage lp_obj = new LoginPage(driver);
		lp_obj.enterUserName(cr.getTestData("userName"));
	}

	@When("User enter Password")
	public void user_enter_password() {
		LoginPage lp_obj = new LoginPage(driver);
		lp_obj.enterPassword(cr.getTestData("password"));
	}

	@When("Click on login button")
	public void click_on_login_button() {
		LoginPage lp_obj = new LoginPage(driver);
		lp_obj.clickOnLoginBtn();
	}
	
	@Then("Login page title is displayed as {string}")
	public void login_page_title_is_displayed_as(String expTitle) {
		LoginPage lp_obj = new LoginPage(driver);
		lp_obj.verifyLoginPageTitle(expTitle);
	}

	@Then("Login page URL is displayed as {string}")
	public void login_page_url_is_displayed_as(String expUrl) {
	    LoginPage lp_obj = new LoginPage(driver);
		lp_obj.verifyLoginpageURL(expUrl);
	}

}
