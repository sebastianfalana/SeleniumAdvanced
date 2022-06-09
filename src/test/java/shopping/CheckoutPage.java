package shopping;

import org.openqa.selenium.By;
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
    private WebElement continueButton;


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
    public CheckoutPage setZipCode(int zipCodeFromUSer){
            sendKeys(zipCode, String.valueOf(zipCodeFromUSer));
            return this;
    }
    public CheckoutPage selectContinueButton(){
        click(continueButton);
        return this;
    }
}
