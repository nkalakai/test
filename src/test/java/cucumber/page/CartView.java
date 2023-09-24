package cucumber.page;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartView {
    public void getLabel1(String prodName) {
        $x("//div[contains(@class, 'cart-overview')]")
                .$x(".//a[contains(@class, 'label')]")
                .getText();
    }

    public void checkoutClick() {
        $("div.text-sm-center>a").click();
    }
}
