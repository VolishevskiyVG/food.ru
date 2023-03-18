package ru.mts.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;

import org.openqa.selenium.remote.DesiredCapabilities;
import config.Project;
import ru.mts.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.mts.pages.PersonPage;

import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = Project.config.baseUrl();
        Configuration.browserSize = Project.config.browserSize();
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();


        Configuration.remote = Project.config.getRemoteUrl() + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }
        @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            PersonPage personPage = new PersonPage();
            step("Открыть персональную страницу МТС", () -> {
                personPage.openPage();

            });

    }
    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}