import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

public class BaseTest {

    protected static WebDriver driver; // Драйвер доступен в дочерних классах

    @BeforeAll
    public static void setUp() {
        // Настройка опций для Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--no-sandbox",
                //"--headless", //Отвечает за старт браузера - запускает без браузера
                "--disable-dev-shm-usage");

        // Инициализация драйвера
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void teardown() {
        // Закрытие браузера после выполнения теста
        if (driver != null) {
            driver.quit();
        }
    }
}