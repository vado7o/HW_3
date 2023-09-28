import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestClass {

    @ParameterizedTest
    @ValueSource(ints = {2, 24, 126, 1012, 10236})
    void testEvenNum(int i) {
        EvenOdd test = new EvenOdd();
        assertTrue(test.evenOddNumber(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 13, 127, 1027, 10237})
    void testOddNum(int i) {
        EvenOdd test = new EvenOdd();
        assertFalse(test.evenOddNumber(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 55, 78, 90, 95})
    void testNumInInterval(int i) {
        NumInInterval test = new NumInInterval();
        assertTrue(test.numInInterval(i));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 8, 25, 100, 120, 1000})
    void testNumNotInInterval(int i) {
        NumInInterval test = new NumInInterval();
        assertFalse(test.numInInterval(i));
    }

    @Test
    void testIsAuthorized() {
        User user = new User("Geek", "Brains", true);
        user.authenticate(user.name, user.password);
        assertTrue(user.isAuthenticate);
    }

    @Test
    void testNotAuthorized() {
        User user = new User("Petr", "Ivanov", false);
        user.authenticate(user.name, user.password);
        assertFalse(user.isAuthenticate);
    }

    @Test
    void testUserInRepository() {
        User user = new User("Geek", "Brains", true);
        user.authenticate(user.name, user.password);
        UserRepository userRepo = new UserRepository();
        userRepo.addUser(user);
        assertTrue(userRepo.findByName(user.name));
    }

    @Test
    void testUserNotInRepository() {
        User user = new User("Petr", "Ivanov", false);
        user.authenticate(user.name, user.password);
        UserRepository userRepo = new UserRepository();
        userRepo.addUser(user);
        assertFalse(userRepo.findByName(user.name));
    }

    @Test
    void logout() {
        UserRepository userRepo = new UserRepository();
        User user = new User("Petr", "Ivanov", true);
        User user2 = new User("Ivan", "Sidorov", false);
        User user3 = new User("Pavel", "Tihonov", false);
        User user4 = new User("Geek", "Brains", false);
        user.authenticate(user.name, user.password);
        user2.authenticate(user.name, user.password);
        user3.authenticate(user.name, user.password);
        user4.authenticate(user.name, user.password);
        userRepo.addUser(user);
        userRepo.addUser(user2);
        userRepo.addUser(user3);
        userRepo.addUser(user4);

        userRepo.logout();
        assertTrue(user.isAuthenticate);
        assertFalse(user2.isAuthenticate);
        assertFalse(user3.isAuthenticate);
        assertFalse(user4.isAuthenticate);

    }
}
