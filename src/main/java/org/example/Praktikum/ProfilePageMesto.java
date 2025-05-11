package org.example.Praktikum;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class ProfilePageMesto extends AllPagesObjetcs{
    private SelenideElement emailField = $(".header__user");

    private SelenideElement logoutButton = $(".header__logout");

    public ProfilePageMesto(){
        this.checkerElement = logoutButton;
    }

    public boolean checkEmailField(){
        return emailField.isEnabled();
    }

    public boolean checkSignOutIsEnabled(){
        return logoutButton.isEnabled();
    }
    public void clickSignOutButton(){
        if(checkSignOutIsEnabled()){
            logoutButton.click();
        }
        else{
            System.out.println("Кнопка \"Выйти\" не найдена!");
        }
    }

    public void logout(){
        if (!checkEmailField()){
            System.out.println("Поле \"email\" не найдено!");
        }
        clickSignOutButton();
    }
}