package cucumber.page;

import com.codeborne.selenide.Condition;
import data.PrestaUserAddress;

import static com.codeborne.selenide.Selenide.$;

public class AddressInfo {
    public void writeInfoAddress(PrestaUserAddress prestaUserAddress) {
        $("#field-address1").sendKeys(prestaUserAddress.getAddress());
        $("#field-postcode").sendKeys(prestaUserAddress.getPostcode());
        $("#field-city").sendKeys(prestaUserAddress.getCity());
    }

    public void goToShipping() {
        $("button[name='confirm-addresses'][value='1']").click();
    }
}
