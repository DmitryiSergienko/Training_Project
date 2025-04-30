import org.example.Praktikum.SalaryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SalaryServiceTest {

    @Test
    public void shouldCalculateSalaryWhenUnderLimit() {
        SalaryService salaryService = new SalaryService();
        int actual = salaryService.calculateSalary(50_000);
        int expected = 2_500;
        String message = "Неверное значение";

        assertEquals(expected, actual, message);
    }

    @Test
    public void testSalaryOverLimit() {
        SalaryService salaryService = new SalaryService();
        int actual = salaryService.calculateSalary(1_100_000);
        int expected = 50_000;

        assertEquals(expected, actual);
    }

    @Test
    public void testSalaryEqualsLimit() {
        SalaryService salaryService = new SalaryService();
        int actual = salaryService.calculateSalary(1_000_000); // Примерно 50_000
        int expected = 50_000;

        assertEquals(expected, actual);
    }

    @Test
    public void testSalaryWithZeroSales() {
        SalaryService salaryService = new SalaryService();
        int actual = salaryService.calculateSalary(0);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    public void testSalaryWithNegativeSales() {
        SalaryService salaryService = new SalaryService();
        int actual = salaryService.calculateSalary(-100_000);
        int expected = 0; // Предполагается, что отрицательные продажи дают 0 зарплату

        assertNotEquals(expected, actual);
    }
}