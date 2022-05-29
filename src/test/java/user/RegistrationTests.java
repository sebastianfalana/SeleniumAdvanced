package user;

import base.TestBase;
import org.testng.annotations.Test;
import pages.commons.TopManuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class RegistrationTests extends TestBase {

    @Test
    public void shouldRegisterNewUser(){
        new TopManuPage(driver).goToSignIn();
        new LoginPage(driver).goToCreateAccount();

        new RegistrationPage(driver).goToCreateAccount()
                .setFirstName("Seb")
                .setLastName("Kow")
                .setEmail("asd!@wp.pl")
                .setPassword("asdasd")
                .setBirthday("5/12/1987")
                .selectCustomerPrivacy()
                .selectAcceptPrivatePolicy()
                .selectSaveBtn();
    }
}
