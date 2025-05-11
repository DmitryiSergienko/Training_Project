package org.example.Praktikum;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter
public class LoginPageMesto extends AllPagesObjetcs{

    // локатор поля ввода «Email»
    private SelenideElement emailField;
    // локатор поля «Пароль»
    private SelenideElement passwordField;
    // локатор кнопки входа в приложение
    private SelenideElement signInButton;
    // добавьте здесь локатор для кнопки «Регистрация»
    private SelenideElement registrationButton;

    public LoginPageMesto(){
        open("https://qa-mesto.praktikum-services.ru/signin");
        this.emailField = $("#email");
        this.passwordField = $("#password");
        this.signInButton = $(".auth-form__button");
        this.registrationButton = $(".header__auth-link");
        this.checkerElement = $(".logo header__logo");
    }
    // метод проверяет, активна ли кнопка «Войти»
    public boolean checkSignInIsEnabled() {
        return signInButton.isEnabled();
    }
    // метод кликает по кнопке «Войти»
    public void clickSignInButton() {
        if(checkSignInIsEnabled()){
            signInButton.click();
        }
        else {
            System.out.println("Кнопка \"Войти\" не найдена!");
        }
    }
    // метод кликает по кнопке «Регистрация»
    public void clickRegistrationButton() {
        registrationButton.click();
    }
    // метод проверяет текст кнопки «Регистрация»
    public void checkTextRegistrationButton() {
        assertEquals("Регистрация", registrationButton.getText(), "Текст не верный!");
    }

    public void login(String email, String password){
        var loginPageMesto = new LoginPageMesto();
        emailField.setValue(email);
        passwordField.setValue(password);
        clickSignInButton();
    }
}