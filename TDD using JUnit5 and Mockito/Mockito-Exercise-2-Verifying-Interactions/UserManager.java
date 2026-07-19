public class UserManager {

    NotificationService service;

    public UserManager(NotificationService service){
        this.service=service;
    }

    public void registerUser(){

        service.sendNotification("User Registered");

    }

}