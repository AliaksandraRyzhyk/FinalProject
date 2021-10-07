package ui.sales;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.$x;

public class SalePage {
    private final SelenideElement saleButton = $x("(//a[@class='nav__link'])[8]");
    private final SelenideElement nameInput = $x("//input[@id='form_opt_FIELD_TITLE']");
    private final SelenideElement fieldActivities = $x("//select[@id='form_opt_FIELD_ACTIVITIES']");
    private final SelenideElement fieldActivitiesType = $x("//form[@id='form_opt']//option[@value='Фитнес-центр']");
    private final SelenideElement emailInput = $x("//input[@id='form_opt_FIELD_EMAIL']");
    private final SelenideElement submit = $x("//form[@id='form_opt']//button[@class='submit-button']");
    private final SelenideElement message = $x("(//div[@class='alert alert-success hidden'])[1]");

    private static Logger logger = Logger.getLogger(SalePage.class);

    @Step("Нажать на кнопку Оптовикам")
    public SalePage clickButton() {
        saleButton.click();
        logger.debug("Button 'Оптовикам' has been clicked");
        return this;
    }

    @Step("Ввести {0} в поле ФИО формы заявки")
    public SalePage nameInput(String text) {
        nameInput.val(text);
        logger.debug("Name " + text + " has been inputted");
        return this;
    }

    @Step("Нажать на выпадающий список направлений деятельности формы заявки")
    public SalePage selectFieldActivities() {
        fieldActivities.click();
        logger.debug("Dropdown has been clicked");
        return this;
    }

    @Step("Выбрать из выпадающего списка направлений деятельности Фитнес-центр")
    public SalePage selectFieldActivitiesType() {
        fieldActivitiesType.click();
        logger.debug("'Фитнес-центр' has been selected");
        return this;
    }

    @Step("Ввести {0} в поле email формы заявки")
    public SalePage emailInput(String text) {
        emailInput.val(text);
        logger.debug("Email " + text + " has been inputted");
        return this;
    }

    @Step("Нажать на кнопку Отправить запрос")
    public SalePage clickSubmit() {
        submit.click();
        logger.debug("Button 'Отправить запрос' has been clicked");
        return this;
    }

    @Step("Проверить видимость сообщения о некорректно внесенных данных")
    public Boolean messageIsNotVisible() {
        message.shouldNotBe(Condition.visible);
        logger.debug("Sale message hasn't been visible");
        return true;
    }
}
