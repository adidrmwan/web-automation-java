package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.automation.pages.web.CheckoutPage")
public class CheckoutPage extends BasePageObject {
    private By title() {
        return By.xpath("//span[contains(text(), 'Checkout')]");
    }

    private By firstNameField() {
        return By.id("first-name");
    }

    private By lastNameField() {
        return By.id("last-name");
    }

    private By postalCodeField() {
        return By.id("postal-code");
    }

    private By continueButton() {
        return By.id("continue");
    }

    private By cancelButton() {
        return By.id("cancel");
    }

    public boolean isOnCheckoutPage() {
        return waitUntilPresence(title()).isDisplayed();
    }

    public void inputFirstName(String value) {
        onType(firstNameField(), value);
    }

    public void inputLastName(String value) {
        onType(lastNameField(), value);
    }

    public void inputPostalCode(String value) {
        onType(postalCodeField(), value);
    }

    public void clickContinueButton() {
        onClick(continueButton());
    }

    public void clickCancelButton() {
        onClick(cancelButton());
    }
}
