import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAddition() {
        Calculator cal = new Calculator();
        assertEquals(10, cal.add(4,6));
    }
}