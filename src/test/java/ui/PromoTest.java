package ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.promo.CartPromoPage;
import ui.promo.ItemPromoPage;
import ui.promo.MainPromoPage;

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

        MainPromoPage mainPromoPage = page(MainPromoPage.class);

        ItemPromoPage itemPromoPage = mainPromoPage
                .hoverOverGoal()
                .checkTreatment()
                .selectItem();

        CartPromoPage cartPromoPage = itemPromoPage
                .addToCart()
                .openCart();
        cartPromoPage.enterText(search).submit();

        String actualResult = cartPromoPage.getResult();

        Assertions.assertEquals(expectedResult, actualResult, String.format("Expected:%s,but actual:%s", expectedResult, actualResult));
    }
}
