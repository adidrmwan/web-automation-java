package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.automation.pages.web.InventoryPage")
public class InventoryPage extends BasePageObject {

    private By headerTitle() {
        return By.className("title");
    }

    private By backpackToCartBtn() {
        return By.id("add-to-cart-sauce-labs-backpack");
    }

    private By bikeLightToCartBtn() {
        return By.id("add-to-cart-sauce-labs-bike-light");
    }

    private By boltTShirtToCartBtn() {
        return By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    }

    private By fleeceJacketToCartBtn() {
        return By.id("add-to-cart-sauce-labs-fleece-jacket");
    }

    private By onesieToCartBtn() {
        return By.id("add-to-cart-sauce-labs-onesie");
    }

    private By allTheThingsTShirtToCartBtn() {
        return By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    }

    private By cartBadge() {
        return By.className("shopping_cart_badge");
    }

    private By shoppingCart() {
        return By.id("shopping_cart_container");
    }

    public boolean isOnHomepage() {
        return waitUntilPresence(headerTitle()).isDisplayed();
    }

    public String getTitleText() {
        return waitUntilPresence(headerTitle()).getText().toLowerCase();
    }

    public void selectProduct(String name) {
        switch (name) {
            case "backpack":
                onClick(backpackToCartBtn());
                break;
            case "bike":
                onClick(bikeLightToCartBtn());
                break;
            case "bolt":
                onClick(boltTShirtToCartBtn());
                break;
            case "fleece":
                onClick(fleeceJacketToCartBtn());
                break;
            case "onesie":
                onClick(onesieToCartBtn());
                break;
            case "Test.allTheThings()":
                onClick(allTheThingsTShirtToCartBtn());
                break;
        }
    }

    public void clickShoppingCartButton() throws InterruptedException {
        Thread.sleep(10000);
        onClick(shoppingCart());
    }
}
