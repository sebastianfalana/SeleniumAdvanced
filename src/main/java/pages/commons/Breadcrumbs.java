package pages.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class Breadcrumbs extends BasePage {
    public Breadcrumbs(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="li[itemprop='itemListElement']:nth-child(2)")
    private WebElement breadcrumbsClothes;

    @FindBy(css="li[itemprop='itemListElement']")
    private List<WebElement> breadcrumbs;

    public String getBreadcrumbs(int numberBreadcrumbs){
        return breadcrumbs.get(numberBreadcrumbs).getText();
        }
    }
