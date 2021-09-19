package ui.promo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    private final SelenideElement inputPromo = $x("//input[@class='coupon_value']");
    private final SelenideElement submit = $x("//input[@type='submit']");
    private final SelenideElement result = $x("//div[@class='cart_promo_text_err']");

    public String getResult() {
        return result.text();
    }

    public CartPage enterText(String text) {
        inputPromo.scrollIntoView(false).setValue(text);
        return this;
    }

    public CartPage submit() {
        submit.click();
        return this;
    }

}
