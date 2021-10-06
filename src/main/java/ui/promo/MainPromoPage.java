package ui.promo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPromoPage {
    private final SelenideElement goal = $x("(//a[@class='nav__link'])[3]");
    private final SelenideElement treatment = $x("//a[text()='Лечение судорог']");
    private final SelenideElement item = $x("//img[@class='product__img']");

    private static Logger logger = Logger.getLogger(MainPromoPage.class);

    @Step("Навести курсор на кнопку Цели")
    public MainPromoPage hoverOverGoal() {
        goal.hover();
        logger.debug("Button 'Цели' has been selected");
        return this;
    }

    @Step("Нажать на ссылку Лечение судорог")
    public MainPromoPage checkTreatment() {
        treatment.click();
        logger.debug("Link 'Лечение судорог' has been clicked");
        return this;
    }

    @Step("Нажать на товар в разделе Лечение судорог")
    public ItemPromoPage selectItem() {
        item.click();
        logger.debug("Item has been clicked in catalog 'Лечение судорог'");
        return page(ItemPromoPage.class);
    }

}
