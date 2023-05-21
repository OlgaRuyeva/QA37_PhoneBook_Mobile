package tests;

import config.AppiumConfig;
import models.Aus;
import models.Contact;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class AddNewContactsTests extends AppiumConfig {
   @BeforeClass
    public void preCondition(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Aus.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .submitLogin();
     }
    @Test
    public void createNewContactSuccess(){
        int i = new Random().nextInt(1000)+1000;
        Contact contact= Contact.builder()
                .name("Lora")
                .lastName("Stolz"+i)
                .email("qwe@we.er"+i)
                .phone("12345678910"+i)
                .address("NY")
                .discription("Friend")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .FillContactForm(contact)
                .submitContactForm();

    }
    @Test
    public void createContactWithEmptyName(){
        Contact contact = Contact.builder()
                .lastName("Dow")
                .email("dow@gmail.com")
                .phone("678945633333")
                .address("NY")
                .discription("Empty name")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .FillContactForm(contact)
                .submitContactForm();
              //  .isErrorContainsText("{name=must not be blank}");

    }
    @Test
    public void createNewContactSuccessReq(){


    }
    @AfterClass
    public void PostCondition(){
        new ContactListScreen(driver)
        .logout();

    }
}
