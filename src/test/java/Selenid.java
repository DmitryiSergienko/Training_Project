import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Selenid {

    @Test
    public void updateAvatar() {
        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");

        // выполни авторизацию
        $("#email").setValue("Toster@mail.ru");
        $("#password").setValue("Toster123");
        $(".auth-form__button").click();
        // кликни по изображению профиля
        $(byCssSelector(".profile__image")).click();
        // в поле ссылки на изображение введи ссылку
        $(byId("owner-avatar")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png");
        // сохрани новое изображение
        $(byXpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }
    // закрой браузер

    @Test
    public void addImageAndDelete() {

        // создайте драйвер для браузера Chrome
        // перейдите на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполните авторизацию
        $("#email").setValue("Toster@mail.ru");
        $("#password").setValue("Toster123");
        $(".auth-form__button").click();
        // кликните по кнопке добавления нового контента
        $(".profile__add-button").click();
        // в поле названия введите «Москва»
        $("[name = 'name']").setValue("Москва");
        // в поле ссылки на изображение введите ссылку
        $("[name = 'link']").setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        // сохраните контент
        $(byXpath(".//form[@name='new-card']/button[@type = 'submit']")).click();
        // удалите добавленную карточку, кликнув по кнопке удаления
        $(byXpath(".//button[@class = 'card__delete-button card__delete-button_visible']")).click();
    }

    @Test
    public void editProfile() {

        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $("#email").setValue("Toster@mail.ru");
        $("#password").setValue("Toster123");
        $(".auth-form__button").click();
        // кликни по кнопке редактирования профиля
        $(".profile__edit-button").click();
        // введи «Аристарх Сократович» в поле «Имя»
        $("#owner-name").setValue("Аристарх Сократович");
        // введи «Автор автотестов» в поле «Занятие»
        $("#owner-description").setValue("Автор автотестов");
        // сохрани изменения
        $(byXpath(".//form[@name='edit']/button[@type='submit' and text()='Сохранить']")).click();
    }

    @Test
    public void getTextCard() {

        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $("#email").setValue("Toster@mail.ru");
        $("#password").setValue("Toster123");
        $(".auth-form__button").click();
        // получи текст второй карточки и сохрани его в переменную cardText
        var cardText = $$(".places__item.card").get(1).find(".card__title").getText();
        System.out.println("cardText: " + cardText);
    }
}