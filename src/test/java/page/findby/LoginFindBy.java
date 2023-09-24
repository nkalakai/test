package page.findby;

import data.PrestaUser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class LoginFindBy {
    @FindBy(id = "field-email")
    private WebElement emailTextBox;
    @FindBy(id = "field-password")
    private WebElement passTextBox;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LoginFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void loginWithCredentials(String email, String pass) {
        emailTextBox.sendKeys(email);
        passTextBox.sendKeys(pass);
        signInButton.click();
    }

    public void loginWithCredentials(PrestaUser prestaUser) {
        emailTextBox.sendKeys(prestaUser.getEmail());
        passTextBox.sendKeys(prestaUser.getPass());
        signInButton.click();
    }
}
