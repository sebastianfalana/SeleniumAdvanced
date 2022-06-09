package pages.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;
import java.util.Objects;

public class ProductsListingPage extends BasePage {
    public ProductsListingPage(WebDriver driver){ super(driver);}

    @FindBy(css="[class='h3 product-title']")
    private List<WebElement> listOfProducts;

    @FindBy(css=".ui-autocomplete-input")
    private WebElement searchInput;

    @FindBy(css="[type='submit']")
    private WebElement searchIcon;

    @FindBy(css="[class='h3 product-title']")
    private  WebElement searchResultNameProduct;

    public WebElement getRandomProductFromTheList(){
        return getRandomElement(listOfProducts);
    }

    public void clickProductFromTheList(String nameOfProduct){
        for (WebElement product :
                listOfProducts) {
            System.out.println(product.getText());
            if (product.getText().equals(nameOfProduct)){
                click(product);
                break;
            }
        }
    }

    public String getRandomProductDescription(){
        return getRandomProductFromTheList().getText();
    }

    public ProductsListingPage setSearchProduct(String productName){
        sendKeys(searchInput,productName);
        return this;
    }
    public ProductsListingPage clickOnSearchIcon(){
        click(searchIcon);
        return this;
    }

    public String getSearchResultNameOfProduct(){
        return searchResultNameProduct.getText();
    }

}
