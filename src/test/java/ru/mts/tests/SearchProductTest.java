package ru.mts.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.mts.pages.SearchPage;

import static io.qameta.allure.Allure.step;
@Owner("v.volishevskiy")
public class SearchProductTest extends TestBase {
    SearchPage searchPage = new SearchPage();



    @Severity(SeverityLevel.NORMAL)
    @ValueSource(strings ={"тариф"})
    @ParameterizedTest(name = "{0}")
    @DisplayName("Поиск по сайту")
    public void testLogo(String product) {
        step("Проверить, что происходит поиск", () -> {
            searchPage.searchProduct(product);
        });
        step("Проверить, что открылась страница Поиск по сайту", () -> {
            searchPage.checkSearchProduct("Поиск по сайту");
        });


    }
}
