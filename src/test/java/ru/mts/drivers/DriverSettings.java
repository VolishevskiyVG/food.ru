package ru.mts.drivers;

import com.codeborne.selenide.Configuration;
import ru.mts.config.Project;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {
    public static void configure(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = Project.config.baseUrl();
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100");


        Configuration.remote = System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }
}
