package ui.sales;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement saleButton = $x("(//a[@class='nav__link'])[8]");
    private final SelenideElement nameInput = $x("//input[@id='form_opt_FIELD_TITLE']");
    private final SelenideElement fieldActivities = $x("//select[@id='form_opt_FIELD_ACTIVITIES']");
    private final SelenideElement fieldActivitiesType = $x("//form[@id='form_opt']//option[@value='Фитнес-центр']");
    private final SelenideElement emailInput = $x("//input[@id='form_opt_FIELD_EMAIL']");
    private final SelenideElement submit = $x("//form[@id='form_opt']//button[@class='submit-button']");
    private final SelenideElement message = $x("(//div[@class='alert alert-success hidden'])[1]");

    public MainPage clickButton() {
        saleButton.click();
        return this;
    }

    public MainPage nameInput(String text) {
        nameInput.val(text);
        return this;
    }

    public MainPage selectFieldActivities() {
        fieldActivities.click();
        return this;
    }

    public MainPage selectFieldActivitiesType() {
        fieldActivitiesType.click();
        return this;
    }

    public MainPage emailInput(String text) {
        emailInput.val(text);
        return this;
    }

    public MainPage clickSubmit() {
        submit.click();
        return this;
    }

    public Boolean messageIsNotVisible() {
        message.shouldNotBe(Condition.visible);
        return true;
    }
}
