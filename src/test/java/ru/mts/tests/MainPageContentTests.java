package ru.mts.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mts.pages.MainPage;


import static io.qameta.allure.Allure.step;

public class MainPageContentTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка логотипа МТС на главной страницы")
    public void testLogo() {
        step("Проверить что логотип МТС присутствует", () -> {
            mainPage.checkLogo();
        });


    }

    @Severity(SeverityLevel.NORMAL)
    @Owner("v.volishevskiy")
    @DisplayName("Проверить что на главной странице присутствуют хиты продаж")
    @ValueSource(strings = {"МТС Доступ", "НЕТАРИФ", "Тарифище"})
    @ParameterizedTest(name = "\"{0}\"")
    public void testHit(String hit) {
        step("Проверить, что есть блок Хиты продаж", () -> {
            mainPage.checkBestsellers(hit);
        });


    }

    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверить, что происходит переход в Мтс Доступ из главной страницы")
    public void goToPageNew() {
        step("Нажать на блок МТС Доступ", () -> {
            mainPage.clickToCard();
        });
        step("Проверить, что осуществился переход на МТС Доступ", () -> {
            mainPage.checkMtsAccess();
        });


    }

    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Отображение Программы привилегий в выпадающем списке Комбо ")
    public void menuPrivilege() {
        step("Нажать на выпадающий список Комбо", () -> {
            mainPage.menuCombo();
        });
        step("Проверить, что отображается Программы привилегий", () -> {
            mainPage.checkMenuPrivilege();
        });


    }

    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверить, что происходит перелистывание контента по слайдеру")
    public void clickCover() {
        step("Проверка работы кнопки слайдера", () -> {
            mainPage.checkLoaderSlider();
        });


    }
}
