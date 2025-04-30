import org.example.Praktikum.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(calculator.add(2, 3), 5);
    }

    @Test
    void testSubtract() {
        assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test
    void  testMultiply() {
        assertEquals(calculator.multiply(2, 3),6);
    }

    @Test
    void  testDivide() throws Exception {
        assertEquals(calculator.divide(10, 2),5);
    }
    @Test
    void  testDivideZero() {
        assertThrows(Exception.class,() -> calculator.divide(10, 0));
    }
}