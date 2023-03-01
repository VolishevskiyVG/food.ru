package ru.mts.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.pages.MainPage;
import ru.mts.pages.SearchPage;

import static io.qameta.allure.Allure.step;

public class SearchProductTest extends TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();

    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск по сайту")
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
