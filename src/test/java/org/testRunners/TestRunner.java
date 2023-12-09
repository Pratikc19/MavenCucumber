package org.testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/org/feature",
		// features = "src/test/resource/org/feature/loginPage.feature"      for single feature file
		glue = {"org/stepdefination"},
		monochrome = true,          // To generate clear reports 
		dryRun = true,              // To check the connection bet feature file and StepDef
		plugin={"pretty",
				"html:target/html_report/cucumber_report.html",
				"junit:target/junit_report/junit_report.xml",
				"json:target/json_report/json_report.json",
				} 
		) 

public class TestRunner {

	
}
