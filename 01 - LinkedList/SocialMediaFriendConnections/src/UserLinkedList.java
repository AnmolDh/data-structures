import java.util.ArrayList;

public class UserLinkedList {
    private UserListNode head;

    public boolean isEmpty() {
        return head == null;
    }

    public void addUser(User user) {
        UserListNode newUser = new UserListNode(user);
        if (isEmpty()) {
            head = newUser;
        } else {
            UserListNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newUser);
        }
    }

    private User findUserById(int userId) {
        UserListNode temp = head;
        while (temp != null) {
            if (temp.getUser().getUserId() == userId) {
                return temp.getUser();
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.getFriendIds().contains(userId2)) {
            user1.getFriendIds().add(userId2);
            user2.getFriendIds().add(userId1);
            System.out.println("Friend connection added between User " + userId1 + " and User " + userId2 + ".");
        } else {
            System.out.println("Friend connection already exists.");
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (user1.getFriendIds().contains(userId2)) {
            user1.getFriendIds().remove(Integer.valueOf(userId2));
            user2.getFriendIds().remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed between User " + userId1 + " and User " + userId2 + ".");
        } else {
            System.out.println("No friend connection exists.");
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        ArrayList<Integer> mutualFriends = new ArrayList<>();
        for (int friendId : user1.getFriendIds()) {
            if (user2.getFriendIds().contains(friendId)) {
                mutualFriends.add(friendId);
            }
        }
        if (mutualFriends.isEmpty()) {
            System.out.println("No mutual friends found.");
        } else {
            System.out.println("Mutual friends between User " + userId1 + " and User " + userId2 + ": " + mutualFriends);
        }
    }

    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of User " + userId + ": " + user.getFriendIds());
    }

    public void searchByName(String name) {
        UserListNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.getUser().getName().equalsIgnoreCase(name)) {
                System.out.println("User found: " + temp);
                found = true;
            }
            temp = temp.getNext();
        }
        if (!found) {
            System.out.println("User with name '" + name + "' not found.");
        }
    }

    public void searchById(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
        } else {
            System.out.println("User found: " + user);
        }
    }

    public void countFriends() {
        UserListNode temp = head;
        while (temp != null) {
            System.out.println("User " + temp.getUser().getUserId() + " has " + temp.getUser().getFriendIds().size() + " friends.");
            temp = temp.getNext();
        }
    }

    public void displayAllUsers() {
        if (isEmpty()) {
            System.out.println("No users in the system.");
            return;
        }
        UserListNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
