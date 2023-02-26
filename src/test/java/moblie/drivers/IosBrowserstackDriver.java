package moblie.drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Project;
import config.ProjectConfig;
import lombok.SneakyThrows;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;


public class IosBrowserstackDriver implements WebDriverProvider {



    @SneakyThrows
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);



        mutableCapabilities.setCapability("browserstack.user", Project.config.username());
        mutableCapabilities.setCapability("browserstack.key", Project.config.password());


        mutableCapabilities.setCapability("app", Project.config.appIos());


        mutableCapabilities.setCapability("device", Project.config.deviceIos());
        mutableCapabilities.setCapability("os_version", Project.config.os_versionIos());


        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");


        return new RemoteWebDriver(getRemoteWebDriverUrl(), mutableCapabilities);
    }

    private URL getRemoteWebDriverUrl() {
        try {
            return new URL(Project.config.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}


