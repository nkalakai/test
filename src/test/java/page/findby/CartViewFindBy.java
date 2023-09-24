package page.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class CartViewFindBy {
    @FindBy(css = "div.cart-overview a.label")
    WebElement label;


    public CartViewFindBy() {

        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public String getFirstLabel() {

        return label.getText();
    }
}
