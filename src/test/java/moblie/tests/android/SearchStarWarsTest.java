package moblie.tests.android;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.id;

public class SearchStarWarsTest extends AndroidTestBase {

    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName(("Search Wikipedia StarWars"))
    void searchTest() {
        step("Type search", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("starwars");
        });
        step("Verify content found", () ->
                $(id("org.wikipedia.alpha:id/view_card_header_title")).shouldHave(text("In the news")));

    }
}
