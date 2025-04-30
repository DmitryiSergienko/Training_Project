import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestAssertJ {

    @Test
    public void testChecksGreaterThan() {
        assertThat(10).isGreaterThan(5);
    }

    @Test
    public void testFailWithMessage() {
        assertThat(2).withFailMessage("Это будет выведено, когда проверка не сработает").isGreaterThan(5);
    }

    @Test
    public void testChecksEndWith() {
        String lifeIsGood = "Life is good";
        String good = "good";
        assertThat(lifeIsGood).endsWith(good); // ends with - «заканчивается»
    }
}