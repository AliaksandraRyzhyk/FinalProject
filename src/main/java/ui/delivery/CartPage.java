package ui.delivery;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class CartPage {
    private final SelenideElement order = $x("//a[text()='Оформить заказ']");

    public DeliveryPage orderToItem(){
        order.click();
        return page(DeliveryPage.class);
    }
}
