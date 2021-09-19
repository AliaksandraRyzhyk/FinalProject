package ui.findItem;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private SelenideElement cartItemName = $x("//div[@class='cart_info']");
    private SelenideElement cartItemPrice = $x("//div[@class='cart_p']");
}

