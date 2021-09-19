package ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.subscribe.MainPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SubscribeTest {
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @ParameterizedTest
    @CsvSource({"ryzhyks.sasha@list.ru,'Спасибо!'"})
    public void testSubscribe(String text, String expectedMessage) {
        open("https://fizcult.by/");

        MainPage mainPage = page(MainPage.class);
        mainPage.enterText(text).clickSubscribe().messageIsVisible();

        String actualMessage = mainPage.getSubscribeMessage();

        Assertions.assertEquals(expectedMessage, actualMessage, String.format("Expected:%s,but actual:%s", expectedMessage, actualMessage));
    }
}