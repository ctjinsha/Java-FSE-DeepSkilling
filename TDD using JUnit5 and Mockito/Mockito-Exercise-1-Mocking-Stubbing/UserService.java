public class UserService {

    ExternalService service;

    public UserService(ExternalService service){
        this.service=service;
    }

    public String fetchData(){
        return service.getData();
    }
}