import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class MestoMainWindow extends BaseTest {
    @BeforeEach
    void openDriver(){
        driver.get("https://qa-mesto.praktikum-services.ru/"); // Открываем страницу

        WebElement loginField = driver.findElement(By.id("email")); // Определяем поле для ввода логина
        WebElement passwordField = driver.findElement(By.id("password")); // Определяем поле для ввода пароля

        String login = "Toster@mail.ru"; // Вводим логин
        loginField.sendKeys(login);
        String password = "Toster123"; // Вводим пароль
        passwordField.sendKeys(password);

        String enteredText = loginField.getAttribute("value"); // Проверяем, что текст в поле соответствует введенному логину
        Assertions.assertEquals(login, enteredText, "Введенный логин не соответствует ожидаемому.");
        enteredText = passwordField.getAttribute("value"); // Проверяем, что текст в поле соответствует введенному паролю
        Assertions.assertEquals(password, enteredText, "Введенный пароль не соответствует ожидаемому.");

        WebElement enterButton = driver.findElement(By.cssSelector(".auth-form__button")); // Определяем кнопку для входа
        enterButton.click(); // Кликаем по кнопке входа
    }

    @Test
    public void outButton() { //Проверка на наличие кнопки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'header__logout')]")));

        String textOutButton = button.getText().trim();
        Assertions.assertEquals("Выйти", textOutButton, "Текст кнопки не соответствует!");
    }

    @Test
    public void allButton() { //Проверка на наличие кнопки
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> buttons = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button")));

        System.out.println(buttons.size());
        for (WebElement button : buttons) {
            System.out.println(button.getText().trim());
        }

        String textOutButton = buttons.getFirst().getText().trim();
        Assertions.assertEquals("Войти", textOutButton, "Текст кнопки не соответствует!");
    }

    @Test // Первое задание Практикума
    public void imageProfile() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        // Кликни по изображению профиля
        driver.findElement(By.cssSelector(".profile__image")).click();
        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.id("owner-avatar")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png");
        // Сохрани новое изображение
        driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }

    @Test //Второе задание Практикума
    public void createImage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        // Кликни по кнопке добавления нового контента
        driver.findElement(By.cssSelector(".profile__add-button")).click();
        // В поле названия введи «Прага»
        driver.findElement(By.name("name")).sendKeys("Прага");
        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.name("link")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/new_photo_selenium.jpg");
        // Сохрани контент
        driver.findElement(By.xpath("//form[@name='new-card']/button[text()='Сохранить']")).click();
        // Дождись появления кнопки удаления карточки
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")));
        // Удали контент
        driver.findElement(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }

    @Test // Третье задание Практикума
    public void scroll() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("places__list")));
        // Найди карточку контента и сделай скролл до неё
        WebElement element = driver.findElement(By.cssSelector(".places__item"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }
}