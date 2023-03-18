package ru.mts.pages;

import static com.codeborne.selenide.Selenide.open;

public class PersonPage {
    public PersonPage openPage() {
        open("/personal");
        return this;
    }
}
