package advanced.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Optional;

import static org.junit.Assert.fail;

/**
 * More precise testing than @Test(expect=Runtime.class)
 */
public class TestHelper {

    public static <t extends Throwable> Optional<Throwable> assertThrows(Class<t> exceptionClass, Runnable block) {
        try {
            block.run();
        } catch (Throwable throwable) {
            if (exceptionClass.isInstance(throwable)) {
                return Optional.of(throwable);
            }
        }
        fail("Fail: no expected exception " + exceptionClass.getName());
        return Optional.empty();
    }
}
