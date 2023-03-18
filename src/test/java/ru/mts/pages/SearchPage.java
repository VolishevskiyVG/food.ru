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

    public SearchPage searchProduct(String product) {
        searchInput.click();
        searchValue.setValue(product).pressEnter();
        return this;
    }
    public SearchPage checkSearchProduct(String check) {
        checkSearch.shouldHave(text(check));
        return this;
    }
}
