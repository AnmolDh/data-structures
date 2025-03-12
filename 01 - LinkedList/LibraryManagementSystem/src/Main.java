public class Main {
    public static void main(String[] args) {
        BookLinkedList library = new BookLinkedList();

        library.addBookAtBeginning(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 101));
        library.addBookAtEnd(new Book("1984", "George Orwell", "Dystopian", 102));
        library.addBookAtPosition(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 103), 2);

        System.out.println("Books in forward order:");
        library.displayBooksForward();

        System.out.println("\nBooks in reverse order:");
        library.displayBooksReverse();

        System.out.println("\nSearching for book with title '1984':");
        library.searchByTitle("1984");

        System.out.println("\nSearching for books by author 'Harper Lee':");
        library.searchByAuthor("Harper Lee");

        System.out.println("\nUpdating availability of Book ID 101 to Not Available:");
        library.updateAvailability(101, false);
        library.displayBooksForward();

        System.out.println("\nRemoving Book ID 102:");
        library.removeBookById(102);
        library.displayBooksForward();

        System.out.println("\nTotal number of books in the library: " + library.countBooks());
    }
}