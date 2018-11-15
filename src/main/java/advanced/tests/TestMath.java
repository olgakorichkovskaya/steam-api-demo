package advanced.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestMath {

    private Math math = new Math();

    @Test(expected = ArithmeticException.class)
    public  void test1() {
        math.divide(1, 10);
        math.divide(1, 1);
        math.divide(1, 0);
        math.divide(1, -1);
    }

    @Test
    public void testWithLambda() {
        math.divide(1, 10);
        math.divide(1, 1);
        TestHelper.assertThrows(ArithmeticException.class, () -> math.divide(1,0));
        math.divide(1, -1);
    }
}