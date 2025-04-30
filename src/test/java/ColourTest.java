import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColourTest {

    public enum Colour {
        RED,
        GREEN,
        BLUE,
        ORANGE;

        public String getColourName() {
            switch (this) {
                case RED: {
                    return "Цвет красный";
                }
                case GREEN: {
                    return "Цвет зеленый";
                }
                case BLUE: {
                    return "Цвет синий";
                }
                case ORANGE: {
                    return "Цвет оранжевый";
                }
                default: {
                    return "Цвет неизвестный";
                }
            }
        }
    }

    @ParameterizedTest
    @EnumSource(Colour.class)
    public void getColourNameForAllStartsWithColour(Colour colour) {
        assertTrue(colour.getColourName().startsWith("Цвет"));
    }
}