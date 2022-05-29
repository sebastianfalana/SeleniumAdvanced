package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class TopManuPage extends BasePage {
    public TopManuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".user-info .hidden-sm-down")
    private WebElement signInButton;

    public void goToSignIn(){
        click(signInButton);
    }
}
