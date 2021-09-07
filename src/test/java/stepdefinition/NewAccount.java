package stepdefinition;

import framework.controllers.FileReaderController;
import framework.controllers.PageFactoryController;
import framework.picocontainerdependency.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;

public class NewAccount {

    public List<HashMap<String, String>> BankData;

    private TestContext testContext;
    public String accountidtext;
    public String accountnumber;

    //private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    public NewAccount(TestContext testContext) {
        this.testContext = testContext;
        //this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        BankData = testContext.getFileReaderController().getExcelReader().GetTestData("BankData");
    }

    @Given("Login for Account details")
    public void login_for_Account_details() {
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getLogin().Submit);

        }
        catch(Exception e)
        {

        }

    }

    @Then("Provide all the value for login {string}")
    public void provide_all_the_value_for_login(String testData) {

        try
        {
            int index = Integer.parseInt(testData) - 1;
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getLogin().Username, BankData.get(index).get("Username"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getLogin().Password,fileReaderController.getPropertiesReader().getPassword());
        }

        catch(Exception e)
        {

        }

    }

    @And("Click on Login button")
    public void click_on_Login_button() {
        testContext.getWebElementUtil().commonClick(pageFactory.getLogin().Submit);

    }

    @Then("^User creates account \"(.*)\"$")
    public void create_account(String testData)
    {
        try
        {

            int index = Integer.parseInt(testData) - 1;
            testContext.getWebElementUtil().commonClick(pageFactory.getAccountcreation().NewAccount);
            System.out.println("NewAccount");
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountcreation().AccountOptions);
            testContext.getWebElementUtil().commonSelectDropdown(BankData.get(index).get("Acoptions"), pageFactory.getAccountcreation().AccountOptions);
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountcreation().OpenAccountBtn);
            testContext.getWebElementUtil().commonClick(pageFactory.getAccountcreation().OpenAccountBtn);

        }
        catch (Exception e)
        {
            System.out.println("Account not created successfully");
        }
    }

    @And("User verify account details")
    public void Account_verify()
    {
        System.out.println("Enter");
        try
        {
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountcreation().NewAccount);
            System.out.println("Check account");
            testContext.getWebElementUtil().pause();
            String text = pageFactory.getAccountcreation().AccountCreated.getText();
            if(text.contains("account number"))
            {
                System.out.println("account number");
                accountnumber = pageFactory.getAccountcreation().Accountid.getText();
                System.out.println("acccountverification");
                testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountcreation().Accountid);
                testContext.getWebElementUtil().commonClick(pageFactory.getAccountcreation().Accountid);

            }
        }

        catch(Exception e)
        {
            System.out.println("Account not verified");
        }
    }

    @And("User verify account id")
    public void Account_id_verify()
    {
        try
        {
            System.out.println("Balanceverify");
            testContext.getWebElementUtil().commonWaitForElement(pageFactory.getAccountcreation().NewAccount);
            accountidtext = pageFactory.getAccountcreation().VerifyAccountId.getText();
            if(accountidtext.contains(accountnumber))
            {
                String balance = pageFactory.getAccountcreation().Accountbal.getText();
                if (balance.contains("$100"))
                {
                    System.out.println("Balance recovered");
                    testContext.getWebElementUtil().commonClick(pageFactory.getAccountcreation().TransferAmount);
                    Assert.assertEquals(balance,"$100");
                    System.out.println("Transaction Details");
                }
                else
                {
                    System.out.println("FAil");
                }
            }

        }

        catch(Exception e)
        {

        }
    }

}
