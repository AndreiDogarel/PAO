import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public boolean updateUser(String username, int sold) {
        User user = users.get(username);
        if (user != null) {
            user.setSold(sold);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String username) {
        return users.remove(username) != null;
    }

    public void showAllUsers() {
        for(var user : users.entrySet()) {
            System.out.println("User: " + user.getValue().getUsername() + ", Sold: " + user.getValue().getSold());
        }
    }
}
