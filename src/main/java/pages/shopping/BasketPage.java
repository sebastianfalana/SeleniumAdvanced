package pages.shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[class='btn btn-primary']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css="[class='product-line-info'] .label")
    private WebElement productLineInfo;

    @FindBy(css="[type='number']")
    private WebElement productQuantityInfo;

    @FindBy(css=".current-price .price")
    private WebElement productCurrentPrice;

    @FindBy(css="#cart-subtotal-products .value")
    private WebElement productSubtotalPrice;

    @FindBy(css=".remove-from-cart")
    private WebElement removeFromCart;

    @FindBy(css=".no-items")
    private WebElement noItemsText;


    public BasketPage selectProceedToCheckout(){
        click(proceedToCheckoutButton);
        return this;
    }
    public String getProductNameFromTheBasket(){
        return productLineInfo.getText();
    }
    public String getProductQuantityFromTheBasket(){
        return productQuantityInfo.getAttribute("value");
    }
    public String getProductCurrentPrice(){
        return productCurrentPrice.getText();
    }
    public String getProductSubtotalPrice(){
        return productSubtotalPrice.getText();
    }
    public BasketPage selectRemoveFromCart(){
        click(removeFromCart);
        return this;
    }
    public String getNoItemText(){
        waitToBeVisible(noItemsText);
        return noItemsText.getText();
    }
}
