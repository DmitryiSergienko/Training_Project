import org.example.Praktikum.LoginPageMesto;
import org.junit.jupiter.api.Test;

public class TestLoginPageMesto {

    @Test
    public void loginTest() {

        var loginPageMesto = new LoginPageMesto();
        loginPageMesto.login("Toster@mail.ru","Toster123");
    }
}