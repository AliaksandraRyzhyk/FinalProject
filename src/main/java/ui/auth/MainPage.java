package ui.auth;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private final SelenideElement auth = $x("//a[@class='auth']");
    private final SelenideElement authButton = $x("//a[@class='btn-text']");

//    @Step("Нажать на кнопку авторизации")
    public MainPage clickButton() {
        auth.click();
        return this;
    }

//    @Step ("Нажать на кнопку зарегистироваться")
    public SingInPage clickLoginButton() {
        authButton.click();
        return page(SingInPage.class);
    }
}
