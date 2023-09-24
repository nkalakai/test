package page.findby;

import data.PrestaUserAddress;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class MakeOrderFindBy {
    @FindBy(css = "div[class='text-sm-center']")
    WebElement proceedToCheckout;
    @FindBy(css = "div[class='add']")
    private WebElement cupAddToCart;

    public MakeOrderFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void checkout() {
        proceedToCheckout.click();
    }

    public void addCupMugTheBest() {
        cupAddToCart.click();
    }
}
