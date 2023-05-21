package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import models.Contact;
import org.openqa.selenium.support.FindBy;

public class AddNewContactScreen extends BaseScreen{

    public AddNewContactScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }
    @FindBy(id="com.sheygam.contactapp:id/inputName")
    AndroidElement nameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    AndroidElement lastNameEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    AndroidElement emailEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    AndroidElement phoneEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    AndroidElement addressEditText;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    AndroidElement descriptionEditText;
    @FindBy(xpath = "//*[@text='CREATE']")
    AndroidElement createButton;

    public AddNewContactScreen FillContactForm(Contact contact){
        should(nameEditText,5);
        type(nameEditText, contact.getName());
        type(nameEditText, contact.getLastName());
        type(nameEditText, contact.getEmail());
        type(nameEditText, contact.getPhone());
        type(nameEditText, contact.getAddress());
        type(nameEditText, contact.getDiscription());

                return this;
    }
     public ContactListScreen submitContactForm(){
        createButton.click();
        return new ContactListScreen(driver);
     }
     public ContactListScreen createContact(Contact contact){
         should(nameEditText,5);
         type(nameEditText, contact.getName());
         type(nameEditText, contact.getLastName());
         type(nameEditText, contact.getEmail());
         type(nameEditText, contact.getPhone());
         type(nameEditText, contact.getAddress());
         type(nameEditText, contact.getDiscription());
         createButton.click();
         return new ContactListScreen(driver);
     }

    public AddNewContactScreen submitContactFormNegative(){
        createButton.click();
        return this;
    }
    public AddNewContactScreen isErrorContainsText(String text){
        checkAlertText(text);
        return this;
    }
}

