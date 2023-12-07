package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CallbackTest {

    @Test
    void shouldTestWithValidFirstSurnameSecondName() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Тайлакова Ольга");
        form.$("[data-test-id=phone] input").setValue("+79537924254");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldTestWithValidFirstNameSecondSurname() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольга Тайлакова");
        form.$("[data-test-id=phone] input").setValue("+79988778899");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldTestWithhoutName() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("");
        form.$("[data-test-id=phone] input").setValue("+79537924254");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
        //  String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //   assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestWithEmptyPhone() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольга Тайлакова");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
        // String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //  assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestWithCheckbox() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольга Тайлакова");
        form.$("[data-test-id=phone] input").setValue("+79537924254");
        form.$(By.className("button")).click();
        // String textColor = $(By.className("checkbox__text")).getCssValue("color");
        //assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestWithLatinName() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Olga Tailakova");
        form.$("[data-test-id=phone] input").setValue("+79537924254");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
        // String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        // assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestNumerWithName() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("1111111111");
        form.$("[data-test-id=phone] input").setValue("+79537924254");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
        // String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //   assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestWithNameWithSpecialSymbol() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольг@ Тайлаков@");
        form.$("[data-test-id=phone] input").setValue("+79537924254");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
        // String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //  assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestWithOnlyName() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольга");
        form.$("[data-test-id=phone] input").setValue("+79537924254");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
        //   String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //  assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestWithSpacesInPhoneNumber() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольга Тайлакова");
        form.$("[data-test-id=phone] input").setValue("+7 953 792 42 54");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
        //  String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //  assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestWithDashInPhoneNumber() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольга Тайлакова");
        form.$("[data-test-id=phone] input").setValue("+7-953-792-42-54");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
        //String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //     assertEquals("rgba(255, 92, 92, 1)", textColor);
    }

    @Test
    void shouldTestIfPhoneNumberInLatin() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(By.className("form"));
        form.$("[data-test-id=name] input").setValue("Ольга Тайлакова");
        form.$("[data-test-id=phone] input").setValue("xxxxxxxxxx");
        form.$("[data-test-id=agreement]").click();
        form.$(By.className("button")).click();
        $(By.className("input_invalid")).find(".input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
        //  String textColor = $(By.className("input_invalid")).find(".input__sub").getCssValue("color");
        //   assertEquals("rgba(255, 92, 92, 1)", textColor);
    }
}

