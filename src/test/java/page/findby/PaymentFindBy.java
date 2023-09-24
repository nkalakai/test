package page.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class PaymentFindBy {
    @FindBy(css = "input#payment-option-2")
    WebElement paymentMethod;
    @FindBy(css = "input[name='conditions_to_approve[terms-and-conditions]']")
    WebElement agreeCheck;
    @FindBy(css = "button.btn.btn-primary.center-block")
    WebElement placeOrder;

    public PaymentFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void selectPaymentMethod() {
        paymentMethod.click();
    }

    public void selectAgree() {
        agreeCheck.click();
    }

    public void clickPlaceOrder() {
        placeOrder.click();
    }
}
