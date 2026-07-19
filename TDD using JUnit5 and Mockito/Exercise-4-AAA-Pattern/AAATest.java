import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class AAATest {

    Calculator cal;

    @BeforeEach
    void setup(){
        cal=new Calculator();
    }

    @AfterEach
    void tearDown(){
        System.out.println("Test Completed");
    }

    @Test
    void testSubtract(){

        // Arrange
        int a=10;
        int b=5;

        // Act
        int result=cal.subtract(a,b);

        // Assert
        assertEquals(5,result);

    }
}