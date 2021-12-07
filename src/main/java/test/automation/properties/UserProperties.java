package test.automation.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import test.automation.model.UserModel;

@Data
@Configuration
@EnableConfigurationProperties({
        UserProperties.class
})
@ConfigurationProperties(prefix = "user")
public class UserProperties {
    private UserModel standard;
    private UserModel locked;
    private UserModel problem;
    private UserModel performance;

    public UserModel getUser(String type) {
        UserModel user;

        switch (type.toLowerCase()) {
            case "standard":
                user = this.getStandard();
                break;
            case "locked":
                user = this.getLocked();
                break;
            case "problem":
                user = this.getProblem();
                break;
            case "performance":
                user = this.getPerformance();
                break;
            default:
                user = UserModel.builder().username(type).build();
        }
        return user;
    }

}
