package ui.filter;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private final SelenideElement catalogButton = $x("(//a[@class='nav__link'])[2]");
    private final SelenideElement brandButton = $x("//a[text()='Cellucor']");

    public MainPage clickButton() {
        catalogButton.hover();
        return this;
    }

    public ItemPage checkBrandButton() {
        brandButton.click();
        return page(ItemPage.class);
    }
}
