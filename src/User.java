import java.util.Objects;

public class User {

    String name;
    String password;
    Boolean isAdmin;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    //3.6.
    public void authenticate(String name, String password) {
        if (Objects.equals(name, "Geek") && Objects.equals(password, "Brains")) isAuthenticate = true;
        else if (isAdmin) isAuthenticate = true;
    }
}