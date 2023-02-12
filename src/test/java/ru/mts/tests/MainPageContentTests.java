package ru.mts.tests;

import org.junit.jupiter.api.Test;
import ru.mts.pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageContentTests extends TestBase {
    MainPage mainPage = new MainPage();

    @Test
    public void testLogo() {
        step("Открыть персональную страницу МТС", () -> {
            mainPage.pesronalPage();
        });
        step("Проверить что логотип МТС присутствует", () -> {
            mainPage.checkLogo();
        });
        // step("Перейти во вкладку Телеканалы", () -> {
        //     $(".b-wrapper_ukit").shouldHave(text("ХИТЫ ПРОДАЖ"));
        // });

    }
}
