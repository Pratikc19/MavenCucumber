package org.testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resource/org/feature",
		// features = "src/test/resource/org/feature/loginPage.feature"      for single feature file
		glue = {"org/stepdefination"},
		monochrome = true,
		plugin={"junit:reports/junit/reports.xml",
				"pretty:target/cucumber-pretty.text",
				"html:target/cucumber-html-report",
				"json:target/cucumber.json",
				"usage:target/cucumber-usage.json",}
		
		
		) 
public class TestRunner {

	
}
