import org.testng.TestNG;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class Lesson_7_testng {
    public static class Factorial {
        public static long compute(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Number must be non-negative.");
            }
            long result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        }
    }


    public class FactorialTestNGTest {

        @Test
        public void testFactorialZero() {
            assertEquals(Factorial.compute(0), 1);
        }

        @Test
        public void testFactorialOne() {
            assertEquals(Factorial.compute(1), 1);
        }

        @Test
        public void testFactorialFive() {
            assertEquals(Factorial.compute(5), 120);
        }

        @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Number must be non-negative.")
        public void testFactorialNegative() {
            Factorial.compute(-1);
        }
    }

    public static class TestRunner {
        public static void main(String[] args) {
            TestNG testng = new TestNG();
            testng.setTestClasses(new Class[]{FactorialTestNGTest.class});
            testng.run();
        }
    }
}
