package ui.subscribe;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class SubscribePage {
    private final SelenideElement subscribeEmail = $x("//input[@class='subscribe-email']");
    private final SelenideElement subscribeButton = $x("//span[text()='Подписаться']");
    private final SelenideElement subscribeMessage = $x("//div[@class='popup__body']//h1");

    private static Logger logger = Logger.getLogger(SubscribePage.class);

    @Step("Зафиксировать полученное сообщение")
    public String getSubscribeMessage() {
        logger.debug("Subscribe message has been received");
        return subscribeMessage.text();
    }

    @Step("Ввести {0} в поле подписки на акции и новинки магазина")
    public SubscribePage enterText(String text) {
        subscribeEmail.val(text);
        logger.debug("Text promo " + text + " has been inputted");
        return this;
    }

    @Step("Нажать на кнопку Подписаться")
    public SubscribePage clickSubscribe() {
        subscribeButton.click();
        logger.debug("Button 'Подписаться' has been clicked");
        return this;
    }

    @Step("Проверить видимость сообщения об успешности оформления подписки")
    public SubscribePage messageIsVisible() {
        subscribeMessage.shouldBe(Condition.visible);
        logger.debug("Message has been visible");
        return this;
    }
}
