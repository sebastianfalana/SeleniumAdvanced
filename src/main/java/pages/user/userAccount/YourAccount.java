package pages.user.userAccount;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class YourAccount extends BasePage {
    public YourAccount(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#history-link")
    private WebElement orderHistory;

    public YourAccount selectOderHistory(){
        click(orderHistory);
        return this;
    }
}
