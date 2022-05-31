package pages.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class ProductsListingPage extends BasePage {
    public ProductsListingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".product-description")
    private List<WebElement> listOfProducts;

    @FindBy(css=".ui-autocomplete-input")
    private WebElement searchInput;

    @FindBy(css="[type='submit']")
    private WebElement searchIcon;

    public WebElement getRandomProductFromTheList(){
        return getRandomElement(listOfProducts);
    }

    public String getRandomProductDescription(){
        return getRandomProductFromTheList().getText();
    }
}
