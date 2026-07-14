import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

    @Test
    void testAssertions(){

        Calculator c=new Calculator();

        assertEquals(20,c.multiply(4,5));
        assertNotEquals(25,c.multiply(4,5));
        assertTrue(10>5);
        assertFalse(5>10);
        assertNull(null);
        assertNotNull(c);

    }
}