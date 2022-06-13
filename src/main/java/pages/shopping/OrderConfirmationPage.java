package pages.shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderConfirmationPage extends BasePage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[class='h1 card-title']")
    private WebElement confirmationOrderText;

    public String getConfirmationOrderText(){
        return confirmationOrderText.getText();
    }
}
