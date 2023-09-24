package prestashop_test_findby;

import data.PrestaUser;
import data.PrestaUserAddress;
import framework.BaseTest;
import framework.DriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import page.findby.*;

public class TestOrderFindBy {
    WebDriver driver;
    TestOrderFindBy testOrderFindBy;
    NavBarFindBy navBarFindBy;
    RegistrationFindBy registrationFindBy;
    AddToCartModalFindBy addToCartModalFindBy;
    CartViewFindBy cartViewFindBy;
    MakeOrderFindBy makeOrderFindBy;
    TestContactUsFindBy testContactUsFindBy;
    ContactUsFormFindBy contactUsFormFindBy;
    AddressFormFindBy addressFormFindBy;
    ShippingFindBy shipping;
    PaymentFindBy payment;
    OrderFinishView orderFinishView;
    ProductViewFindBy productViewFindBy;

    @BeforeEach
    public void setUP() {
        driver = BaseTest.prepareDriverForTest();
        navBarFindBy = new NavBarFindBy();
        registrationFindBy = new RegistrationFindBy();
        testOrderFindBy = new TestOrderFindBy();
        addToCartModalFindBy = new AddToCartModalFindBy();
        cartViewFindBy = new CartViewFindBy();
        makeOrderFindBy = new MakeOrderFindBy();
        testContactUsFindBy = new TestContactUsFindBy();
        contactUsFormFindBy = new ContactUsFormFindBy();
        addressFormFindBy = new AddressFormFindBy();
        shipping = new ShippingFindBy();
        payment = new PaymentFindBy();
        orderFinishView = new OrderFinishView();
        productViewFindBy = new ProductViewFindBy();

    }

    @AfterEach
    public void tearDown() {

        DriverProvider.quitDriver();
    }

    @Test
    public void orderFindBy() {
        registrationFindBy.registrationNewClient(PrestaUser.getAdmin());
        navBarFindBy.goToHomeAccessories();
        productViewFindBy.clickMugTheBest();
        makeOrderFindBy.addCupMugTheBest();
        addToCartModalFindBy.waitAndClose();
        navBarFindBy.goToCart();
        Assertions.assertEquals("Mug The best is yet to come", cartViewFindBy.getFirstLabel());
        makeOrderFindBy.checkout();
        addressFormFindBy.writeInfoAddress(PrestaUserAddress.getAddressUser());
        addressFormFindBy.goToShippingMethod();
        shipping.goToPaymentMethod();
        payment.selectPaymentMethod();
        payment.selectAgree();
        payment.clickPlaceOrder();
        Assertions.assertEquals("Your order is confirmed", orderFinishView.getOrderFirstText());
    }
}