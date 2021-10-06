package ui;

import ui.auth.SingInPage;
import com.codeborne.selenide.Configuration;
import config.UserConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.auth.AuthPage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AuthTest {
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Test
    public void testAuth() {
        open("https://fizcult.by/");

        AuthPage authPage = page(AuthPage.class);

        SingInPage singInPage = authPage
                .clickButton()
                .clickLoginButton();

        singInPage
                .nameInput(UserConfig.USER_NAME)
                .inputLogin(UserConfig.USER_LOGIN)
                .inputPassword(UserConfig.USER_PASSWORD)
                .inputConfirmPassword(UserConfig.USER_CONFIRM_PASSWORD)
                .clickSubmit();

        Assertions.assertTrue(singInPage.messageIsVisible());
    }
}
