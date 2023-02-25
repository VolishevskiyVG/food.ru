package ru.mts.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    SelenideElement
            searchInput = $(byText("Поиск")),
            searchValue = $("input[type='text']"),
    checkSearch = $(".mts-search-header");

    public SearchPage searchProduct() {
        searchInput.click();
        searchValue.setValue("тариф").pressEnter();
        return this;
    }
    public SearchPage checkSearchProduct() {
        checkSearch.shouldHave(text("Поиск по сайту"));
        return this;
    }
}
