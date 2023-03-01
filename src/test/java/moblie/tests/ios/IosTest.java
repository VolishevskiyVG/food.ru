package moblie.tests.ios;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.id;


public class IosTest extends IosTestBase {

    @Test
    @Owner("v.volishevskiy")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка поиска (ios)")
    void OutputTextTest() {
        step("Click Text Button", () -> {
            $(id("Text Button")).click();
        });

        step("Check initial state Output text", () -> {
            assertEquals("Waiting for text input.", $(id("Text Output")).getText());
        });

        step(format("Set value %s in the input field and press enter", "hello@browserstack.com"), () -> {
            $(id("Text Input")).click();
            $(id("Text Input")).sendKeys("hello@browserstack.com");
            $(id("Text Input")).pressEnter();
        });

        step("Check Output text", () -> {
            assertEquals("hello@browserstack.com", $(id("Text Output")).getText());
        });
    }
}
