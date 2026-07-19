import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class UserManagerTest {

    @Test
    void testVerify(){

        NotificationService service=mock(NotificationService.class);

        UserManager manager=new UserManager(service);

        manager.registerUser();

        verify(service).sendNotification("User Registered");

    }
}