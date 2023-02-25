package ru.mts.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mts.pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;
import static io.qameta.allure.Allure.step;

public class MainPageContentTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка логотипа МТС на главной страницы")
    public void testLogo() {
        step("Открыть персональную страницу МТС", () -> {
            mainPage.personalPage();
        });
        step("Проверить что логотип МТС присутствует", () -> {
            mainPage.checkLogo();
        });


    }

    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверить что на главной странице присутствуют хиты продаж")
    @ValueSource(strings = {"МТС Доступ", "НЕТАРИФ", "Тарифище"})
    @ParameterizedTest(name = "\"{0}\"")
    public void testHit(String hit){
        step("Открыть персональную страницу МТС", () -> {
            mainPage.personalPage();
        });
        step("Проверить, что есть блок Хиты продаж", () -> {
            mainPage.checkBestsellers(hit);
        });



    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверить, что происходит переход в Мтс Доступ из главной страницы")
    public void goToPageNew() {
        step("Открыть персональную страницу МТС", () -> {
            mainPage.personalPage();
        });
        step("Нажать на блок МТС Доступ", () -> {
            mainPage.cardMtsAccess();
        });
        step("Проверить, что осуществился переход на МТС Доступ", () -> {
            mainPage.checkMtsAccess();
        });


    }
}
