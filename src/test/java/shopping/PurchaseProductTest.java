package shopping;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.ProductsListingPage;
import pages.commons.TopManuPage;
import pages.shopping.BasketPage;
import pages.shopping.CheckoutPage;
import pages.shopping.OrderConfirmationPage;
import pages.shopping.ProductPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;
import pages.user.userAccount.OrderDetail;
import pages.user.userAccount.OrderHistory;
import pages.user.userAccount.YourAccount;

public class PurchaseProductTest extends TestBase {
    @Test
    public void shouldRegisterNewUser() {
        new TopManuPage(driver).goToSignIn();
        new LoginPage(driver).selectToCreateAccount();

        new RegistrationPage(driver).selectRandomSocialTitle()
                .setFirstName("Seb")
                .setLastName("Kow")
                .setEmail("taxamoTest03@yopmail.com")
                .setPassword("asdasd")
                .setBirthday("5/12/1987")
                .selectCustomerPrivacy()
                .selectAcceptPrivatePolicy()
                .selectSaveBtn();

        Assertions.assertThat(new TopManuPage(driver).getUserName()).isEqualTo("Seb Kow");
    }

    @Test
    public void shouldUserLogIn() {

        String emailFromUser = "taxamoTest03@yopmail.com";
        String passwordFromUser = "asdasd";
        new TopManuPage(driver).goToSignIn();
        new LoginPage(driver).setEmailToLogIn(emailFromUser)
                .setPasswordToLogIn(passwordFromUser)
                .selectSignInButton();
    }

    @Test
    public void shouldPurchaseProduct() {
        String productName = "HUMMINGBIRD T-SHIRT";
        String quantityInputByUser = "1";
        String address = "bla bla bla";
        String city = "Warsaw";
        String country = "Poland";
        String zipCode = "00-712";
        String emailFromUser = "taxamoTest07@yopmail.com";
        String passwordFromUser = "asdasd";

        new TopManuPage(driver).goToSignIn();

        new LoginPage(driver).selectToCreateAccount();

        new RegistrationPage(driver).selectRandomSocialTitle()
                .setFirstName("Seb")
                .setLastName("Kow")
                .setEmail(new RegistrationPage(driver).getRandomEmail())
                .setPassword("asdasd")
                .setBirthday("5/12/1987")
                .selectCustomerPrivacy()
                .selectAcceptPrivatePolicy()
                .selectSaveBtn();
        Assertions.assertThat(new TopManuPage(driver).getUserName()).isEqualTo("Seb Kow");

//        new TopManuPage(driver).goToSignIn();
//        new LoginPage(driver).setEmailToLogIn(emailFromUser)
//                .setPasswordToLogIn(passwordFromUser)
//                .selectSignInButton();

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
                .selectTermsOfServiceCheckbox()
                .selectPaymentConfirmation();
        Assertions.assertThat(new OrderConfirmationPage(driver).getConfirmationOrderText().contains("YOUR ORDER IS CONFIRMED"));
        String orderNumber = new CheckoutPage(driver).getOrderNumber();
        System.out.println("Tu drukuje nr wyciety nr zamowienia " + orderNumber);

        new TopManuPage(driver).selectUserName();

        new YourAccount(driver).selectOderHistory();
        Assertions.assertThat(new OrderHistory(driver).getListOfOrdersInHistory()).contains(orderNumber);

        new OrderHistory(driver).openOrderDetail(orderNumber);

        Assertions.assertThat(new OrderDetail(driver).getOrderInfo().contains(orderNumber));

    }
}
