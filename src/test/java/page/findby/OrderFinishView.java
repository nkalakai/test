package page.findby;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static framework.DriverProvider.getDriver;

public class OrderFinishView {
    @FindBy(css = ".h1.card-title")
    WebElement orderText;

    public OrderFinishView() {
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), 20), this);
    }

    public String getOrderFirstText() {
        return orderText.getText();
    }

}
