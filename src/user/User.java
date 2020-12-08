package user;

public class User {
    private String name;
    private String userName;
    private String password;
    private String gender;
    private String role;
    private int ID;
    private int age;
    static private int nextID = 1000;


    public User() {

    }

    public User(String name, String userName, String password, String gender, String role, int age) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.role = role;
        this.ID = nextID;
        nextID += 59;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public String getName() {
        return name;

    }

    public String getPassword() {
        return password;

    }

    public String getUserName() {
        return userName;

    }

    public int getAge() {
        return age;

    }

    public String getRole() {
        return role;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", role='" + role + '\'' +
                ", ID=" + ID +
                ", age=" + age +
                '}';
    }

}
