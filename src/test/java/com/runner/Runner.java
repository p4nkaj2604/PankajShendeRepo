package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/resources/com/feature/Test.feature",
		glue = {"com.stepDef"},
		monochrome = true,
		dryRun = false,
		plugin= {
				"pretty",
				"junit:target/junitReport/junitReport.junit",
				"json:target/jsonReport/jsonReport.json",
				"html:target/htmlReport/htmlReport.html"
				}
		)
public class Runner {

}
