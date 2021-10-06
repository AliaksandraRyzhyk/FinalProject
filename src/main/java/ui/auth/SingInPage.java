package ui.auth;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class SingInPage {
    private final SelenideElement nameInput = $x("//input[@name='USER_NAME']");
    private final SelenideElement loginInput = $x("//input[@name='USER_LOGIN']");
    private final SelenideElement passwordInput = $x("//input[@name='USER_PASSWORD']");
    private final SelenideElement confirmPasswordInput = $x("//input[@name='USER_CONFIRM_PASSWORD']");
    private final SelenideElement submit = $x("//input[@name='Register']");
    private final SelenideElement authMessage = $x("//h1[@class='title']");

    private static Logger logger = Logger.getLogger(SingInPage.class);

    @Step("Ввести {0} в поле Ваше имя")
    public SingInPage nameInput(String text) {
        nameInput.val(text);
        logger.debug("Name: " + text + " has been inputted");
        return this;
    }

    @Step("Ввести {0} в поле email")
    public SingInPage inputLogin(String text) {
        loginInput.val(text);
        logger.debug("Login: " + text + " has been inputted");
        return this;
    }

    @Step("Ввести {0} в поле пароль")
    public SingInPage inputPassword(String text) {
        passwordInput.val(text);
        logger.debug("Password: " + text + " has been inputted");
        return this;
    }

    @Step("Ввести {0} в поле подтверждения пароля")
    public SingInPage inputConfirmPassword(String text) {
        confirmPasswordInput.val(text);
        logger.debug("ConfirmPassword: " + text + " has been inputted");
        return this;
    }

    @Step("Нажать на кнопку зарегистрироваться")
    public SingInPage clickSubmit() {
        submit.click();
        logger.debug("Button 'Submit' has been clicked");
        return this;
    }

    @Step("Проверка видимости сообщения об успешной авторизации")
    public Boolean messageIsVisible() {
        authMessage.shouldBe(Condition.visible);
        logger.info("Auth message has been visible");
        return true;
    }
}
