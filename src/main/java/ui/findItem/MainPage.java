package ui.findItem;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement searchStart = $x("//input[@class='search__input']");
    private final SelenideElement buttonSearch = $x("//button[@class='search__submit']");
    private final ElementsCollection elementSportChocolate = $$x("//h3");


    public MainPage enterText(String text) {
        searchStart.setValue(text);
        buttonSearch.click();
        return this;
    }

    public ItemPage selectItem(String text) {
        elementSportChocolate.find(Condition.text(text)).scrollIntoView(false).click();
        return page(ItemPage.class);
    }


}
