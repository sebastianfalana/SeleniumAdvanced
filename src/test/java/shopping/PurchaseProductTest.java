package shopping;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.commons.ProductsListingPage;
import pages.commons.TopManuPage;
import pages.shopping.BasketPage;
import pages.shopping.CheckoutPage;
import pages.shopping.ProductPage;
import pages.user.userAccount.OrderHistory;
import pages.user.userAccount.YourAccount;
import user.RegistrationTest;

public class PurchaseProductTest extends TestBase {

    @Test
    public void shouldPurchaseProduct(){
        String productName = "HUMMINGBIRD T-SHIRT";
        String quantityInputByUser = "1";
        String address = "bla bla bla";
        String city = "Warsaw";
        String country = "Poland";
        int zipCode = 00-710;

        new RegistrationTest().shouldRegisterNewUser();
        new TopManuPage(driver).selectClothesButton();
        new ProductsListingPage(driver).clickProductFromTheList(productName);
        new ProductPage(driver).setQuantityInput(quantityInputByUser)
                .selectAddToCard()
                .selectProceedToCheckout();
        new BasketPage(driver).selectProceedToCheckoutOverview();
        new CheckoutPage(driver).setAddress(address)
                .setCity(city)
                .selectRandomIdState()
                .setZipCode(zipCode)
                .selectFromUserIdCountry(country)
                .selectContinueButton()
                .selectRandomDeliveryOption()
                .selectContinueDeliveryOptionButton()
                .selectRandomPaymentOption()
                .selectTermsOfServiceCheckbox();
        String orderNumber = new CheckoutPage(driver).getOrderNumber();
        new TopManuPage(driver).selectUserName();
        new YourAccount(driver).selectOderHistory();
        Assert.assertEquals(orderNumber,new OrderHistory(driver).getOrder(orderNumber));
    }
}
