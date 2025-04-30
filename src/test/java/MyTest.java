import org.example.Praktikum.Person;

import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Praktikum.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyTest {

    @Test
    void check(){
        assertTrue(true);
    }

    @Test
    public void isAdultWhenAgeIsMoreThan18True() {
        Person person = new Person();
        int age = 20;
        boolean actualResult = person.isAdult(age);
        // проверка результата actualResult с помощью assertTrue;
        // если actualResult — true, тест пройден успешно
        assertTrue(actualResult, "Person's age is equal to or more than 18");
    }

    @Test
    public void isAdultWhenAgeIsMoreThan25True() {
        int age = 25; // зададим самостоятельно переменную, при помощи которой
        // получим результат из метода isAdult()
        boolean actualResult = (new Person()).isAdult(age); // передадим эту переменную в метод
        boolean expectedResult = true;
        System.out.println("Результат выполнения теста:");
        System.out.println(actualResult == expectedResult);
    }

    @Test
    public void getFirstLetterWhenNameIsRussianReturnsFirstLetter() {
        Person person = new Person();
        String name = "Вася";
        char expectedResult = 'В';
        char actualResult = person.getFirstLetter(name);
        assertEquals(expectedResult, actualResult);
    }

    //Примеры ассертов
    @Test
    public void shouldBeTwoNumbersEqual(){
        int expected = 4;  // ожидаемое значение
        int actual = 4;  // фактическое значение
        assertEquals(expected, actual);  // проверяет равенство чисел через метод assertEquals
    }

    @Test
    public void shouldBeTwoDoubleEqual(){
        double expected = 180.00;  // ожидаемый результат
        double actual = 180.04;  // фактический результат
        assertEquals(expected, actual, 0.05);  // такое сравнение пройдёт без ошибок,
        // потому что разница между значениями не превышает delta = 0.05
    }

    @Test
    public void shouldBeTwoStringsEqual(){
        String expected = "Её глаза на звезды не похожи";
        String actual = "Нельзя уста кораллами назвать";
        assertEquals(expected, actual);  // метод выдаст ошибку
    }

    @Test
    public void shouldBeNotTwoStringsEqual(){
        String unexpected = "Не знаю я, как шествуют богини";
        String actual = "Но милая ступает по земле";
        assertNotEquals(unexpected, actual);  // метод выполнится успешно, т.к. ожидает,
        // что строки unexpected и actual отличаются
    }

    @Test
    public void shouldBeNotTwoStringsEqualArrow(){
        char[] expected = {'T','e','s','t'};
        char[] actual = "Test".toCharArray();

        assertArrayEquals(expected, actual); // метод выполнится успешно, т.к. ожидает,
        // что массивы идентичны
    }

    @Test
    public void shouldBeTwoStringsEqualText(){
        String expected = "Пароли должны совпадать";  // ожидаемое сообщение о несовпадении паролей
        String actual = "Что-то пошло не так"; // фактическое сообщение
        assertEquals(expected, actual, "Неверный текст ошибки!"); // добавили сообщение об ошибке
    }

    @Test
    public void shouldBeNotEqualCelsiusAndFahrenheit() {
        double celsius = 36;
        double fahrenheit = 5 / 9 * (celsius - 32);

        assertNotEquals(celsius, fahrenheit, "Результат расчёта должен отличаться");
    }

    @Test
    public void shouldBeTwoBooleansEqual(){
        boolean a = 9 != 10;
        boolean b = 10 > 11;
        assertEquals(String.valueOf(a), b, "Результат расчёта должен отличаться");
    }

    @Test
    public void shouldBeTrue() {
        int first = 4;  // значение 1
        int second = 4;  // значение 2
        assertTrue(first - second == 0);
    }

    @Test
    public void shouldBeFalse() {
        int first = 4;  // значение 1
        int second = 3;  // значение 2
        assertFalse(first - second == 0);
    }

    @Test
    public void shouldBeNull() {
        Object expected = null ;  // добавьте значение
        assertNull(expected);
    }

    @Test
    public void shouldBeNotNull() {
        String expected = "Текст";  // добавьте значение
        assertNotNull(expected);
    }

    @Test
    public void mainPageOpenedTest() {
        open("https://qa-scooter.praktikum-services.ru/");

        var orderButtons = $$(".Button_Button__ra12g");
        var logoElement = $(".Header_Logo__23yGT");
        var questionsList = $(".Home_FAQ__3uVm4");

        assertAll(
                () -> assertTrue(logoElement.isDisplayed()),
                () -> assertTrue(orderButtons.get(0).isDisplayed()),
                () -> assertTrue(orderButtons.get(2).isDisplayed()),
                () -> assertTrue(questionsList.isDisplayed())
        );
    }

    @Test
    public void isEvenTest() {
        assertAll("Should check if number is even",
                () -> assertFalse(isEven(1)),
                () -> assertTrue(isEven(1)),
                () -> assertFalse(isEven(0))
        );
    }

    boolean isEven(int num){
        return num % 2 == 0;
    }

    @Test
    public void pointTest() {
        Point point  = new Point(15, 20);
        point.update(30, 14);
        assertAll(()-> assertEquals(30.0, point.getX()),
                ()-> assertEquals(14.0, point.getY())
        );
    }

    @Test
    public void shouldThrowNullPointerException1(){
        String str = null;
        assertThrows(NullPointerException.class, () -> str.length());  // проверяет, что метод выбросит NullPointerException
    }

    @Test
    public void shouldThrowNullPointerException2(){
        String str = null;
        Exception exception =  assertThrows(NullPointerException.class, () -> str.length());  // проверяет, что метод выбросит NullPointerException
        assertEquals("Cannot invoke \"String.length()\" because \"str\" is null", exception.getMessage());
    }

    @Test
    public void shouldNotThrowException1(){
        String str = "Текст";
        assertDoesNotThrow(() -> {
            str.length();
        });
    }

    @Test
    public void shouldNotThrowException2(){
        String str = null;
        assertDoesNotThrow(() -> {
            str.length();
        });
    }

    @Test
    public void shouldThrowOutOfIndexException(){
        List<String> strList = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> strList.get(0));
    }

    @Test
    public void shouldNotThrowException() {
        String str = "Same";
        assertDoesNotThrow(() -> {
            if (!str.equals("Same")){
                assertFalse(true);
            }
        });
    }

    @Test
    public void shouldPassTimeoutAssert(){
        assertTimeout(ofSeconds(1), () -> System.out.println("Текст"));
    }

    @Test
    public void shouldFailTimeoutAssert(){
        assertTimeout(ofSeconds(1), () -> {
            Thread.sleep(1000);
            System.out.println("Текст");
        });
    }

    @Test
    public void shouldPassInstanceOf(){
        assertInstanceOf(String.class,"1");
    }

    @Test
    public void shouldNotPassInstanceOf(){
        assertInstanceOf(Integer.class,"1");
    }

    @Test
    public void assertThatTest1(){
        assertThat(10).isGreaterThan(5);
    }

    @Test
    public void assertThatTest2(){
        assertThat(2).withFailMessage("Это будет выведено, когда проверка не сработает").isGreaterThan(5);
    }

    @Test
    public void assertThatTest3(){
        String lifeIsGood = "Life is good";
        String good = "good";
        assertThat(lifeIsGood).endsWith(good); // ends with - «заканчивается»
    }

    @Test
    public void assertMatherTest1(){
        String actual = "Java";
        String expected = "va";
        assertThat(actual).contains(expected);
    }

    @Test
    public void testChecksContainsPattern() {
        String actual = "Java";
        String expected = "J*";
        assertThat(actual).containsPattern(expected);
    }

    @Test
    public void testChecksStartsWith() {
        String actual = "Java";
        String expected = "J";
        assertThat(actual).startsWith(expected);
    }

    @Test
    public void testChecksEndsWith() {
        String actual = "Java";
        String expected = "a";
        assertThat(actual).endsWith(expected);
    }

    @Test
    public void testChecksContains() {
        String actual = "Java";
        String expected = "a";
        String expected2 = "v";
        assertThat(actual).contains(expected,expected2);
    }

    @Test
    public void testChecksAnyOf() {
        String actual = "Java";
        String expected = "a";
        String expected2 = "a";
        assertThat(actual).containsAnyOf(expected,expected2);
    }

    @Test
    public void testChecksIsStrictlyBetween() {
        String actual = "Java";
        String expected = "J";
        String expected2 = "a";
        assertThat(actual).isStrictlyBetween(expected,expected2);
    }

    @Test
    public void testChecksIsStrictlyBetween2() {
        String actual = "Java";
        assertThat(actual).isNotNull().startsWith("J");
    }

    @Test
    public void testChecksIsNotNull() {
        String actual = "asf";
        assertThat(actual).isNotNull();
    }

    @Test
    public void testChecksPositoveAndNegative() {
        int actualPositive = 10;
        int actualNegative = -10;
        assertThat(actualPositive).isPositive();
        assertThat(actualNegative).isNegative();
    }

    @Test
    public void testJavaAutomation() {
        String wholeSentence = "I will be a great test automation engineer";
        String iWill = "I will";
        String automationEngineer = "automation engineer";
        assertThat(wholeSentence).startsWith(iWill).endsWith(automationEngineer);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 7})
    public void parameterMethod(int number) {
        System.out.println("Number: " + number);
        assertInstanceOf(Integer.class, number);
    }

    public static Stream<Arguments> isEvenData() {
        return Stream.of( //метод передаёт данные
                arguments(-5, false),
                arguments(1, false),
                arguments(0, true),
                arguments(5, false)
        );
    }

    @ParameterizedTest
    @MethodSource("isEvenData")
    public void isEvenForSomeValuesIsValid(int value, boolean result) { //тестовый метод
        assertEquals(result, isEven(value));
    }

    @ParameterizedTest
    @CsvSource({
            "-1, false",
            "0, false",
            "17, false",
            "18, true",
            "19, true",
            "25, true"
    })
    public void isAdultForBoundaryValuesIsValid(int age, boolean result) {
        assertEquals(result, isAdult(age));
    }

    public boolean isAdult(int value) {
        return value % 2 == 0;
    }

    @ParameterizedTest
    @CsvSource({
            "-5, false",
            "0, true",
            "1, false",
            "5, false"
    })
    public void isEvenForSomeValuesIsValid1(int value, boolean result) {
        assertEquals(result, isEven(value));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/isAdult.csv", numLinesToSkip = 0)
    void isAdultForBoundaryValuesIsValid2(int age, boolean result) {
        assertEquals(result, isAdult(age));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csvFile.csv", numLinesToSkip = 0)
    void isEvenForSomeValuesIsValid2(int value, boolean result) {
        assertEquals(result, isEven(value));
    }
}