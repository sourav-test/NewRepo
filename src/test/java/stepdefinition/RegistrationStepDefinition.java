package stepdefinition;

import framework.controllers.FileReaderController;
import framework.controllers.PageFactoryController;
import framework.picocontainerdependency.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.List;

public class RegistrationStepDefinition {

    public List<HashMap<String, String>> BankData;

    private TestContext testContext;

    //private ScenarioContext scenarioContext;

    private PageFactoryController pageFactory;

    private FileReaderController fileReaderController;

    public RegistrationStepDefinition(TestContext testContext) {
        this.testContext = testContext;
        //this.scenarioContext=scenarioContext;
        pageFactory = testContext.getPageFactoryController();
        fileReaderController = testContext.getFileReaderController();
        BankData = testContext.getFileReaderController().getExcelReader().GetTestData("BankData");
    }

    @Given("Register for Account details")

    public void ClickRegistration()
    {
        System.out.println("Hello");
        testContext.getWebElementUtil().commonClick(pageFactory.getRegistration().Register);
        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getRegistration().FirstName);
    }

    @Then("^Provide all the value for registration \"(.*)\"$")
    public void UserRegister(String testData) {
        try {

            int index = Integer.parseInt(testData) - 1;


            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().FirstName, BankData.get(index).get("Firstname"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().LastName, BankData.get(index).get("Lastname"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().Address, BankData.get(index).get("AddressUser"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().City, BankData.get(index).get("CityName"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().State, BankData.get(index).get("StateName"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().ZipCode, BankData.get(index).get("Zipcode"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().PhoneNo, BankData.get(index).get("Phone"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().Ssn, BankData.get(index).get("SSN"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().UserName, BankData.get(index).get("Username"));
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().PasswordField, fileReaderController.getPropertiesReader().getPassword());
            testContext.getWebElementUtil().commonSendTestData(pageFactory.getRegistration().ConfirmPassword,fileReaderController.getPropertiesReader().getPassword());

        }
        catch (Exception e)
        {
            System.out.println("No Error");
        }

    }

    @And("Click on Register")
    public void SubmitRegistration()
    {
        testContext.getWebElementUtil().commonClick(pageFactory.getRegistration().RegisterBtn);
        testContext.getWebElementUtil().commonWaitForElement(pageFactory.getRegistration().LogoutBtn);
        testContext.getWebElementUtil().commonClick(pageFactory.getRegistration().LogoutBtn);
    }
}
