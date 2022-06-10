package pages.shopping;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.base.BasePage;

import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    Faker faker = new Faker();
    @FindBy(css="[name='address1']")
    private WebElement addressInput;
    @FindBy(css="[name='city']")
    private WebElement cityInput;
    @FindBy(css="[name='id_state']")
    private WebElement selectIdState;
    @FindBy(css="[name='postcode']")
    private WebElement zipCode;
    @FindBy(css="[name='id_country']")
    private WebElement selectIdCountry;
    @FindBy(css="[name='confirm-addresses']")
    private WebElement continueAddressButton;
    @FindBy(css="[name='confirmDeliveryOption']")
    private WebElement continueDeliveryOptionButton;
    @FindBy(css="#checkout-delivery-step [type='radio']")
    private List<WebElement> deliveryOptionMethod;
    @FindBy(css=".payment-options [type='radio']")
    private List<WebElement> paymentOptionMethod;
    @FindBy(css="[type='checkbox']")
    private WebElement termsOfServiceCheckbox;


    public CheckoutPage setAddress(String addressFromUser){
        sendKeys(addressInput,addressFromUser);
        return this;
    }
    public CheckoutPage setCity(String cityFromUser){
        sendKeys(cityInput,cityFromUser);
        return this;
    }
    public void selectIdState(String stateFromUser) {
        Select idState = new Select(selectIdState);
        // continents.selectByIndex(2);
        idState.selectByValue(stateFromUser);
        // continents.selectByVisibleText("Europe");
    }
    public CheckoutPage selectRandomIdState() {
        Select seleniumCommands = new Select(selectIdState);
        List<WebElement> allIdState = seleniumCommands.getOptions();
        getRandomElement(allIdState).click();
        return this;
    }
    public CheckoutPage selectRandomIdCountry() {
        Select seleniumCommands = new Select(selectIdCountry);
        List<WebElement> allIdCountry = seleniumCommands.getOptions();
        getRandomElement(allIdCountry).click();
        return this;
    }
    public CheckoutPage selectFromUserIdCountry(String countryFromUser) {
        Select idState = new Select(selectIdCountry);
        // continents.selectByIndex(2);
        //idState.selectByValue(countryFromUser);
        idState.selectByVisibleText(countryFromUser);
        return this;
    }
    public CheckoutPage setZipCode(int zipCodeFromUSer){
            sendKeys(zipCode, String.valueOf(zipCodeFromUSer));
            return this;
    }
    public CheckoutPage selectContinueButton(){
        click(continueAddressButton);
        return this;
    }
    public CheckoutPage selectContinueDeliveryOptionButton(){
        click(continueDeliveryOptionButton);
        return this;
    }
    public CheckoutPage selectRandomDeliveryOption() {
        getRandomElement(deliveryOptionMethod).click();
        return this;
    }
    public CheckoutPage selectRandomPaymentOption() {
        getRandomElement(paymentOptionMethod).click();
        return this;
    }
    public CheckoutPage selectTermsOfServiceCheckbox(){
        click(termsOfServiceCheckbox);
        return this;
    }
}
