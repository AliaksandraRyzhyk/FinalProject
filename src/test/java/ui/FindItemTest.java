package ui;

import com.codeborne.selenide.Configuration;
import ui.findItem.ItemPage;
import ui.findItem.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class FindItemTest {
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @ParameterizedTest
    @CsvSource({"УГЛЕВОДНАЯ СМЕСЬ CARBONOX,'УГЛЕВОДНАЯ СМЕСЬ CARBONOX, OLIMP', '89.90 РУБ.'"})
    public void testFindItem(String searchContent, String expectedName, String expectedPrice) {
        open("https://fizcult.by/");

        MainPage mainPage = page(MainPage.class);

        ItemPage itemPage = mainPage
                .enterText(searchContent)
                .selectItem("CARBONOX");

        String actualName = itemPage.getItemName();
        String actualPrice = itemPage.getItemPrice();

        Assertions.assertEquals(expectedName, actualName, String.format("Expected:%s,but actual:%s", expectedName, actualName));
        Assertions.assertEquals(expectedPrice, actualPrice, String.format("Expected:%s,but actual:%s", expectedPrice, actualPrice));
    }
}
