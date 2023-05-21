package tests;

import config.AppiumConfig;
import models.Aus;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;

public class LoginSecondTests extends AppiumConfig {
    @Test
    public void LoginSuccess(){
        new AuthentificationScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isAccountOpened()
                .logout();

    }
    @Test
    public void LoginSuccessModel(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Aus.builder().build())
                .submitLogin()
                .isAccountOpened()
                .logout();

    }
}
