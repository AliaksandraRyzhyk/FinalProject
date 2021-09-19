package ui.promo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement goal = $x("(//a[@class='nav__link'])[3]");
    private final SelenideElement treatment = $x("//a[text()='Лечение судорог']");
    private final SelenideElement item = $x("//img[@class='product__img']");


    public MainPage hoverOverGoal() {
        goal.hover();
        return this;
    }

    public MainPage checkTreatment() {
        treatment.click();
        return this;
    }

    public ItemPage selectItem() {
        item.click();
        return page(ItemPage.class);
    }

}
