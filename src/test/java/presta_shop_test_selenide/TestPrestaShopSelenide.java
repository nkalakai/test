package presta_shop_test_selenide;


import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestPrestaShopSelenide {
    @BeforeEach
    public void setUp() {
        Configuration.timeout = 15000;
        open("https://demo.prestashop.com/#/en/front");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $("#loadingMessage").shouldNotBe(visible);
        String newUrl = $("#framelive").getAttribute("src");
        Selenide.open(newUrl);
    }

    @AfterEach
    public void tearDown() {

        closeWindow();
    }

    @Test
    public void testOrder() {
        $(".user-info").click();
        $(".no-account>a").click();
        $("#field-id_gender-1").click();
        $("#field-firstname").sendKeys("Nazar");
        $("#field-lastname").sendKeys("Kalakai");
        $("#field-email").sendKeys("kalakaynazar@gmail.com");
        $("#field-password").sendKeys("32714@Nazar");
        $("#field-birthday").sendKeys("01/25/1999");
        $("input[name='psgdpr']").click();
        $("input[name='customer_privacy']").click();
        $("button[type='submit']").click();

        $("#category-6").shouldBe(Condition.visible).click();
        SelenideElement menuAccessories = $("#category-6");
        SelenideElement menuHomeAccessories = $("#category-8");
        actions().moveToElement(menuAccessories).click(menuHomeAccessories).perform();
        $("img[alt*='Mug The best']").click();
        $("div[class='add']").click();
        $("#blockcart-modal div.modal-content")
                .shouldBe(enabled).$(".close")
                .click();
        $(".cart-preview").click();
        $(".cart-overview")
                .$("a.label").shouldHave(partialTextCaseSensitive("Mug The best is yet to come"))
                .getText();

        $("div.text-sm-center>a").click();
        $("#field-address1").sendKeys("La Chapelle");
        $("#field-postcode").sendKeys("40724");
        $("#field-city").sendKeys("Paris");
        $("button[name='confirm-addresses']").click();
        $("button[name='confirmDeliveryOption']").click();
        $("input#payment-option-2").click();
        $("input[name='conditions_to_approve[terms-and-conditions]']").click();
        $("button.btn.btn-primary.center-block").shouldBe(Condition.visible).click();
        $("h3.h1.card-title:contains('Your order is confirmed')").shouldBe(Condition.visible);
        $("h3.h1.card-title").shouldHave(Condition.text("Your order is confirmed"));
    }
}
