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

    @FindBy(css = "span[class=hidden-sm-down]")
    private WebElement userName;

    @FindBy(css = "#category-3 > .dropdown-item")
    private WebElement clothesButton;

    public void goToSignIn(){
        click(signInButton);
    }

    public String getUserName(){
       return userName.getText();
    }
}
