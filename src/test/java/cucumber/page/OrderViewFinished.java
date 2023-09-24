package cucumber.page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OrderViewFinished {
    public void viewTextFinish() {
        $("#content-hook_order_confirmation").shouldBe(Condition.visible);
        $x("//h3[contains(@class, 'h1 card-title' )]").shouldHave(Condition.text("Your order is confirmed"));
    }
}
