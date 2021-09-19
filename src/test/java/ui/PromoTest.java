package ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.promo.CartPage;
import ui.promo.ItemPage;
import ui.promo.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class PromoTest {
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @ParameterizedTest
    @CsvSource({"No789,'Промокод не найден.'"})
    public void testPromoSubscribe(String search, String expectedResult) {
        open("https://fizcult.by/");

        MainPage mainPage = page(MainPage.class);

        ItemPage itemPage = mainPage
                .hoverOverGoal()
                .checkTreatment()
                .selectItem();

        CartPage cartPage = itemPage
                .addToCart()
                .openCart();
        cartPage.enterText(search).submit();

        String actualResult = cartPage.getResult();

        Assertions.assertEquals(expectedResult, actualResult, String.format("Expected:%s,but actual:%s", expectedResult, actualResult));
    }
}
