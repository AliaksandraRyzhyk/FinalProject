package ui;

import ui.delivery.CartDeliveryPage;
import ui.delivery.DeliveryPage;
import ui.delivery.ItemDeliveryPage;
import ui.delivery.MainDeliveryPage;
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

        MainDeliveryPage mainDeliveryPage = page(MainDeliveryPage.class);

        ItemDeliveryPage itemDeliveryPage = mainDeliveryPage
                .clickButton()
                .checkIsotonicButton()
                .selectItem();

        CartDeliveryPage cartDeliveryPage = itemDeliveryPage
                .addNumber()
                .addToCart()
                .openCart();

        DeliveryPage deliveryPage = cartDeliveryPage
                .orderToItem();
        deliveryPage.addressSelect()
                .daySelect()
                .nameInput(UserConfig.USER_NAME)
                .inputLogin(UserConfig.USER_LOGIN)
                .clickSubmit();

        Assertions.assertTrue(deliveryPage.messageIsVisible());
    }
}
