package page.findby;

import framework.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductListFindBy {
    public static void openProductByName(WebDriver driver, String productName) {
        List<WebElement> productList = driver.findElements(By.cssSelector(".product-miniature"));
        List<WebElement> productListNames = new ArrayList<>();
        for (WebElement product : productList) {
            String tekst = product.findElement(By.cssSelector("h3>a")).getText();
            if (tekst.equals(productName)) {
                product.click();
            }
        }
    }

    public static void openProductByNameLoop(String productName) {

        List<WebElement> productList = DriverProvider.getDriver().findElements(By.cssSelector(".product-miniature"));

        productList.stream().filter(
                box -> box.findElement(
                        By.cssSelector(".product-miniature h2>a")
                ).getText().contains(productName)
        ).findFirst().get().click();

    }
}
