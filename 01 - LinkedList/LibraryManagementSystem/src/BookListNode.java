public class BookListNode {
    private Book book;
    private BookListNode next;
    private BookListNode prev;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public BookListNode getNext() {
        return next;
    }

    public void setNext(BookListNode next) {
        this.next = next;
    }

    public BookListNode getPrev() {
        return prev;
    }

    public void setPrev(BookListNode prev) {
        this.prev = prev;
    }

    public BookListNode(Book book) {
        this.book = book;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Book ID: " + book.getBookId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Genre: " + book.getGenre() +
                ", Availability: " + (book.isAvailable() ? "Available" : "Not Available");
    }
}
