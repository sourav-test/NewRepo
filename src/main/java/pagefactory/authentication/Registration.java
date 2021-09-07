package pagefactory.authentication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration {

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    public WebElement Register;

    @FindBy(id = "customer.firstName")
    public WebElement FirstName;

    @FindBy(id = "customer.lastName")
    public WebElement LastName;

    @FindBy(id = "customer.address.street")
    public WebElement Address;

    @FindBy(id = "customer.address.city")
    public WebElement City;

    @FindBy(id = "customer.address.state")
    public WebElement State;

    @FindBy(id = "customer.address.zipCode")
    public WebElement ZipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElement PhoneNo;

    @FindBy(id = "customer.ssn")
    public WebElement Ssn;

    @FindBy(id = "customer.username")
    public WebElement UserName;

    @FindBy(id = "customer.password")
    public WebElement PasswordField;

    @FindBy(id = "repeatedPassword")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement RegisterBtn;

    @FindBy(xpath = "//a[contains(text(),'Log Out')]")
    public  WebElement LogoutBtn;
}

