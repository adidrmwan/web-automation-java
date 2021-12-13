package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.automation.pages.web.CheckoutCompletePage")
public class CheckoutCompletePage extends BasePageObject {
    private By title() {
        return By.xpath("//span[contains(text(), 'Checkout: Complete!')]");
    }

    private By logo() {
        return By.className("pony_express");
    }

    private By completeText() {
        return By.className("complete-header");
    }

    public boolean isOnCheckoutCompletePage() {
        return waitUntilPresence(title()).isDisplayed();
    }

    public boolean validateOrderHasBeenOrdered() {
        return waitUntilPresence(logo()).isDisplayed() && waitUntilPresence(completeText()).isDisplayed();
    }
}
