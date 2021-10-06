package ui.delivery;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainDeliveryPage {
    private final SelenideElement catalogButton = $x("(//a[@class='nav__link'])[1]");
    private final SelenideElement isotonicButton = $x("//a[text()='Изотоники']");
    private final SelenideElement item = $x("//div[@class='catalog']//a[@class='product__link']");

    private static Logger logger = Logger.getLogger(MainDeliveryPage.class);

    @Step("Навести курсор на кнопку Каталог")
    public MainDeliveryPage clickButton() {
        catalogButton.hover();
        logger.debug("Button 'Каталог' has been selected");
        return this;
    }

    @Step("Нажать на ссылку Изотоники")
    public MainDeliveryPage checkIsotonicButton() {
        isotonicButton.click();
        logger.debug("Link 'Изотоники' has been clicked");
        return this;
    }

    @Step("Выбрать товар на разделе Изотоники")
    public ItemDeliveryPage selectItem() {
        item.scrollIntoView(false).click();
        logger.debug("Item has been clicked in catalog 'Изотоники'");
        return page(ItemDeliveryPage.class);
    }
}
