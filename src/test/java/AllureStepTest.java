import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class AllureStepTest {

    @Test
    void testAuthentication() {
        step1();
        step2();
    }

    @Step("Step 1")
    void step1() {
        subStep1();
        subStep2();
    }

    @Step("Sub-step 1")
    void subStep1() {
        // ...
    }

    @Step("Sub-step 2")
    void subStep2() {
        // ...
    }

    @Step("Step 2")
    void step2() {
        // ...
    }

}
