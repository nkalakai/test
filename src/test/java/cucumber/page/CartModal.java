package cucumber.page;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CartModal {
    public void waitAndClose() {
        $("#blockcart-modal div.modal-content")
                .shouldBe(enabled).$(".close")
                .click();
    }
}
