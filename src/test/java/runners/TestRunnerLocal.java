package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@SuppressWarnings("deprecation")
@CucumberOptions(features = {"src/test/resources/Features/AccountCreation"},
        glue = {"stepdefinition"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestRunnerLocal extends AbstractTestNGCucumberTests {
}
