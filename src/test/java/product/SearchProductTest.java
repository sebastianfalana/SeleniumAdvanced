package product;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.ProductsListingPage;

public class SearchProductTest extends TestBase {


    @Test
    public void shouldSearchProduct(){
        String randomProductName = new ProductsListingPage(driver).getRandomProductDescription();
        new ProductsListingPage(driver).setSearchProduct(randomProductName)
                .clickOnSearchIcon();

        Assertions.assertThat(new ProductsListingPage(driver).getSearchResultNameOfProduct()).isEqualTo(randomProductName);
    }
}
