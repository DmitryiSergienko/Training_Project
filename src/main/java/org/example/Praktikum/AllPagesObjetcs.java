package org.example.Praktikum;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public abstract class AllPagesObjetcs {
    protected SelenideElement checkerElement;

    public void waitCheckerElement(){
        checkerElement.shouldBe(Condition.visible);
    }
}
