package ui.promo;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ItemPage {
    private final SelenideElement addToCart = $x("//button[@data-brand='QNT']");
    private final SelenideElement cart = $x("(//div[@class='cart-min-desc']/span[@class='cart__icon'])[1]");

    public ItemPage addToCart() {
        addToCart.scrollIntoView(false).click();
        return this;
    }

    public CartPage openCart() {
        cart.scrollIntoView(false).click();
        return page(CartPage.class);
    }
}
