package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class RegisterPage {

    SelenideElement firstNameField = $(By.id("create_first"));
    SelenideElement lastNameField = $(By.id("create_last"));
    SelenideElement emailAddressField = $(By.id("create_email"));
    SelenideElement timeZoneField = $(By.id("create_timezone"));
    SelenideElement password1Field = $(By.id("password_meter"));
    SelenideElement password2Field = $(By.id("create_passwordmatch"));
    static SelenideElement createNewAccountButton = $(By.xpath("//*[@id='register-validate']/div[2]/button"));
    SelenideElement errorFirstName = $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[1]/td[1]/label[2]"));
    SelenideElement errorLastName = $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[1]/td[2]/label[2]"));
    SelenideElement errorEmailAddress = $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[2]/td/label[2]"));
    SelenideElement errorTimeZone = $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[3]/td/label[2]"));
    SelenideElement errorPasswordNull = $(By.xpath("//*[@id='register-validate']/div[1]/table/tbody/tr[4]/td/label[2]"));
    SelenideElement errorPassword = $(By.xpath("//*[@class='alert alert-error']"));

    @Step("Ввод данных для регистрации")
    public void createAccount(String firstName, String lastName,
                              String email, String timeZone, String password1,
                              String password2) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailAddressField.sendKeys(email);
        timeZoneField.click();
        timeZoneField.find(withText(timeZone)).click();
        password1Field.sendKeys(password1);
        password2Field.sendKeys(password2);
    }

    @Step("Нажатие кнопки для создания аккаунта")
    public static void CreateNewAccountButtonClick() {
        createNewAccountButton.click();
    }

    @Step("Проверка сообщения об ощибке в поле First Name")
    public String errorFirst() {
        return errorFirstName.getText();
    }

    @Step("Проверка сообщения об ощибке в поле Last Name")
    public String errorLast() {
        return errorLastName.getText();
    }

    @Step("Проверка сообщения об ощибке в поле Email Address")
    public String errorEmail() {
        return errorEmailAddress.getText();
    }

    @Step("Проверка сообщения об ощибке в поле Time Zone")
    public String errorTime() {
        return errorTimeZone.getText();
    }

    @Step("Проверка сообщения об ощибке в поле Password")
    public String errorPassNull() {
        return errorPasswordNull.getText();
    }

    @Step("Проверка сообщения об ощибке в поле Password")
    public String errorPass() {
        return errorPassword.getText();
    }
}
