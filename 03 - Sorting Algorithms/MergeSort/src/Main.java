public class Main {
    public static void main(String[] args) {
        BookStore bs = new BookStore("Book Store");
        bs.addBook("Book 1", "John Doe", 12);
        bs.addBook("Book 2", "John Doe", 24);
        bs.addBook("Book 3", "John Doe", 2);
        bs.addBook("Book 4", "John Doe", 12);

        bs.sort();
        bs.display();
    }
}