import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void testArea() {
        assertEquals(6.0, Triangle.area(3, 4, 5), 0.001);
    }

    @Test
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.area(1, 2, 10));
    }
}
