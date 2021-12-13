package test.automation.stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.web.InventoryPage;
import test.automation.pages.web.LoginPage;
import test.automation.properties.UserProperties;

public class LoginSteps {
    @Autowired
    LoginPage loginPage;

    @Autowired
    InventoryPage inventoryPage;

    @Autowired
    UserProperties userProperties;

    @Given("user open saucedemo homepage")
    public void userOpenSaucedemoHomepage() {
        loginPage.openPage();
    }

    @When("user input {word} username")
    public void standardUserInputEmail(String user) {
        String username;
        if (user.equals("empty"))
            username = "";
        else if (userProperties.getUser(user).getUsername() != null)
            username = userProperties.getUser(user).getUsername();
        else
            username = user;

        System.out.println(username);

        loginPage.inputUsername(username);
    }

    @And("user input {word} password")
    public void standardUserInputPassword(String user) {
        String password;
        if (user.equals("empty"))
            password = "";
        else if (userProperties.getUser(user).getPassword() != null)
            password = userProperties.getUser(user).getPassword();
        else
            password = user;
        System.out.println(password);
        loginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("standard user see inventory page")
    public void standardUserSeeHomepage() {
        boolean actual = inventoryPage.isOnHomepage();
        String title = inventoryPage.getTitleText();

        Assert.assertTrue(actual);
        Assert.assertEquals("products", title);
    }

    @Then("user see error toast displayed")
    public void userSeeErrorToastDisplayed() {
        boolean actual = loginPage.isErrorToastDisplayed();
        Assert.assertTrue(actual);
    }

    @And("user see {string} displayed")
    public void userSeeDisplayed(String message) {
        String actual = loginPage.getErrorToastMessage();
        Assert.assertEquals(message, actual);
    }
}
