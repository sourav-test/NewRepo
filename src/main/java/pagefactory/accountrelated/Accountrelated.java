package pagefactory.accountrelated;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountrelated {

    @FindBy(xpath = "//a[contains(text(),'Transfer Funds')]")
    public WebElement Funds;

    @FindBy(xpath = "//a[contains(text(),'Accounts Overview')]")
    public WebElement Overview;

    @FindBy(xpath = "(//tr[contains(@class,'ng-scope')]//following::td)[1]]")
    public WebElement Acountfrom;

    @FindBy(xpath = "(//tr[contains(@class,'ng-scope')]//following::td)[4]")
    public WebElement Acountto;

    @FindBy(xpath = "//input[@id = 'amount']")
    public WebElement Amount;

    @FindBy(xpath = "//select[@id = 'fromAccountId']")
    public WebElement Amountfrom;

    @FindBy(xpath = "//select[@id = 'toAccountId']")
    public WebElement Amountto;

    @FindBy(xpath = "//input[@value = 'Transfer']")
    public WebElement TransferBtn;


}
