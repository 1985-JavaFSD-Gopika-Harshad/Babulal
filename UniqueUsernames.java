package CodingQuestion;

import java.util.HashSet;

public class UniqueUsernames {
	
    public static void main(String[] args) {
        // Create a HashSet to store unique usernames
        HashSet<String> usernames = new HashSet<>();

        // Adding usernames
        usernames.add("user1");
        usernames.add("user2");
        usernames.add("user3");
        usernames.add("user1"); // Duplicate, won't be added

        // Checking existence
        if (usernames.contains("user2")) {
            System.out.println("user2 exists in the set.");
        } else {
            System.out.println("user2 does not exist.");
        }

        // Removing a username
        usernames.remove("user1");
        System.out.println("user1 removed. Current usernames: " + usernames);
    }

}
