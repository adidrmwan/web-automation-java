package test.automation.stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.web.LoginPage;
import test.automation.properties.UserProperties;

public class LoginSteps {
    @Autowired
    LoginPage loginPage;

    @Autowired
    UserProperties userProperties;

    @Given("user open saucedemo homepage")
    public void userOpenSaucedemoHomepage() {
        loginPage.openPage();
    }

    @When("{word} user input email")
    public void standardUserInputEmail(String user) {
        String username = userProperties.getUser(user).getUsername();
        loginPage.inputUsername(username);
    }

    @And("{word} user input password")
    public void standardUserInputPassword(String user) {
        String password = userProperties.getUser(user).getPassword();
        loginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("standard user see homepage")
    public void standardUserSeeHomepage() {
        boolean actual = loginPage.isOnHomepage();
        Assert.assertTrue(actual);
    }
}
