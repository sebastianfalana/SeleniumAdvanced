package shopping;

import base.TestBase;
import pages.commons.ProductsListingPage;
import pages.commons.TopManuPage;
import user.RegistrationTest;

public class PurchaseProductTest extends TestBase {

    public void shouldPurchaseProduct(){

        new RegistrationTest().shouldRegisterNewUser();
        new TopManuPage(driver).selectClothesButton();
        new ProductsListingPage(driver).clickProductFromTheList("HUMMINGBIRD T-SHIRT");

    }
}
