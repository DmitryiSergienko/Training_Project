import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Test;

public class MestoAuthorizationWindow extends BaseTest {
    @BeforeEach
    void openDriver(){
        // Открываем страницу
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @Test
    public void test() {
        // Проверяем наличие заголовка
        String name = driver.findElement(By.cssSelector(".auth-form__title")).getText();

        Assertions.assertEquals("Вход", name, "Текст не соответствует заголовку");
    }
}