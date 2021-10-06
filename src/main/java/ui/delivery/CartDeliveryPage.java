package ui.delivery;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class CartDeliveryPage {
    private final SelenideElement order = $x("//a[text()='Оформить заказ']");

    private static Logger logger = Logger.getLogger(CartDeliveryPage.class);

    @Step("Нажать на кнопку Оформить заказ")
    public DeliveryPage orderToItem(){
        order.click();
        logger.debug("Button 'Оформить заказ' has been inputted");
        return page(DeliveryPage.class);
    }
}
