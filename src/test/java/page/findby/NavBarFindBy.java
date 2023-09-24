package page.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class NavBarFindBy {
    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchBox;
    @FindBy(css = "#_desktop_user_info")
    private WebElement signIn;
    @FindBy(css = "#contact-link")
    private WebElement contactUs;
    @FindBy(css = "#category-6")
    private WebElement manuAccessories;
    @FindBy(css = "#category-8")
    private WebElement menuHomeAccessories;
    @FindBy(css = "#_desktop_cart")
    private WebElement cart;
    @FindBy(css = "#_desktop_logo")
    private WebElement homeButton;

    public NavBarFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void searchForProducts(String text) {
        searchBox.click();
        searchBox.sendKeys(text);
        searchBox.submit();
    }

    //("Go to sign  in")
    public void goToSignIn() {

        signIn.click();
    }

    // ("Go to contact us")
    public void contactUs() {

        contactUs.click();

    }

    //  ("Go to home accessories")
    public void goToHomeAccessories() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(manuAccessories);
        actions.click(menuHomeAccessories);
        actions.perform();
    }

    //("Open cart")
    public void goToCart() {
        cart.click();
    }

    //("Go to Home")
    public void goToHome() {

        homeButton.click();
    }
}
