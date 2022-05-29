package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name=id_gender]")
    private List<WebElement> genderRadioBtn;

    @FindBy(css = "[name=firstname]")
    private WebElement firstName;

    @FindBy(css = "[name=lastname]")
    private WebElement lastName;

    @FindBy(css = "[name=email]")
    private WebElement email;

    @FindBy(css = "[name=password]")
    private WebElement password;

    @FindBy(css = "[name=birthday]")
    private WebElement birthday;
    @FindBy(css = "[name=customer_privacy]")
    private WebElement customerPrivac;
    @FindBy(css = "input[name='psgdpr']")
    private WebElement acceptPrivatePolicy;
    @FindBy(css = "[class='form-footer clearfix'] [type=submit]")
    private WebElement saveBtn;


    public RegistrationPage selectRandomSocialTitle(){
        getRandomElement(genderRadioBtn);
        return this;
    }
    public RegistrationPage setFirstName(String firstName){
        sendKeys(this.firstName, firstName);
        return this;
    }
    public RegistrationPage setLastName(String lastName){
        sendKeys(this.lastName, lastName);
        return this;
    }
    public RegistrationPage setEmail(String email){
        sendKeys(this.email, email);
        return this;
    }
    public RegistrationPage setPassword(String password){
        sendKeys(this.password, password);
        return this;
    }
    public RegistrationPage setBirthday(String birthday){
        sendKeys(this.birthday, birthday);
        return this;
    }
    public RegistrationPage selectCustomerPrivacy(){
        customerPrivac.click();
        return this;
    }
    public RegistrationPage selectAcceptPrivatePolicy(){
        acceptPrivatePolicy.click();
        return this;
    }
    public RegistrationPage selectSaveBtn(){
        click(saveBtn);
        return this;
    }
}
