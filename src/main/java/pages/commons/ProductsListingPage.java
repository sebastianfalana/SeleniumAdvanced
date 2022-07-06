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
    @FindBy(css=".total-products")
    private WebElement totalProducts;
    @FindBy(css=".h1")
    private WebElement categoryName;


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
    public int getNumberOfProductsOnListing(){
        return listOfProducts.size();
    }

    public int  getQuantityOfProductsFromCategoryHeader(){
        String totalProductsText = totalProducts.getText()
                .replace("There is ","")
                .replace(" product.","")
                .replace("There are ","")
                .replace(" products.","");

        return Integer.parseInt(totalProductsText);
    }
    public String getCategoryName(){
        return categoryName.getText();
    }

}
