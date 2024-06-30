import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Lesson_7_junit_5 {
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

    @Nested
    class FactorialTest {

        @Test
        public void testFactorialZero() {
            assertEquals(1, Factorial.compute(0));
        }

        @Test
        public void testFactorialOne() {
            assertEquals(1, Factorial.compute(1));
        }

        @Test
        public void testFactorialFive() {
            assertEquals(120, Factorial.compute(5));
        }

        @Test
        public void testFactorialNegative() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                Factorial.compute(-1);
            });
            assertEquals("Number must be non-negative.", exception.getMessage());
        }
    }
}
