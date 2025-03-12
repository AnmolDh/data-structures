public class UserListNode {
    private User user;
    private UserListNode next;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserListNode getNext() {
        return next;
    }

    public void setNext(UserListNode next) {
        this.next = next;
    }

    public UserListNode(User user) {
        this.user = user;
        this.next = null;
    }

    @Override
    public String toString() {
        return "User ID: " + user.getUserId() + ", Name: " + user.getName() + ", Age: " + user.getAge() + ", Friends: " + user.getFriendIds();
    }
}
