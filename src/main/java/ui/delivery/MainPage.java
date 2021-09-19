package ui.delivery;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private final SelenideElement catalogButton = $x("(//a[@class='nav__link'])[1]");
    private final SelenideElement isotonicButton = $x("//a[text()='Изотоники']");
    private final SelenideElement item = $x("//div[@class='catalog']//a[@class='product__link']");

    public MainPage clickButton() {
        catalogButton.hover();
        return this;
    }

    public MainPage checkIsotonicButton() {
        isotonicButton.click();
        return this;
    }

    public ItemPage selectItem() {
        item.scrollIntoView(false).click();
        return page(ItemPage.class);
    }
}
