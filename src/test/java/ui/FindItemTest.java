package ui;

import com.codeborne.selenide.Configuration;
import ui.findItem.ItemFindPage;
import ui.findItem.MainFindPage;
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
    @CsvSource({"УГЛЕВОДНАЯ СМЕСЬ DEXTREX JUICE,'УГЛЕВОДНАЯ СМЕСЬ DEXTREX JUICE, OLIMP', '20.80 РУБ.'"})
    public void testFindItem(String searchContent, String expectedName, String expectedPrice) {
        open("https://fizcult.by/");

        MainFindPage mainFindPage = page(MainFindPage.class);

        ItemFindPage itemFindPage = mainFindPage
                .enterText(searchContent)
                .clickButtonSearch()
                .selectItem("DEXTREX JUICE");

        String actualName = itemFindPage.getItemName();
        String actualPrice = itemFindPage.getItemPrice();

        Assertions.assertEquals(expectedName, actualName, String.format("Expected:%s,but actual:%s", expectedName, actualName));
        Assertions.assertEquals(expectedPrice, actualPrice, String.format("Expected:%s,but actual:%s", expectedPrice, actualPrice));
    }
}
