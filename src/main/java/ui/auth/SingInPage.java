package ui.auth;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SingInPage {
    private final SelenideElement nameInput = $x("//input[@name='USER_NAME']");
    private final SelenideElement loginInput = $x("//input[@name='USER_LOGIN']");
    private final SelenideElement passwordInput = $x("//input[@name='USER_PASSWORD']");
    private final SelenideElement confirmPasswordInput = $x("//input[@name='USER_CONFIRM_PASSWORD']");
    private final SelenideElement submit = $x("//input[@name='Register']");
    private final SelenideElement authMessage = $x("//h1[@class='title']");

//    @Step("Ввести {0} в поле Ваше имя")
    public SingInPage nameInput(String text) {
        nameInput.val(text);
        return this;
    }

//    @Step("Ввести {0} в поле email")
    public SingInPage inputLogin(String text) {
        loginInput.val(text);
        return this;
    }

//    @Step("Ввести {0} в поле пароль")
    public SingInPage inputPassword(String text) {
        passwordInput.val(text);
        return this;
    }

//    @Step("Ввести {0} в поле подтверждения пароля")
    public SingInPage inputConfirmPassword(String text) {
        confirmPasswordInput.val(text);
        return this;
    }

//    @Step("Нажать на кнопку зарегистрироваться")
    public SingInPage clickSubmit() {
        submit.click();
        return this;
    }

//    @Step("Проверка видимости сообщения об успешной авторизации")
    public Boolean messageIsVisible() {
        authMessage.shouldBe(Condition.visible);
        return true;
    }
}
