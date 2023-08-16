package org.login;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\HP\\eclipse-workspace\\CucumberClass\\src\\test\\resources\\features.feature",
				 glue = "org.logoff",
				 dryRun = true)

public class TestRunnerClass {

}
