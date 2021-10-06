package ui.delivery;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ItemDeliveryPage {
    private final SelenideElement counter = $x("//span[@class='counter__btn counter__btn_plus']");
    private final SelenideElement addToCart = $x("//button[@data-brand='QNT']");
    private final SelenideElement cart = $x("(//div[@class='cart-min-desc']/span[@class='cart__icon'])[1]");

    private static Logger logger = Logger.getLogger(ItemDeliveryPage.class);

    @Step("Увеличить количество товара на 1 единицу")
    public ItemDeliveryPage addNumber() {
        counter.click();
        logger.debug("Number of items  has been increased");
        return this;
    }

    @Step("Нажать на кнопку В корзину")
    public ItemDeliveryPage addToCart() {
        addToCart.scrollIntoView(false).click();
        logger.debug("Button 'В корзину'  has been clicked");
        return this;
    }

    @Step("Открыть корзину товаров")
    public CartDeliveryPage openCart() {
        cart.scrollIntoView(false).click();
        logger.debug("Cart button  has been clicked");
        return page(CartDeliveryPage.class);
    }
}
