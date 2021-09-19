package ui.delivery;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ItemPage {
    private final SelenideElement counter = $x("//span[@class='counter__btn counter__btn_plus']");
    private final SelenideElement addToCart = $x("//button[@data-brand='QNT']");
    private final SelenideElement cart = $x("(//div[@class='cart-min-desc']/span[@class='cart__icon'])[1]");

    public ItemPage addNumber() {
        counter.click();
        return this;
    }

    public ItemPage addToCart() {
        addToCart.scrollIntoView(false).click();
        return this;
    }

    public CartPage openCart() {
        cart.scrollIntoView(false).click();
        return page(CartPage.class);
    }
}
