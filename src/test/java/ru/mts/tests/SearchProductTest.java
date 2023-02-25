package ru.mts.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.pages.MainPage;
import ru.mts.pages.SearchPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchProductTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск")
    public void testLogo() {
        step("Открыть персональную страницу МТС", () -> {
            mainPage.personalPage();
        });
        step("Проверить, что происходит поиск", () -> {
            searchPage.searchProduct();
        });
        step("Проверить, что открылась страница Поиск по сайту", () -> {
            searchPage.checkSearchProduct();
        });


    }
}
