package ui;

import com.codeborne.selenide.Configuration;
import ui.filter.ItemFilterPage;
import org.junit.jupiter.api.Assertions;
import ui.filter.MainFilterPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class FilterTest {
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @ParameterizedTest
    @CsvSource("Найдено 7 товаров")
    public void testFilterItem(String expectedResult) {
        open("https://fizcult.by/");

        MainFilterPage mainFilterPage = page(MainFilterPage.class);

        ItemFilterPage itemFilterPage = mainFilterPage
                .clickButton()
                .checkBrandButton();
        itemFilterPage.clickProteinButton();

        String actualResult = "Найдено " + itemFilterPage.getNumber() + " товаров";

        Assertions.assertEquals(actualResult, expectedResult, String.format("Expected:%s,but actual:%s", expectedResult, actualResult));
    }
}
