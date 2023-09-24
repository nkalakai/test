package cucumber.page;

import data.PrestaUser;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationForm {
    public void registrationNewClient(PrestaUser prestaUser) {
        $(".user-info").click();
        $(".no-account>a").click();
        $("#field-id_gender-1").click();
        $("#field-firstname").sendKeys(prestaUser.getName());
        $("#field-lastname").sendKeys(prestaUser.getLastName());
        $("#field-email").sendKeys(prestaUser.getEmail());
        $("#field-password").sendKeys(prestaUser.getPass());
        $("#field-birthday").sendKeys(prestaUser.getBirthdayDate());
        $("input[name='psgdpr']").click();
        $("input[name='customer_privacy']").click();
        $("button[type='submit']").click();
    }
}
