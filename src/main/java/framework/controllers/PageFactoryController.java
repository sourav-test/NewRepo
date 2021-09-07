package framework.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pagefactory.accountcreation.Accountcreation;
import pagefactory.accountrelated.Accountrelated;
import pagefactory.authentication.Login;
import pagefactory.authentication.Registration;
import pagefactory.commonobjects.Common;

public class PageFactoryController {

    private WebDriver driver;

    public PageFactoryController(WebDriver driver) {

        this.driver=driver;
    }

    public Accountcreation getAccountcreation() {

        return PageFactory.initElements(driver, Accountcreation.class);
    }

    public Accountrelated getAccountrelated() {

        return PageFactory.initElements(driver, Accountrelated.class);
    }

    public Registration getRegistration() {

        return PageFactory.initElements(driver, Registration.class);
    }

    public Common getCommon() {

        return PageFactory.initElements(driver, Common.class);
    }

    public Login getLogin() {

        return PageFactory.initElements(driver, Login.class);
    }



}
