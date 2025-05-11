import com.codeborne.selenide.Condition;
import org.example.Praktikum.LoginPageMesto;
import org.example.Praktikum.ProfilePageMesto;
import org.junit.jupiter.api.Test;

public class TestProfilePageMesto {

    @Test
    public void logoutTest()  throws InterruptedException {

        var loginPageMesto = new LoginPageMesto();
        loginPageMesto.login("Toster@mail.ru","Toster123");

        var profilePageMesto = new ProfilePageMesto();
        profilePageMesto.waitCheckerElement();
        profilePageMesto.logout();
    }
}
