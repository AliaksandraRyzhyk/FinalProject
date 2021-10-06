package ui.filter;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainFilterPage {
    private final SelenideElement catalogButton = $x("(//a[@class='nav__link'])[2]");
    private final SelenideElement brandButton = $x("//a[text()='IronMaxx']");

    private static Logger logger = Logger.getLogger(MainFilterPage.class);

    @Step("Навести курсор на кнопку Бренды")
    public MainFilterPage clickButton() {
        catalogButton.hover();
        logger.debug("Button 'Бренды' has been selected");
        return this;
    }

    @Step("Нажать на кнопку бренда IronMaxx")
    public ItemFilterPage checkBrandButton() {
        brandButton.click();
        logger.debug("Button 'IronMaxx' has been clicked");
        return page(ItemFilterPage.class);
    }
}
