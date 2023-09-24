package cucumber;

import cucumber.page.*;
import data.PrestaUser;
import data.PrestaUserAddress;
import framework.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyStepdefsTestOrder {
    RegistrationForm registrationForm;
    NavBar navBar;
    ProductView productView;
    MakeOrder makeOrder;
    CartModal cartModal;
    CartView cartView;
    AddressInfo addressInfo;
    Shipping shipping;
    Payment payment;
    OrderViewFinished orderViewFinished;

    @Given("Open prestashop and registration new client")
    public void OpenPrestashopAndRegistrationNewClient() {
        BaseTest.prepareDriverforTestSelenide();
        registrationForm = new RegistrationForm();
        registrationForm.registrationNewClient(PrestaUser.getAdmin());
    }

    @Given("Move cursor to menu accessories and click to home accessories")
    public void moveCursorToMenuAccessoriesAndClickToHomeAccessories() {
        navBar = new NavBar();
        navBar.clickManuHomeAccessories();
    }

    @Given("Click and add to product with name mug the best")
    public void clickAndAddToProductWithNameMugTheBest() {
        makeOrder = new MakeOrder();
        productView = new ProductView();
        productView.clickProductMug();
        makeOrder.addToCartCup();
    }

    @And("Wait to block cart modal and  click close")
    public void waitToBlockCartModalAndClickClose() {
        cartModal = new CartModal();
        cartModal.waitAndClose();
    }

    @Given("Click  add to cart button")
    public void clickAddToCartButton() {
        navBar.goToCart();
    }

    @Then("View product label and equals {string} on page")
    public void viewProductLabelAndEqualsOnPage(String prodName) {
        cartView = new CartView();
        cartView.getLabel1(prodName);
    }

    @Given("Click to proceed to checkout button")
    public void clickToProceedToCheckoutButton() {
        cartView.checkoutClick();
    }

    @Given("Complete address info")
    public void completeAddressInfo() {
        addressInfo = new AddressInfo();
        addressInfo.writeInfoAddress(PrestaUserAddress.getAddressUser());

    }

    @And("Click continue")
    public void clickContinue() {
        addressInfo.goToShipping();
    }

    @And("Also click continue")
    public void alsoClickContinue() {
        shipping = new Shipping();
        shipping.goToPayed();

    }

    @Given("Click to payment method button")
    public void clickToPaymentMethodButton() {
        payment = new Payment();
        payment.selectPaymentMethod();
    }

    @And("Select Agree")
    public void selectAgree() {
        payment.agreeCheck();
    }

    @Given("Click place order button")
    public void clickPlaceOrderButton() {
        payment.clickingPlaceOrder();
    }

    @Then("Find and equals info {string}")
    public void findAndEqualsInfo() {
        orderViewFinished = new OrderViewFinished();
        orderViewFinished.viewTextFinish();
    }
}
