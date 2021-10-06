package ui.auth;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AuthPage {
    private final SelenideElement auth = $x("//a[@class='auth']");
    private final SelenideElement authButton = $x("//a[@class='btn-text']");

    private static Logger logger = Logger.getLogger(AuthPage.class);

    @Step("Нажать на кнопку авторизации")
    public AuthPage clickButton() {
        auth.click();
        logger.debug("Auth button has been clicked");
        return this;
    }

    @Step ("Нажать на кнопку зарегистироваться")
    public SingInPage clickLoginButton() {
        authButton.click();
        logger.debug("Button 'Auth' has been clicked");
        return page(SingInPage.class);
    }
}
