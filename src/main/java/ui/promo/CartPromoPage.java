package ui.promo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class CartPromoPage {
    private final SelenideElement inputPromo = $x("//input[@class='coupon_value']");
    private final SelenideElement submit = $x("//input[@type='submit']");
    private final SelenideElement result = $x("//div[@class='cart_promo_text_err']");

    private static Logger logger = Logger.getLogger(CartPromoPage.class);

    @Step("Ввести {0} в строку введения промода")
    public CartPromoPage enterText(String text) {
        inputPromo.scrollIntoView(false).setValue(text);
        logger.debug("Text " + text + "has been inputted");
        return this;
    }

    @Step("Нажать на кнопку Применить")
    public CartPromoPage submit() {
        submit.click();
        logger.debug("Button 'Применить' has been clicked");
        return this;
    }

    @Step("Зафиксировать полученный результат")
    public String getResult() {
        logger.debug("Result has been received");
        return result.text();
    }
}
