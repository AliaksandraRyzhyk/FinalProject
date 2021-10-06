package ui.findItem;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ItemFindPage {
    private final SelenideElement itemName = $x("//h1[@class='goods__title']");
    private final SelenideElement itemPrice = $x("//span[@class='goods__price']");
    private final SelenideElement addToCart = $x("//button[@data-category='Протеины']");
    private final SelenideElement cart = $x("(//div[@class='cart-min-desc']/span[@class='cart__icon'])[1]");

    private static Logger logger = Logger.getLogger(ItemFindPage.class);

    @Step("Зафиксировать наименование товара")
    public String getItemName() {
        logger.info("ItemName has been received");
        return itemName.text();
    }

    @Step("Зафиксировать стоимость товара")
    public String getItemPrice() {
        logger.info("ItemPrice has been received");
        return itemPrice.text();
    }

    @Step("Нажать на кнопку В корзину")
    public ItemFindPage addToCart() {
        addToCart.scrollIntoView(false).click();
        logger.info("Button 'В корзину' has been inputted");
        return this;
    }

    @Step("Перейти в корзину товаров")
    public CartFindPage openCart() {
        cart.scrollIntoView(false).click();
        logger.info("Cart button has been clicked");
        return page(CartFindPage.class);
    }
}
