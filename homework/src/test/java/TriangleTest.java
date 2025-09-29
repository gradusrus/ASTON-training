import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleTest {
    @Test
    public void testArea() {
        assertEquals(Triangle.area(3, 4, 5), 6.0, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangle() {
        Triangle.area(1, 2, 10);
    }
}
