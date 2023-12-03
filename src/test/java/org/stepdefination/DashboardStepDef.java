package org.stepdefination;

import org.page.DashBoardPage;

import io.cucumber.java.en.Then;

public class DashboardStepDef {
	
	@Then("Dashboard URL should be displayed {string}")
	public void dashboard_url_should_be_displayed(String expUrl) {
	    DashBoardPage dp_obj = new DashBoardPage(LoginStepDef.driver);
	    dp_obj.verifyDashboardURL(expUrl);
		
	}

	@Then("Dashboard page title should be displayed {string}")
	public void dashboard_page_title_should_be_displayed(String expTitle) {
		DashBoardPage dp_obj = new DashBoardPage(LoginStepDef.driver);
		dp_obj.verifyDashboardPageTitle(expTitle);
	}

}
