package page.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class ContactUsFormFindBy {
    @FindBy(css = "#email")
    private WebElement contactUsEmail;
    @FindBy(css = "#id_contact")
    private WebElement subject;
    @FindBy(css = "#contactform-message")
    private WebElement message;
    @FindBy(css = "input[name='submitMessage']")
    private WebElement send;

    public ContactUsFormFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }


    public void subject() {
        subject.click();
    }

    public void sendEmail(String email) {
        contactUsEmail.sendKeys(email);
    }

    public void sendMessage(String text) {
        message.sendKeys(text);
    }

    public void clickSend() {
        send.click();
    }

}
