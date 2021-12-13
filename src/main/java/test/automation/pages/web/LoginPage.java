package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;
import test.automation.properties.ConfigProperties;

@Component("test.automation.pages.web.LoginPage")
public class LoginPage extends BasePageObject {
    @Autowired
    ConfigProperties configProperties;

    private By usernameField() {
        return By.id("user-name");
    }

    private By passwordField() {
        return By.id("password");
    }

    private By loginButton() {
        return By.id("login-button");
    }

    private By errorToast() {
        return By.className("error-message-container");
    }

    private By errorToastMessage() {
        return By.xpath("//h3[@data-test='error']");
    }

    public void openPage() {
        goTo(configProperties.getWeb().getBaseUrl());
    }

    public void inputUsername(String username) {
        onType(usernameField(), username);
    }

    public void inputPassword(String password) {
        onType(passwordField(), password);
    }

    public void clickLoginButton() {
        onClick(loginButton());
    }

    public boolean isErrorToastDisplayed() {
        return waitUntilPresence(errorToast()).isDisplayed();
    }

    public String getErrorToastMessage() {
        return waitUntilVisible(errorToastMessage()).getText();
    }
}
