import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestMain {

    @Test
    public void testFilterList() {
        assertEquals(List.of(1, 2), Main.filterList(List.of(1, 2, "a", "b")), "[1, 2, \"a\", \"b\"]");
    }

    @Test
    public void testStringToArray() {
        assertArrayEquals(new String[]{"Marmeladen", "Brot"}, Main.stringToArray("Marmeladen Brot"), "\"Marmeladen Brot\"");
    }

    @Test
    public void testSum() {
        assertEquals(6, new Main().sum(List.of(1, "2", 3)), "[1, \"2\", 3]");
    }

    @Test
    public void testDigitize() {
        assertArrayEquals(new int[]{3,2,1}, Main.digitize(123), "123");
    }

    @Test
    public void testDigitize2() {
        assertArrayEquals(new int[]{1,2,3}, Main.digitize2(123), "123");
    }

    @Test
    public void testCockroachSpeed() {
        assertEquals(30, Main.cockroachSpeed(1.08), "1.08");
    }

    @Test
    public void testFilterListWithNoIntegers() {
        assertEquals(List.of(), Main.filterList(List.of("a", "b")), "List contains no integers");
    }

    @Test
    public void testStringToArrayWithEmptyString() {
        assertArrayEquals(new String[]{}, Main.stringToArray(""), "Empty string");
    }

    @Test
    public void testSumWithCompletelyUnsupportedType() {
        assertThrows(IllegalArgumentException.class, () -> new Main().sum(List.of(1, "2", 3.0, true)), "List contains an unsupported type (boolean)");
    }

    @Test
    public void testDigitizeWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Main.digitize(-123), "Negative number");
    }

    @Test
    public void testDigitize2WithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Main.digitize2(-123), "Negative number");
    }

    @Test
    public void testCockroachSpeedWithNegativeSpeed() {
        assertEquals(0, Main.cockroachSpeed(-1.08), "Negative speed");
    }
}
