package ui.filter;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class ItemPage {
    private final SelenideElement proteinButton = $x("(//label[@class='checkbox__label'])[7]");
    private final SelenideElement number = $x("//span[text()='18']");

    public String getNumber() {
        return number.text();
    }


    public ItemPage clickProteinButton(){
        proteinButton.click();
        return this;
    }
}
