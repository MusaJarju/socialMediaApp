import java.util.*;

public class SocialMediaApp {
    private static Map<String, User> users = new HashMap<>();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Welcome to Java Social Media Simulation ===");
        while (true) {
            if (currentUser == null) {
                showMainMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("\n1. Sign Up\n2. Log In\n3. Exit");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1 -> signUp();
            case 2 -> logIn();
            case 3 -> System.exit(0);
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void showUserMenu() {
        System.out.println("\nLogged in as: " + currentUser.getUsername());
        System.out.println("1. Create Post\n2. View Feed\n3. Follow User\n4. Log Out");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1 -> {
                System.out.print("Enter post content: ");
                String content = scanner.nextLine();
                currentUser.createPost(content); 
            }
            case 2 -> currentUser.showFeed(); 
            case 3 -> {
                System.out.print("Enter username to follow: ");
                String uname = scanner.nextLine();
                if (users.containsKey(uname)) {
                    currentUser.follow(users.get(uname));
                } else {
                    System.out.println("User not found.");
                }
            }
            case 4 -> {
                currentUser = null;
                System.out.println("Logged out.");
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void signUp() {
        System.out.print("Choose a username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already taken.");
        } else {
            User user = new User(username);
            users.put(username, user);
            System.out.println("User created. You can now log in.");
        }
    }

    private static void logIn() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            currentUser = users.get(username);
            System.out.println("Welcome back, " + username + "!");
        } else {
            System.out.println("No such user. Please sign up first.");
        }
    }
}
