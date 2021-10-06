package ui.findItem;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.*;

public class MainFindPage {
    private final SelenideElement searchStart = $x("//input[@class='search__input']");
    private final SelenideElement buttonSearch = $x("//button[@class='search__submit']");
    private final ElementsCollection elementProduct = $$x("//h3");

    private static Logger logger = Logger.getLogger(MainFindPage.class);

    @Step("Ввести в поисковую строку {0}")
    public MainFindPage enterText(String text) {
        searchStart.setValue(text);
        logger.debug("Text " + text + " has been inputted");
        return this;
    }

    @Step("Нажать на кнопку поиска товара")
    public MainFindPage clickButtonSearch() {
        buttonSearch.click();
        logger.debug("Search button has been clicked");
        return this;
    }

    @Step("Нажать на товар с наименованием {0}")
    public ItemFindPage selectItem(String text) {
        elementProduct.find(Condition.text(text)).scrollIntoView(false).click();
        logger.debug("Text " + text + " has been selected");
        return page(ItemFindPage.class);
    }
}
