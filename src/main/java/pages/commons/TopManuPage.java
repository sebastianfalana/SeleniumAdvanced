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

    @FindBy(css=".ui-autocomplete-input")
    private WebElement searchInput;

    @FindBy(css="[type='submit']")
    private WebElement searchIcon;

    @FindBy(css="[class='h3 product-title']")
    private  WebElement searchResultNameProduct;

    public void goToSignIn(){
        click(signInButton);
    }
    public String getUserName(){
       return userName.getText();
    }
    public TopManuPage selectClothesButton(){
        click(clothesButton);
        return this;
    }
    public TopManuPage setSearchProduct(String productName){
        sendKeys(searchInput,productName);
        return this;
    }
    public TopManuPage clickOnSearchIcon(){
        click(searchIcon);
        return this;
    }
    public String getSearchResultNameOfProduct(){
        return searchResultNameProduct.getText();
    }
    public TopManuPage selectUserName(){
        click(userName);
        return this;
    }
}
