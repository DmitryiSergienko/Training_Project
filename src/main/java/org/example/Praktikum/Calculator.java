package org.example.Praktikum;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("Cannot divide by zero");
        }
        return a / b;
    }
}