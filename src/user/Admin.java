package user;

public class Admin extends User{
    public Admin(){

    }

    public Admin(String name, String userName, String password, String gender, int age){
        super(name, userName, password, gender, "admin",age);
    }

}
