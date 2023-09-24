package prestashop_test_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class TestPrestaShop {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeEach
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "/Users/nazarkalakai/Downloads/chromedriver-mac-x64/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--allowed-ips=*");
        options.addArguments("--whitelisted-ips==*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.get("https://demo.prestashop.com/#/en/front");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#loadingMessage")));
        String newUrl = driver.findElement(By.cssSelector("#framelive")).getAttribute("src");
        driver.get(newUrl);
        driver.findElement(By.cssSelector(".user-info")).click();
        driver.findElement(By.cssSelector(".no-account>a")).click();
        driver.findElement(By.cssSelector("#field-id_gender-1")).click();
        driver.findElement(By.cssSelector("#field-firstname")).sendKeys("Nazar");
        driver.findElement(By.cssSelector("#field-lastname")).sendKeys("Kalakai");
        driver.findElement(By.cssSelector("#field-email")).sendKeys("kalakaynazar@gmail.com");
        driver.findElement(By.cssSelector("#field-password")).sendKeys("32714@Nazar");
        driver.findElement(By.cssSelector("#field-birthday")).sendKeys("01/25/1999");
        driver.findElement(By.cssSelector("input[name='psgdpr']")).click();
        driver.findElement(By.cssSelector("input[name='customer_privacy']")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void makeOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-6")));
        WebElement manuAccessories = driver.findElement(By.cssSelector("#category-6"));
        actions.moveToElement(manuAccessories);
        WebElement menuHomeAccessories = driver.findElement(By.cssSelector("#category-8"));
        actions.click(menuHomeAccessories);
        actions.perform();;

        driver.findElement(By.cssSelector("img[alt*='Mug The best']")).click();
        driver.findElement(By.cssSelector("div[class='add']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#blockcart-modal div.modal-content")));
        WebElement addToCartModal = driver.findElement(By.cssSelector("#blockcart-modal div.modal-content"));
        addToCartModal.findElement(By.cssSelector(".close")).click();

        driver.findElement(By.cssSelector(".cart-preview")).click();
        WebElement cartOverview = driver.findElement(By.cssSelector(".cart-overview"));
        WebElement label = cartOverview.findElement(By.cssSelector(".label"));
        Assertions.assertEquals("Mug The best is yet to come", label.getText());

        driver.findElement(By.cssSelector("div[class='text-sm-center']")).click();
        driver.findElement(By.cssSelector("#field-address1")).sendKeys("La Chapelle");
        driver.findElement(By.cssSelector("#field-postcode")).sendKeys("40724");
        driver.findElement(By.cssSelector("#field-city")).sendKeys("Paris");

        driver.findElement(By.cssSelector("button[name='confirm-addresses']")).click();
        driver.findElement(By.cssSelector("button[name='confirmDeliveryOption']")).click();

        driver.findElement(By.cssSelector("input#payment-option-2")).click();
        driver.findElement(By.cssSelector("input[name='conditions_to_approve[terms-and-conditions]']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary.center-block")));
        driver.findElement(By.cssSelector("button.btn.btn-primary.center-block")).click();
        WebElement order = driver.findElement(By.xpath("//div[contains(@class, 'card-block')]"));
        WebElement confirmed = order.findElement(By.xpath("//h3[contains(@class, 'h1 card-title') and normalize-space()= 'Your order is confirmed']"));
        Assertions.assertEquals("Your order is confirmed", confirmed.getText());
    }

    @Test
    public void searchProductMug() {

        WebElement search = driver.findElement(By.cssSelector(".ui-autocomplete-input"));
        search.sendKeys("Mug");
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-miniature")));
        List<WebElement> products = driver.findElements(By.cssSelector(".product-miniature"));

        if (!products.isEmpty()) {
            System.out.println("Products displayed in search results:");
            for (WebElement product : products) {
                WebElement productNameElement = product.findElement(By.cssSelector(".product-title"));
                System.out.println(productNameElement.getText());
            }
        }
    }

    @Test
    public  void sortProducts (){

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-9")));
        driver.findElement(By.cssSelector("#category-9")).click();
        driver.findElement(By.cssSelector(".btn-unstyle.select-title")).click();
        driver.findElement(By.cssSelector("div.dropdown-menu"));
        driver.findElement(By.xpath("//a[contains(@class, 'select-list js-search-link') and normalize-space()='Price, high to low']")).click();

    }

    @Test  public void validationAdress (){

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-6")));
        WebElement manuAccessories = driver.findElement(By.cssSelector("#category-6"));
        actions.moveToElement(manuAccessories);
        WebElement menuHomeAccessories = driver.findElement(By.cssSelector("#category-8"));
        actions.click(menuHomeAccessories);
        actions.perform();

        driver.findElement(By.cssSelector("img[alt*='Mug The best']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".add-to-cart")));
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#blockcart-modal div.modal-content")));
        WebElement addToCartModal = driver.findElement(By.cssSelector("#blockcart-modal div.modal-content"));
        addToCartModal.findElement(By.cssSelector(".close")).click();
        driver.findElement(By.cssSelector(".cart-preview")).click();
        driver.findElement(By.cssSelector("div.text-sm-center>a")).click();
        driver.findElement(By.cssSelector("#checkout-addresses-step")).click();

        WebElement name = driver.findElement(By.cssSelector("input#field-firstname"));
        Assertions.assertEquals ("field-firstname" , name.getAttribute("id"));
        WebElement lastName = driver.findElement(By.cssSelector("input#field-lastname"));
        Assertions.assertEquals("field-lastname", lastName.getAttribute("id"));
        WebElement adress = driver.findElement(By.cssSelector("input#field-address1"));
        Assertions.assertEquals("field-address1", adress.getAttribute("id"));
        WebElement postCode = driver.findElement(By.cssSelector("input#field-postcode"));
        Assertions.assertEquals("field-postcode", postCode.getAttribute("id"));
        WebElement city = driver.findElement(By.cssSelector("input#field-city"));
        Assertions.assertEquals("field-city", city.getAttribute("id"));
    }

    @Test public void validationInfoClient () {

        driver.findElement(By.cssSelector("span.hidden-sm-down")).click();
        driver.findElement(By.cssSelector("#identity-link")).click();
        WebElement nameInfo = driver.findElement(By.cssSelector("input#field-firstname"));
        Assertions.assertEquals("field-firstname", nameInfo.getAttribute("id"));
        WebElement lastNameInfo = driver.findElement(By.cssSelector("input#field-lastname"));
        Assertions.assertEquals("field-lastname", lastNameInfo.getAttribute("id"));
        WebElement email = driver.findElement(By.cssSelector("input#field-email"));
        Assertions.assertEquals("field-email", email.getAttribute("id"));
        driver.findElement(By.cssSelector("span.input-group-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#field-password")));
        WebElement password = driver.findElement(By.cssSelector("input#field-password"));
        Assertions.assertEquals("field-password", password.getAttribute("id"));
        WebElement birthdate = driver.findElement(By.cssSelector("input#field-birthday"));
        Assertions.assertEquals("field-birthday", birthdate.getAttribute("id"));
    }

    @Test
    public void wishList () {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#category-6")));
        WebElement manuAccessories = driver.findElement(By.cssSelector("#category-6"));
        actions.moveToElement(manuAccessories);
        WebElement menuHomeAccessories = driver.findElement(By.cssSelector("#category-8"));
        actions.click(menuHomeAccessories);
        actions.perform();

        driver.findElement(By.cssSelector("img[alt*='Mug The best']")).click();
        driver.findElement(By.cssSelector(".wishlist-button-add.wishlist-button-product")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.wishlist-list")));
        driver.findElement(By.cssSelector("ul.wishlist-list")).click();
        driver.findElement(By.cssSelector("a.account")).click();
        driver.findElement(By.cssSelector("#wishlist-link")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".wishlist-list-item-link")));
        driver.findElement(By.cssSelector(".wishlist-list-item-link")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.wishlist-products-list")));
        WebElement wishListView = driver.findElement(By.cssSelector("li.wishlist-products-item"));
        WebElement cup = wishListView.findElement(By.cssSelector("p.wishlist-product-title"));
        Assertions.assertEquals("Mug The best is yet to come", cup.getText());

    }

    @Test
    public void contactUs (){
        driver.findElement(By.cssSelector("#contact-link>a")).click();
        driver.findElement(By.cssSelector("#id_contact")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("kalakaynazar@gmail.com");
        driver.findElement(By.cssSelector("#contactform-message")).sendKeys("you can help me");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }
}
