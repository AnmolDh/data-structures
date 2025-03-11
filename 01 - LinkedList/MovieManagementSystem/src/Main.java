public class Main {
    public static void main(String[] args) {
        Movie m1 = new Movie("Hitler", "Germans", 1828, 10);
        Movie m2 = new Movie("Harry Potter", "J.K. Rowling", 1995, 10);
        Movie m3 = new Movie("PotterHead", "J.K. Rowling", 1995, 10);

        MovieLinkedList list = new MovieLinkedList();
        list.add(m1);
        list.add(m2);
        list.add(m3, 0);

        list.remove("Hitler");
        list.traverse(-1);
    }
}