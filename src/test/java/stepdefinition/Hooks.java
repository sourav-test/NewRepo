package stepdefinition;

import framework.controllers.FileReaderController;
import framework.picocontainerdependency.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.Assert;

public class Hooks {
    private TestContext testContext;

    private FileReaderController fileReaderController;

    //private ScenarioContext scenarioContext;

    /**
     * Pico Container Dependency Inject
     * @param testBase
     */

    public Hooks(TestContext testContext) {

        this.testContext=testContext;
        //this.scenarioContext=scenarioContext;
        fileReaderController = testContext.getFileReaderController();
    }

    @Before(order = 0)
    public void createSession() throws Throwable {

        try
        {
            testContext.getWebDriverController().getDriver().get(fileReaderController.getPropertiesReader().getApplicationURL());

        } catch (Exception e)
        {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @After(order = 0)
    public void endSession(Scenario scenario) {

        try
        {
            testContext.getWebDriverController().quitDriver();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
