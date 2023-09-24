package cucumber.page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class Payment {
    public void selectPaymentMethod() {
        $("input#payment-option-2").click();
    }

    public void agreeCheck() {
        $("input[name='conditions_to_approve[terms-and-conditions]']").click();
    }

    public void clickingPlaceOrder() {
        $("button.btn.btn-primary.center-block").shouldBe(Condition.visible).click();
    }
}
