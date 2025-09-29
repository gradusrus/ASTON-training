import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComparatorTest {
    @Test
    void testCompareEqual() {
        assertEquals(0, Comparator.compare(5, 5));
    }

    @Test
    void testCompareGreater() {
        assertEquals(1, Comparator.compare(7, 3));
    }

    @Test
    void testCompareLess() {
        assertEquals(-1, Comparator.compare(2, 9));
    }
}
