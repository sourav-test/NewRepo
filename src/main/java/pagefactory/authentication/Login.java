package pagefactory.authentication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

    @FindBy(xpath = "//input[@name = 'username']")
    public WebElement Username;

    @FindBy(xpath = "//input[@name = 'password']")
    public WebElement Password;

    @FindBy (xpath ="//input[@type= 'submit']")
    public  WebElement Submit;

}
