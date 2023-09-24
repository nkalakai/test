package framework;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static framework.DriverProvider.getDriver;

public class BaseTest {
    public static WebDriver prepareDriverForTest() {
        WebDriver driver = getDriver();
        loadPageAndSwitchIframe(driver);
        return driver;
    }

    public static void loadPageAndSwitchIframe(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://demo.prestashop.com/#/en/front");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loadingMessage")));
        String newUrl = driver.findElement(By.cssSelector("#framelive")).getAttribute("src");
        driver.get(newUrl);
    }
    public static WebDriver prepareDriverforTestSelenide() {
        Configuration.timeout = 15000;
        open("https://demo.prestashop.com/#/en/front");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        $("#loadingMessage").shouldNotBe(visible);
        String newUrl = $("#framelive").getAttribute("src");
        Selenide.open(newUrl);
        return WebDriverRunner.getWebDriver();
    }
}
