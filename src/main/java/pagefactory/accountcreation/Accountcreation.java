package pagefactory.accountcreation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountcreation {

    @FindBy(xpath = "//a[contains(text(),'Open New Account')]")
    public WebElement NewAccount;

    @FindBy(xpath = "//select[@id='type']")
    public WebElement AccountOptions;

    @FindBy(xpath = "//input[contains(@value,'Open New Account')]")
    public WebElement OpenAccountBtn;

    @FindBy(xpath = "(//h1[contains(text(),'Account')]//following::b)")
    public WebElement AccountCreated;

    @FindBy(xpath = "//a[contains(@id,'newAccountId')]")
    public WebElement Accountid;

    @FindBy(xpath = "(//td[contains(@id,'accountId')])[1]")
    public WebElement VerifyAccountId;

    @FindBy(xpath = "//td[@id='availableBalance']")
    public WebElement Accountbal;

    @FindBy(xpath = "(//a[contains(text(),'Transfer Received')])")
    public WebElement TransferAmount;

    @FindBy(xpath="(//h1[contains(text(),'Transaction')]//following::td)[10]")
    public WebElement Amount;


}
