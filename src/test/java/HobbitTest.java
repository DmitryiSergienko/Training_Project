import org.example.Praktikum.HobbitsPriorityStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HobbitTest {
    HobbitsPriorityStatus hobbitsPriorityStatus = new HobbitsPriorityStatus();

    // добавьте аннотации
    @ParameterizedTest
    @MethodSource("testData")
    void testPriorityStatus(String hobbit, String priorityStatus) {  // передайте параметры из декоратора в функцию
        assertEquals(priorityStatus, hobbitsPriorityStatus.getStatus(hobbit));
    }

    // передайте параметры из метода в тест
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments("Фродо", "Platinum"),
                arguments("Сэм", "Gold"),
                arguments("Мэри", "Silver"),
                arguments("Пиппин", "Silver")
        );
    }

    @Test
    void testAddMilesAndCheckStatus(){
        String hobbit = "Голлум";
        hobbitsPriorityStatus.addNewHobbit(hobbit);
        hobbitsPriorityStatus.addMilesToHobbit(hobbit, 50);
        assertEquals("Classic" , hobbitsPriorityStatus.getStatus(hobbit));
    }

    // добавьте аннотации
    @ParameterizedTest
    @MethodSource("testData2")
    void testAddMilesAndCheckStatus(int miles, String priorityStatus) {  // допишите параметры функции
        // создайте нового хоббита в системе, добавьте ему мили и проверьте его статус
        String hobbit = "Голлум";
        hobbitsPriorityStatus.addNewHobbit(hobbit);
        hobbitsPriorityStatus.addMilesToHobbit(hobbit, miles);
        assertEquals(priorityStatus , hobbitsPriorityStatus.getStatus(hobbit));
    }

    // передайте параметры из метода в тест
    static Stream<Arguments> testData2() {
        return Stream.of(
                arguments(299, "Classic"),
                arguments(300, "Silver")
        );
    }
}