package cucumber;

import cucumber.page.ContactUsForm;
import cucumber.page.NavBar;
import framework.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefsContactUs {
    ContactUsForm contactUsForm;
    NavBar navBar;

    @Given("Open prestashop and switch to frame")
    public void openPrestashopAndSwitchToFrame() {
        BaseTest.prepareDriverforTestSelenide();
        contactUsForm = new ContactUsForm();
        navBar = new NavBar();
    }

    @When("click the Contact Us button")
    public void clickTheContactUsButton() {
        navBar.clickContactUsButton();
    }

    @And("Write email address")
    public void writeEmailAddress() {
        contactUsForm.writeEmail();
    }

    @And("Write message")
    public void writeMessage() {
        contactUsForm.writeMessage();
    }

    @And("Click the send button")
    public void clickTheSendButton() {
        contactUsForm.clickSend();
    }

    @Then("Find message sent equals {string} on the page")
    public void findMessageSentEqualsOnThePage() {
        contactUsForm.viewText();
    }
}
