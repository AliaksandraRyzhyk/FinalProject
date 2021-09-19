package ui;

import com.codeborne.selenide.Configuration;
import config.UserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.sales.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class SalesTest {
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    public void testSale() {
        open("https://fizcult.by/");

        MainPage mainPage = page(MainPage.class);
        mainPage.clickButton()
                .nameInput(UserConfig.USER_NAME)
                .selectFieldActivities()
                .selectFieldActivitiesType()
                .emailInput(UserConfig.USER_LOGIN)
                .clickSubmit();

        Assertions.assertTrue(mainPage.messageIsNotVisible());
    }
}
