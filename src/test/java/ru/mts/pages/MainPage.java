package ru.mts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement
            headerLogo = $(".header__logo[alt=\"МТС\""),
            bestsellersMenu = $(".subscribes-and-services__cards-wrapper"),
            cardContent = $(".card__left-content"),
            cardContentAccess = $(".mts16-footer__to-bottom-content");

    public MainPage personalPage() {
        open("/personal");
        return this;
    }

    public MainPage checkLogo() {
        headerLogo.should(appear);
        return this;
    }

    public MainPage checkBestsellers(String hit) {
        bestsellersMenu.shouldHave(text(hit));
        return this;
    }
    public MainPage cardMtsAccess() {
        cardContent.click();
        return this;
    }
    public MainPage checkMtsAccess() {
        cardContentAccess.shouldHave(text("МТС Доступ"));
        return this;
    }

}
