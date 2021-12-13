package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.automation.pages.web.CheckoutReviewPage")
public class CheckoutReviewPage extends BasePageObject {
    private By title() {
        return By.xpath("//span[contains(text(), 'Checkout: Overview')]");
    }

    private By cancelButton() {
        return By.id("cancel");
    }

    private By finishButton() {
        return By.id("finish");
    }

    private By productsTotalPrice() {
        return By.className("summary_subtotal_label");
    }

    private By taxPrice() {
        return By.className("summary_tax_label");
    }

    private By totalPrice() {
        return By.className("summary_total_label");
    }

    public boolean isOnCheckoutReviewPage() {
        return waitUntilPresence(title()).isDisplayed();
    }

    public boolean validateTotalPriceIsCorrect() {
        int totalPrice = getTotalProductPrice() + getTaxPrice();
        return getTotalPrice() == totalPrice;
    }

    public void clickFinisButton() {
        onClick(finishButton());
    }

    public void clickCancelButton() {
        onClick(cancelButton());
    }

    protected int getTotalProductPrice() {
        String totalProduct = waitUntilVisible(productsTotalPrice()).getText().replace("Item total: $", "").replace(".", "");
        return Integer.parseInt(totalProduct);
    }

    protected int getTaxPrice() {
        String taxPrice = waitUntilVisible(taxPrice()).getText().replace("Tax: $", "").replace(".", "");
        return Integer.parseInt(taxPrice);
    }

    protected int getTotalPrice() {
        String totalPrice = waitUntilVisible(totalPrice()).getText().replace("Total: $", "").replace(".", "");
        return Integer.parseInt(totalPrice);
    }

}
