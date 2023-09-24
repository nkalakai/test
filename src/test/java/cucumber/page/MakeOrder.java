package cucumber.page;

import static com.codeborne.selenide.Selenide.$;

public class MakeOrder {
    public void addToCartCup() {
        $("div[class='add']").click();
    }
}
