package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {
    @Test(priority = 1, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустым значением в поле First Name", testName = "регистрация с пустым значением в поле First Name",
            retryAnalyzer = Retry.class)
    public void negativeFirstNameFieldIsEmpty() {
        registerPage.createAccount("",
                "adsgdag",
                "gsdsd@mail.com",
                "(GMT+04:00) Moscow, St. Petersburg, Volgograd",
                "ZQ$!$5K9BsXF6j4",
                "ZQ$!$5K9BsXF6j4");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorFirst(),
                "This field is required.",
                "Сообщение об ошибке отсутствует");
    }

    @Test(priority = 2, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустым значением в поле Last Name", testName = "регистрация с пустым значением в поле Last Name",
            retryAnalyzer = Retry.class)
    public void negativeLastNameFieldIsEmpty() {
        registerPage.createAccount("sdfsdf",
                "",
                "gsdsd@mail.com",
                "(GMT+04:00) Moscow, St. Petersburg, Volgograd",
                "ZQ$!$5K9BsXF6j4",
                "ZQ$!$5K9BsXF6j4");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorLast(),
                "This field is required.",
                "Сообщение об ошибке отсутствует");
    }

    @Test(priority = 3, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустым значением в поле Email", testName = "регистрация с пустым значением в поле Email",
            retryAnalyzer = Retry.class)
    public void negativeEmailFieldIsEmpty() {
        registerPage.createAccount("asdfa",
                "lastadgdsg",
                "",
                "(GMT+04:00) Moscow, St. Petersburg, Volgograd",
                "ZQ$!$5K9BsXF6j4",
                "ZQ$!$5K9BsXF6j4");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorEmail(),
                "This field is required.",
                "Сообщение об ошибке отсутствует");
    }

    @Test(priority = 4, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с не валидным значением в полем Email", testName = "регистрация с не валидным значением в полем Email",
            retryAnalyzer = Retry.class)
    public void negativeEmailFieldIsNotValid() {
        registerPage.createAccount("asdfa",
                "lastadgdsg",
                "wregewrg",
                "(GMT+04:00) Moscow, St. Petersburg, Volgograd",
                "ZQ$!$5K9BsXF6j4",
                "ZQ$!$5K9BsXF6j4");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorEmail(),
                "Please enter a valid email address.",
                "Сообщение об ошибке отсутствует");
    }

    @Test(priority = 5, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустым значением в полем Time Zone", testName = "регистрация с пустым значением в полем Time Zone",
            retryAnalyzer = Retry.class)
    public void negativeTimeZoneFieldIsEmpty() {
        registerPage.createAccount("asdfa",
                "lastadgdsg",
                "wregewrg@mail.com",
                "Select...",
                "ZQ$!$5K9BsXF6j4",
                "ZQ$!$5K9BsXF6j4");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorTime(),
                "This field is required.",
                "Сообщение об ошибке отсутствует");
    }

    @Test(priority = 6, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с пустыми значениями в полях Password", testName = "регистрация с пустыми значениями в полях Password",
            retryAnalyzer = Retry.class)
    public void negativePasswordFieldsIsEmpty() {
        registerPage.createAccount("asdfa",
                "lastadgdsg",
                "wregewrg@mail.com",
                "(GMT+04:00) Moscow, St. Petersburg, Volgograd",
                "",
                "");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorPassNull(),
                "This field is required.",
                "Сообщение об ошибке отсутствует");
    }

    @Test(priority = 7, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с не валидным паролем", testName = "регистрация с не валидным паролем",
            retryAnalyzer = Retry.class)
    public void negativePasswordFieldsIsNotValid() {
        registerPage.createAccount("asdfa",
                "lastadgdsg",
                "wregewrg@mail.com",
                "(GMT+04:00) Moscow, St. Petersburg, Volgograd",
                "123",
                "123");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorPass(),
                "Error: *Please enter a Password value with at least one number, lower-case letter, and upper-case letter between 7 and 15 characters in length.",
                "Сообщение об ошибке отсутствует");
    }

    @Test(priority = 8, enabled = true, invocationCount = 1, threadPoolSize = 2,
            description = "регистрация с не совпадающими паролями", testName = "регистрация с не совпадающими паролями",
            retryAnalyzer = Retry.class)
    public void negativePasswordFieldsIsNotMatch() {
        registerPage.createAccount("asdfa",
                "lastadgdsg",
                "wregewrg@mail.com",
                "(GMT+04:00) Moscow, St. Petersburg, Volgograd",
                "ZQ$!$5K9BsXF6j4",
                "ZQ$!$5K9BsXF6j5");
        RegisterPage.CreateNewAccountButtonClick();
        Assert.assertEquals(registerPage.errorPass(),
                "Error: The passwords you entered did not match.",
                "Сообщение об ошибке отсутствует");
    }
}

