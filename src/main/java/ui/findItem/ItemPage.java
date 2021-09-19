package ui.findItem;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ItemPage {
    private final SelenideElement itemName = $x("//h1[@class='goods__title']");
    private final SelenideElement itemPrice = $x("//span[@class='goods__price']");
    private final SelenideElement addToCart = $x("//button[@data-category='Протеины']");
    private final SelenideElement cart = $x("(//div[@class='cart-min-desc']/span[@class='cart__icon'])[1]");


    public String getItemName() {
        return itemName.text();
    }

    public String getItemPrice() {
        return itemPrice.text();
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
