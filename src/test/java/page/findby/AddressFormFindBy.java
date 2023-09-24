package page.findby;

import data.PrestaUserAddress;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class AddressFormFindBy {
    @FindBy(css = "#field-address1")
    WebElement writeAdress;
    @FindBy(css = "#field-postcode")
    WebElement writePostcode;
    @FindBy(css = "#field-city")
    WebElement writeCity;
    @FindBy(css = "button[name='confirm-addresses']")
    WebElement continueToShipping;

    public AddressFormFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }


    public void writeInfoAddress(PrestaUserAddress prestaUserAddress) {
        writeAdress.sendKeys(prestaUserAddress.getAddress());
        writePostcode.sendKeys(prestaUserAddress.getPostcode());
        writeCity.sendKeys(prestaUserAddress.getCity());
    }

    public void goToShippingMethod() {
        continueToShipping.click();
    }
}
