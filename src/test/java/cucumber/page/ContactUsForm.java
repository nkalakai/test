package cucumber.page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ContactUsForm {
    public void writeEmail() {
        $("#email").sendKeys("kalakaynazar@gmail.com");
    }

    public void writeMessage() {
        $("#contactform-message").sendKeys("you can help me");
    }

    public void clickSend() {
        $("input.btn.btn-primary").click();
    }

    public void viewText() {
        $("div.col-xs-12.alert.alert-success").shouldHave(Condition.visible.text("Your message has been successfully sent to our team."));
    }


}
