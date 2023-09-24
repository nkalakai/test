package presta_shop_test_selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TestContactUsSelenide {

    @BeforeEach
    public void setUp() {
        Configuration.timeout = 15000;
        open("https://demo.prestashop.com/#/en/front");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $("#loadingMessage").shouldNotBe(visible);
        SelenideElement shopFrame = $("#framelive").shouldBe(visible);
        switchTo().frame(shopFrame);
    }

    @AfterEach
    public void tearDown() {
        closeWindow();
    }

    @Test
    public void contactUsForm() {
        $("#contact-link>a").click();
        $("#id_contact").selectOption("Customer service");
        $("#email").sendKeys("kalakaynazar@gmail.com");
        $("#contactform-message").sendKeys("you can help me");
        $("input.btn.btn-primary").click();
        $("div.col-xs-12.alert.alert-success").shouldHave(Condition.visible.text("Your message has been successfully sent to our team."));
    }
}
