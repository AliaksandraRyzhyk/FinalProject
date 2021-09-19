package ui;

import ui.delivery.CartPage;
import ui.delivery.DeliveryPage;
import ui.delivery.ItemPage;
import ui.delivery.MainPage;
import com.codeborne.selenide.Configuration;
import config.UserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class DeliveryTest {
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    public void testDeliveryItem() {
        open("https://fizcult.by/");

        MainPage mainPage = page(MainPage.class);

        ItemPage itemPage = mainPage
                .clickButton()
                .checkIsotonicButton()
                .selectItem();

        CartPage cartPage = itemPage
                .addNumber()
                .addToCart()
                .openCart();

        DeliveryPage deliveryPage = cartPage
                .orderToItem();
        deliveryPage.addressSelect()
                .daySelect()
                .nameInput(UserConfig.USER_NAME)
                .inputLogin(UserConfig.USER_LOGIN)
                .clickSubmit();

        Assertions.assertTrue(deliveryPage.messageIsVisible());
    }
}
