package test.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

import java.util.List;

@Component("test.automation.pages.web.CartPage")
public class CartPage extends BasePageObject {
    private By title() {
        return By.xpath("//span[contains(text(), 'Cart')]");
    }

    private By continueShoppingButton() {
        return By.id("continue-shopping");
    }

    private By checkoutButton() {
        return By.id("checkout");
    }

    private By removeBackpackButton() {
        return By.id("remove-sauce-labs-backpack");
    }

    private By removeBikelightButton() {
        return By.id("remove-sauce-labs-bike-light");
    }

    private By productName() {
        return By.className("inventory_item_name");
    }

    public boolean isOnCartPage() {
        return waitUntilPresence(title()).isDisplayed();
    }

    public void clickContinueShoppingButton() {
        onClick(continueShoppingButton());
    }

    public void clickCheckoutButton() {
        onClick(checkoutButton());
    }

    public boolean validateProductOnCart(String product) {
        List<WebElement> elementList = waitUntilPresences(productName());
        int temp = elementList.size();
        for (WebElement element : elementList) {
            if (!element.getText().toLowerCase().contains(product)) {
                temp--;
            }
        }
        System.out.println("temp : " +temp );
        return temp > 0;
    }
}
