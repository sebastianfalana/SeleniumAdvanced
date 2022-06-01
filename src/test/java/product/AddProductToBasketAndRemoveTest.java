package product;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.ProductsListingPage;
import pages.shopping.BasketPage;
import pages.shopping.ProductPage;

public class AddProductToBasketAndRemoveTest extends TestBase {

    @Test
    public void shouldAddAndRemoveProduct(){
        String productName = "HUMMINGBIRD T-SHIRT";
        String quantityInputByUser = "3";
        String productCurrentPriceByUser = "$19.12";
        String productSubtotalPriceByUser = "$57.36";
        String textInEmptyBasket = "There are no more items in your cart";

        new ProductsListingPage(driver).clickProductFromTheList(productName);
        new ProductPage(driver).setQuantityInput(quantityInputByUser)
                        .selectAddToCard()
                .selectProceedToCheckout();

        Assertions.assertThat(new BasketPage(driver).getProductNameFromTheBasket()).isEqualTo(productName);
        Assertions.assertThat(new BasketPage(driver).getProductQuantityFromTheBasket()).isEqualTo(quantityInputByUser);
        Assertions.assertThat(new BasketPage(driver).getProductCurrentPrice()).isEqualTo(productCurrentPriceByUser);
        Assertions.assertThat(new BasketPage(driver).getProductSubtotalPrice()).isEqualTo(productSubtotalPriceByUser);

        new BasketPage(driver).selectRemoveFromCart();
        Assertions.assertThat(new BasketPage(driver).getNoItemText()).isEqualTo(textInEmptyBasket);
    }
}
