import java.util.Scanner;

public class ReadFromKeyboard {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DataStorage dataStorage = new DataStorage();

    public void run() {
        while (true) {
            System.out.print("Enter Command >>> ");
            String command = scanner.nextLine();
            System.out.println("Command received: " + command);
            switch (command.toLowerCase()) {
                case "create":
                    createUser();
                    break;
                case "read":
                    readUser();
                    break;
                case "update":
                    updateUser();
                    break;
                case "delete":
                    deleteUser();
                    break;
                case "show":
                    showAllUsers();
                    break;
                case "help":
                    help();
                    break;
                case "quit":
                    quit();
                    return;
                default:
                    System.out.println("Unknown command. Type 'help' for the list of commands.");
            }
        }
    }

    private void createUser() {
        System.out.print("Username: >>> ");
        String username = scanner.nextLine();
        System.out.print("Sold: >>> ");
        int sold = scanner.nextInt();
        dataStorage.addUser(new User(username, sold));
        System.out.println("User created: " + username + " with sold " + sold);
    }

    private void readUser() {
        System.out.print("Username: >>> ");
        String username = scanner.nextLine();
        User user = dataStorage.getUser(username);
        if (user != null) {
            System.out.println("User: " + user.getUsername() + ", Sold: " + user.getSold());
        } else {
            System.out.println("User not found.");
        }
    }

    private void updateUser() {
        System.out.print("Username: >>> ");
        String username = scanner.nextLine();
        System.out.print("Sold: >>> ");
        int sold = Integer.parseInt(scanner.nextLine());
        if (dataStorage.updateUser(username, sold)) {
            System.out.println("The sold was updated for user " + username + " to " + sold);
        } else {
            System.out.println("User not found.");
        }
    }

    private void deleteUser() {
        System.out.print("Username: >>> ");
        String username = scanner.nextLine();
        if (dataStorage.deleteUser(username)) {
            System.out.println("User " + username + " deleted.");
        } else {
            System.out.println("User not found.");
        }
    }

    private void showAllUsers() {
        dataStorage.showAllUsers();
    }

    private void help() {
        System.out.println("\n\tAccepted commands:" +
                "\n\t\tcreate: Create a new user. Requires username and sold." +
                "\n\t\tread: Read user data. Requires the username." +
                "\n\t\tupdate: Update data. Requires username and new sold." +
                "\n\t\tdelete: Delete the user's data. Requires the username." +
                "\n\t\thelp: Instructions on how to use the application." +
                "\n\t\tquit: Close the application.\n");
    }

    private void quit() {
        System.out.println("Application closed.");
    }

    public static void main(String[] args) {
        new ReadFromKeyboard().run();
    }
}
