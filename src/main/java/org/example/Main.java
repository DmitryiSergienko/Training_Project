package org.example;

import org.example.Check.Test;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет мир!");

        Test test = new Test(23, "ADA");
        test.setName("DEAD");
        System.out.println(test); // Автоматически вызовется toString()
    }
}