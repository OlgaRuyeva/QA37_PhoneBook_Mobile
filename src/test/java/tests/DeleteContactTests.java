package tests;

import config.AppiumConfig;
import models.Aus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.ContactListScreen;

public class DeleteContactTests extends AppiumConfig {
    @BeforeClass
    public void Precondition() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Aus.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin();
    }

    @Test
    public void deleteFirstContact() {
new ContactListScreen(driver)
        .deleteFirstContact()
        .isListSizeLessThenOne();

    }
}
