import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
        assertEquals(Calculator.add(3, 4), 7);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        Calculator.divide(5, 0);
    }
}
