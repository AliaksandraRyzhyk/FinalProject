package ui.promo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ItemPromoPage {
    private final SelenideElement addToCart = $x("//button[@data-brand='QNT']");
    private final SelenideElement cart = $x("(//div[@class='cart-min-desc']/span[@class='cart__icon'])[1]");

    private static Logger logger = Logger.getLogger(ItemPromoPage.class);

    @Step("Нажать на кнопку В корзину")
    public ItemPromoPage addToCart() {
        addToCart.scrollIntoView(false).click();
        logger.debug("Button 'В корзину' has been clicked");
        return this;
    }

    @Step("Открыть корзину товаров")
    public CartPromoPage openCart() {
        cart.scrollIntoView(false).click();
        logger.debug("Cart button has been clicked");
        return page(CartPromoPage.class);
    }
}
