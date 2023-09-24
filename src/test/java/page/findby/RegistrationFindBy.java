package page.findby;

import data.PrestaUser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class RegistrationFindBy {
    @FindBy(css = ".user-info")
    private WebElement signIn;
    @FindBy(css = ".no-account>a")
    private WebElement createAccount;
    @FindBy(css = "#field-id_gender-1")
    private WebElement gender;
    @FindBy(css = "#field-firstname")
    private WebElement writeName;
    @FindBy(css = "#field-lastname")
    private WebElement writeLastName;
    @FindBy(css = "#field-email")
    private WebElement writeEmail;
    @FindBy(css = "#field-password")
    private WebElement writePassword;
    @FindBy(css = "#field-birthday")
    private WebElement writeBirthdayDate;
    @FindBy(css = "input[name='psgdpr']")
    private WebElement agreeCheckPrivacy;
    @FindBy(css = "input[name='customer_privacy']")
    private WebElement customerCheckPrivacy;
    @FindBy(css = "button[type='submit']")
    private WebElement saveNewAccount;

    public RegistrationFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void registrationNewClient(PrestaUser prestaUser) {
        signIn.click();
        createAccount.click();
        gender.click();
        writeName.sendKeys(prestaUser.getName());
        writeLastName.sendKeys(prestaUser.getLastName());
        writeEmail.sendKeys(prestaUser.getEmail());
        writePassword.sendKeys(prestaUser.getPass());
        writeBirthdayDate.sendKeys(prestaUser.getBirthdayDate());
        agreeCheckPrivacy.click();
        customerCheckPrivacy.click();
        saveNewAccount.click();
    }

}
