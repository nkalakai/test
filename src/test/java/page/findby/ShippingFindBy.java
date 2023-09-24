package page.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class ShippingFindBy {
    @FindBy(css = "button[name='confirmDeliveryOption']")
    WebElement continueToPayment;

    public ShippingFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void goToPaymentMethod() {
        continueToPayment.click();
    }

}
