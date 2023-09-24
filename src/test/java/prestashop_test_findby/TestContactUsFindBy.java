package prestashop_test_findby;

import framework.BaseTest;
import framework.DriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.findby.ContactUsFormFindBy;
import page.findby.NavBarFindBy;

public class TestContactUsFindBy {
    WebDriver driver;
    TestContactUsFindBy testContactUsFindBy;
    NavBarFindBy navBarFindBy;
    ContactUsFormFindBy contactUsFormFindBy;

    @BeforeEach
    public void setUP() {
        driver = BaseTest.prepareDriverForTest();
        navBarFindBy = new NavBarFindBy();
        testContactUsFindBy = new TestContactUsFindBy();
        contactUsFormFindBy = new ContactUsFormFindBy();

    }

    @AfterEach
    public void tearDown() {

        DriverProvider.quitDriver();
    }

    @Test
    public void contactUs() {
        navBarFindBy.contactUs();
        contactUsFormFindBy.subject();
        contactUsFormFindBy.sendEmail("kalakaynazar@gmail.com");
        contactUsFormFindBy.sendMessage("You can help me");
        contactUsFormFindBy.clickSend();
    }

}
