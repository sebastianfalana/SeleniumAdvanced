package pages.shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="#quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css=".add [type='submit']")
    private WebElement addToCardButton;

    @FindBy(css="[class='btn btn-primary']")
    private WebElement proceedToCheckoutButton;

    public ProductPage setQuantityInput(String quantityFromUser){
        sendKeysWithClear(quantityInput,quantityFromUser);
        return this;
    }

    public String getQuantityInput(){
        return quantityInput.getAttribute("value");
    }

    public ProductPage selectAddToCard(){
        click(addToCardButton);
        return this;
    }

    public ProductPage selectProceedToCheckout(){
        waitToBeVisible(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
        return this;
    }
}
