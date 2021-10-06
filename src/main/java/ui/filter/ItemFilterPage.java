package ui.filter;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class ItemFilterPage {
    private final SelenideElement proteinButton = $x("(//label[@class='checkbox__label'])[1]");
    private final SelenideElement number = $x("//span[text()='7']");

    private static Logger logger = Logger.getLogger(ItemFilterPage.class);

    @Step("Нажать на категорию Протеины")
    public ItemFilterPage clickProteinButton(){
        proteinButton.click();
        logger.debug("Button 'Протеины' has been selected");
        return this;
    }

    @Step("Определить количество найденных товаров")
    public String getNumber() {
        logger.info("Number of items has been determined by filtration");
        return number.text();
    }
}
