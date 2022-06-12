package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".no-account > a")
    private WebElement createAccountButton;
    @FindBy(css = ".form-control[name='email']")
    private WebElement emailToLogIn;
    @FindBy(css = ".form-control[name='password']")
    private WebElement passwordToLogIn;
    @FindBy(css = "#submit-login")
    private WebElement singInButton;

    public LoginPage selectToCreateAccount() {
        click(createAccountButton);
        return this;
    }
    public LoginPage setEmailToLogIn(String emailFromUser) {
        sendKeys(emailToLogIn, emailFromUser);
        return this;
    }
    public LoginPage setPasswordToLogIn(String passwordFromUser) {
        sendKeys(passwordToLogIn, passwordFromUser);
        return this;
    }
    public LoginPage selectSignInButton() {
        click(singInButton);
        return this;
    }
}
