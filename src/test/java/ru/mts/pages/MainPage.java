package ru.mts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement
            headerLogo = $(".header__logo[alt=\"МТС\"");
    public MainPage pesronalPage() {
        open("/personal");
        return this;
    }
    public MainPage checkLogo() {
        headerLogo.should(appear);
        return this;
    }
}
