package org.example;

import org.example.Check.Test;
import org.example.Praktikum.User;
import org.example.Praktikum.UserProcessor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет мир!");

        Test test = new Test(23, "ADA");
        test.setName("DEAD");
        System.out.println(test); // Автоматически вызовется toString()

        Test responseBody = new Test(23,"LLL");
        int ID = responseBody.age;
        Test env = new Test();
        env.setAge(ID);

        int AGE;
        try{
            Test responseBody2 = new Test();
            if (responseBody2.age == 0) {
                // Если условие не выполняется, выбрасываем исключение
                throw new IllegalArgumentException("Поле age пустое!");
            }
            AGE = responseBody2.age;
            System.out.println("Средний возраст по палате: " + AGE);
        }
        catch(IllegalArgumentException e){
            System.err.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Чирик!");

        int numerator = 10; // Числитель
        int denominator = 0; // Знаменатель (будет равен 0 для демонстрации исключения)

        try {
            // Попытка выполнить деление
            int result = divide(numerator, denominator);
            System.out.println("Результат деления: " + result);

        } catch (ArithmeticException e) {
            // Обработка исключения ArithmeticException (деление на ноль)
            System.err.println("Ошибка: Деление на ноль недопустимо!");

        } catch (Exception e) {
            // Обработка других возможных исключений
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());

        } finally {
            // Блок finally выполняется всегда
            System.out.println("Блок finally выполнен. Это полезно для завершающих действий.");
        }

        System.out.println("Программа продолжает работу...");

        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", 25));
        users.add(new User(2, "Alice", 30));
        users.add(new User(3, "Bob", 22));

        UserProcessor.processUsers(users, user -> System.out.println("User: " + user.getName() + ", Age: " + user.getAge()));
    }

    // Метод для деления двух чисел
    public static int divide(int a, int b) {
        if (b == 0) {
            // Можно явно выбросить исключение, если нужно
            throw new ArithmeticException("Деление на ноль!");
        }
        return a / b;
    }
}