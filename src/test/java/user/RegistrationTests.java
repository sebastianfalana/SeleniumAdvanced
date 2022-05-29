package user;

import base.TestBase;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.commons.TopManuPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationTests extends TestBase {

    @Test
    public void shouldRegisterNewUser(){
        new TopManuPage(driver).goToSignIn();
        new LoginPage(driver).goToCreateAccount();

        new RegistrationPage(driver).selectRandomSocialTitle()
                .setFirstName("Seb")
                .setLastName("Kow")
                .setEmail("asd!@wp.pl")
                .setPassword("asdasd")
                .setBirthday("5/12/1987")
                .selectCustomerPrivacy()
                .selectAcceptPrivatePolicy()
                .selectSaveBtn();

        Assertions.assertThat(new TopManuPage(driver).getUserName()).isEqualTo("Seb Kow");
    }
}
