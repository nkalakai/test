package page.findby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.DriverProvider.getDriver;

public class AddToCartModalFindBy {
    @FindBy(css = "#blockcart-modal div.modal-content .close")
    private WebElement addToCartModal;

    public AddToCartModalFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    // ("Close add to cart modal")
    public void waitAndClose() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#blockcart-modal div.modal-content")));
        addToCartModal.click();
    }
}
