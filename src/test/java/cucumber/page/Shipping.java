package cucumber.page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class Shipping {
    public void goToPayed() {
        $("button[name='confirmDeliveryOption'][value='1']").shouldBe(Condition.visible).click();
    }
}
