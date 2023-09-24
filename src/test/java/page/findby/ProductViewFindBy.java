package page.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class ProductViewFindBy {
    @FindBy(css = "img[alt*='Mug The best']")
    private WebElement mugTheBest;

    public ProductViewFindBy() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public void clickMugTheBest() {
        mugTheBest.click();
    }
}
