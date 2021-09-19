package ui.subscribe;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private final SelenideElement subscribeEmail = $x("//input[@class='subscribe-email']");
    private final SelenideElement subscribeButton = $x("//span[text()='Подписаться']");
    private final SelenideElement subscribeMessage = $x("//div[@class='popup__body']//h1");

    public String getSubscribeMessage() {
        return subscribeMessage.text();
    }


    public MainPage enterText(String text) {
        subscribeEmail.val(text);
        return this;
    }

    public MainPage clickSubscribe() {
        subscribeButton.click();
        return this;
    }

    public MainPage messageIsVisible() {
        subscribeMessage.shouldBe(Condition.visible);
        return this;
    }
}
