package product;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.ProductsListingPage;
import pages.commons.TopManuPage;

public class SearchProductTest extends TestBase {


    @Test
    public void shouldSearchProduct(){
        String randomProductName = new ProductsListingPage(driver).getRandomProductDescription();

        new TopManuPage(driver).setSearchProduct(randomProductName)
                .clickOnSearchIcon();

        Assertions.assertThat(new TopManuPage(driver).getSearchResultNameOfProduct()).isEqualTo(randomProductName);
    }
}
