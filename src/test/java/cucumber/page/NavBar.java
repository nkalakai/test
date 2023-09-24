package cucumber.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class NavBar {
    public void clickContactUsButton() {
        $("#contact-link>a").click();
    }

    public void clickManuHomeAccessories() {
        $("#category-6").shouldBe(Condition.visible).click();
        SelenideElement menuAccessories = $("#category-6");
        SelenideElement menuHomeAccessories = $("#category-8");
        actions().moveToElement(menuAccessories).click(menuHomeAccessories).perform();
    }

    public void goToCart() {
        $(".cart-preview").click();
    }
}
