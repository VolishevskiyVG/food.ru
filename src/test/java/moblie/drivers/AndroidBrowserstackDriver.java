package moblie.drivers;

import com.codeborne.selenide.WebDriverProvider;


import config.Project;
import lombok.SneakyThrows;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

//import static config.Config.CONFIG;

public class AndroidBrowserstackDriver implements WebDriverProvider {


    @SneakyThrows
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);



        mutableCapabilities.setCapability("browserstack.user", Project.config.username());
        mutableCapabilities.setCapability("browserstack.key", Project.config.password());


        mutableCapabilities.setCapability("app", Project.config.appAndroid());

        mutableCapabilities.setCapability("device", Project.config.deviceAndroid());
        mutableCapabilities.setCapability("os_version", Project.config.os_versionAndroid());


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
