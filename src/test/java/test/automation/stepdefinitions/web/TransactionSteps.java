package test.automation.stepdefinitions.web;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.web.*;

public class TransactionSteps {
    @Autowired
    InventoryPage inventoryPage;

    @Autowired
    CartPage cartPage;

    @Autowired
    CheckoutPage checkoutPage;

    @Autowired
    CheckoutReviewPage checkoutReviewPage;

    @Autowired
    CheckoutCompletePage checkoutCompletePage;

    @And("user choose {string} name")
    public void userChooseProduct(String product) {
        inventoryPage.selectProduct(product);
    }

    @And("user click cart button")
    public void userClickCartButton() throws InterruptedException {
        inventoryPage.clickShoppingCartButton();
    }

    @And("user on cart page")
    public void userOnCartPage() {
        Assert.assertTrue(cartPage.isOnCartPage());
    }

    @And("user validate {string} name existing on the cart")
    public void userValidateTheCart(String product) {
        Assert.assertTrue(cartPage.validateProductOnCart(product));
    }

    @And("user click checkout button")
    public void userClickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @And("user on checkout page")
    public void userOnCheckoutPage() {
        Assert.assertTrue(checkoutPage.isOnCheckoutPage());
    }

    @And("user input information needed")
    public void userInputInformationNeeded() {
        Faker faker = new Faker();

        checkoutPage.inputFirstName(faker.name().firstName());
        checkoutPage.inputLastName(faker.name().lastName());
        checkoutPage.inputPostalCode(faker.address().zipCode());
    }

    @And("user click continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @And("user on checkout review page")
    public void userOnCheckoutReviewPage() {
        Assert.assertTrue(checkoutReviewPage.isOnCheckoutReviewPage());
    }

    @And("user validate the total prices")
    public void userValidateTheTotalPrices() {
        Assert.assertTrue(checkoutReviewPage.validateTotalPriceIsCorrect());
    }

    @And("user click finish button")
    public void userClickFinishButton() {
        checkoutReviewPage.clickFinisButton();
    }

    @Then("user on checkout complete page")
    public void userOnCheckoutCompletePage() {
        Assert.assertTrue(checkoutCompletePage.isOnCheckoutCompletePage());
    }

    @And("user see the product has been ordered")
    public void userSeeTheProductHasBeenOrdered() {
        Assert.assertTrue(checkoutCompletePage.validateOrderHasBeenOrdered());
    }
}
