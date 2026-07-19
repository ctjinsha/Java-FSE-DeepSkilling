import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    void testMocking(){

        ExternalService mockService=mock(ExternalService.class);

        when(mockService.getData()).thenReturn("Hello Mockito");

        UserService user=new UserService(mockService);

        assertEquals("Hello Mockito",user.fetchData());

    }
}