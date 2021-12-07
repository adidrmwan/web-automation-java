package test.automation.driver;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@Component("test.automation.driver.DriverPool")
public class DriverPool {
    private final HashMap<String, WebDriver> web = new HashMap<>();

    public WebDriver getWebDriver() {
        return this.web.getOrDefault(Thread.currentThread().getName(), null);
    }

    public void setWebDriver(WebDriver webDriver) {
        this.web.put(Thread.currentThread().getName(), webDriver);
    }
}
