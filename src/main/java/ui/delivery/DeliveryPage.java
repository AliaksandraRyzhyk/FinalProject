package ui.delivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class DeliveryPage {
    private final SelenideElement deliveryAddress = $x("//label[@for='address_15048']");
    private final SelenideElement deliveryDay = $x("//label[@for='date_2']");
    private final SelenideElement deliveryName = $x("//input[@name='ORDER_PROP_3']");
    private final SelenideElement deliveryLogin = $x("//input[@name='ORDER_PROP_5']");
    private final SelenideElement submit = $x("//a[@class='btn btn_type_flat']");
    private final SelenideElement message = $x("//div[@class='toast-message']");

    public String getMessage() {
        return message.text();
    }

    public DeliveryPage addressSelect() {
        deliveryAddress.click();
        return this;
    }

    public DeliveryPage daySelect() {
        deliveryDay.click();
        return this;
    }

    public DeliveryPage nameInput(String text) {
        deliveryName.val(text);
        return this;
    }

    public DeliveryPage inputLogin(String text) {
        deliveryLogin.val(text);
        return this;
    }

    public DeliveryPage clickSubmit() {
        submit.click();
        return this;
    }

    public Boolean messageIsVisible() {
        message.shouldBe(Condition.visible);
        return true;
    }
}
