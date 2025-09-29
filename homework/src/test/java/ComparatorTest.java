import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ComparatorTest {
    @Test
    public void testCompareEqual() {
        assertEquals(Comparator.compare(5, 5), 0);
    }

    @Test
    public void testCompareGreater() {
        assertEquals(Comparator.compare(7, 3), 1);
    }

    @Test
    public void testCompareLess() {
        assertEquals(Comparator.compare(2, 9), -1);
    }
}
