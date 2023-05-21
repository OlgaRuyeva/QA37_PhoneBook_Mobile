package tests;

import config.AppiumConfig;
import models.Aus;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {
    @Test
    public void LoginSuccess(){
        boolean result = new AuthentificationScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }
    @Test
    public void loginSuccessModel(){
        boolean result = new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Aus.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");
        Assert.assertTrue(result);
    }
    public void loginSuccessModel2(){
        Assert.assertTrue(new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Aus.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));
        }
        @Test
        public void loginWrongEmail(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Aus.builder().email("noagmail.com").password("Nnoa12345$").build())
                .submitLoginNegative()
                .isErrorMessageContains("Login or Password incorrect");
        }
@Test
    public void loginWrongPassword(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Aus.builder().email("noa@gmail.com").password("N45$").build())
                .submitLoginNegative()
                .isErrorMessageContains("Login or Password incorrect");
    }
    @AfterMethod
    public void PostCondition(){
        new ContactListScreen(driver).logout();
    }
}
