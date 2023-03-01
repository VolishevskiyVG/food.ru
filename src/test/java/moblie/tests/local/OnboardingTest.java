package moblie.tests.local;


import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;

public class OnboardingTest extends LocalTestBase {
    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Прохождение онбординга")
    void onBoardingScreenTest() {
        step("Переход на главную страницу", () -> {
            $(id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("The Free Encyclopedia\n" +
                    "…in over 300 languages"));
        });
        step("Перейти на New ways to explore", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            assertEquals("New ways to explore", $(id("org.wikipedia.alpha:id/primaryTextView")).text());

        });
        step("Перейти на Reading lists with sync", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            assertEquals("Reading lists with sync", $(id("org.wikipedia.alpha:id/primaryTextView")).text());
        });
        step("Перейти на Send anonymous data", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
            assertEquals("Send anonymous data", $(id("org.wikipedia.alpha:id/primaryTextView")).text());
        });
        step("Ending onBoarding", () -> {
            $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
            $(id("org.wikipedia.alpha:id/main_toolbar_wordmark")).shouldBe(visible);
        });
    }
}
