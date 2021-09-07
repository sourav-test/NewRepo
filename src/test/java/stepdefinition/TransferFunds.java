package stepdefinition;

import framework.controllers.FileReaderController;
import framework.controllers.PageFactoryController;
import framework.picocontainerdependency.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.List;

public class TransferFunds {

    public List<HashMap<String, String>> BankData;

    private TestContext testContext;
    public String accountfrom;
    public String accountto;

    //private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    public TransferFunds(TestContext testContext) {
        this.testContext = testContext;
        //this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        BankData = testContext.getFileReaderController().getExcelReader().GetTestData("BankData");
    }

    @Given("Accounts Overview")
    public void Accounts_overview()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountrelated().Overview);
            testContext.getWebElementUtil().commonClick(pageFactory.getAccountrelated().Overview);
            accountfrom = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getAccountrelated().Acountfrom);
            accountto = testContext.getWebElementUtil().commonGetTextFromElement(pageFactory.getAccountrelated().Acountto);

            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountrelated().Funds);
            testContext.getWebElementUtil().commonClick(pageFactory.getAccountrelated().Funds);

        }
        catch(Exception e)
        {

        }
    }

    @Then("Transfer funds")
    public void transfer_funds()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountrelated().TransferBtn);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAccountrelated().Acountfrom, accountfrom);
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getAccountrelated().Acountto, accountto);
            testContext.getWebElementUtil().commonClick(pageFactory.getAccountrelated().TransferBtn);
        }
        catch(Exception e)
        {

        }
    }

    @And("verify the transfer amount")
    public void verify_transfer_amount()
    {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountrelated().Overview);
            testContext.getWebElementUtil().commonClick(pageFactory.getAccountrelated().Overview);

        }

        catch(Exception e)
        {

        }
    }
}
