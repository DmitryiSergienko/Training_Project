package org.example.Praktikum;

// класс, описывающий человека
public class Person {
    // метод, который принимает в качестве аргумента возраст
    public boolean isAdult(int age) {
        int adultAge = 18; // установим возраст совершеннолетия, с которым будем сравнивать
        return age >= adultAge; // вернём результат 
    }

    public char getFirstLetter(String name){
        return name.charAt(0);
    }
}