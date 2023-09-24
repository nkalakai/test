package cucumber.page;

import static com.codeborne.selenide.Selenide.$;

public class ProductView {
    public void clickProductMug() {
        $("img[alt*='Mug The best']").click();
    }
}
