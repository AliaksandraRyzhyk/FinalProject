package ui.delivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;

public class DeliveryPage {
    private final SelenideElement deliveryAddress = $x("//label[@for='address_15048']");
    private final SelenideElement deliveryDay = $x("//label[@for='date_2']");
    private final SelenideElement deliveryName = $x("//input[@name='ORDER_PROP_3']");
    private final SelenideElement deliveryLogin = $x("//input[@name='ORDER_PROP_5']");
    private final SelenideElement submit = $x("//a[@class='btn btn_type_flat']");
    private final SelenideElement message = $x("//div[@class='toast-message']");

    private static Logger logger = Logger.getLogger(DeliveryPage.class);

    @Step("Зафиксировать сообщение о некорректно внесенных данных")
    public String getMessage() {
        logger.info("Delivery Message has been received");
        return message.text();
    }

    @Step("Выбрать адрес для самовывоза")
    public DeliveryPage addressSelect() {
        deliveryAddress.click();
        logger.debug("Delivery address has been chosen");
        return this;
    }

    @Step("Выбрать день для самовывоза")
    public DeliveryPage daySelect() {
        deliveryDay.click();
        logger.debug("Delivery day  has been chosen");
        return this;
    }

    @Step("Ввести {0} в поле Ваше имя")
    public DeliveryPage nameInput(String text) {
        deliveryName.val(text);
        logger.debug("Name: " + text + " has been inputted");
        return this;
    }

    @Step("Ввести {0} в поле Ваше email")
    public DeliveryPage inputLogin(String text) {
        deliveryLogin.val(text);
        logger.debug("Login: " + text + " has been inputted");
        return this;
    }

    @Step("Нажать на кнопку Оформить заказ")
    public DeliveryPage clickSubmit() {
        submit.click();
        logger.debug("Button 'Submit' has been clicked");
        return this;
    }

    @Step("Проверить видимость сообщения о некорректно внесенных данных")
    public Boolean messageIsVisible() {
        message.shouldBe(Condition.visible);
        logger.info("Auth message has been visible");
        return true;
    }
}
