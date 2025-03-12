public class BookLinkedList {
    private BookListNode head;
    private BookListNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void addBookAtBeginning(Book book) {
        BookListNode newBook = new BookListNode(book);
        if (isEmpty()) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.setNext(head);
            head.setPrev(newBook);
            head = newBook;
        }
    }

    public void addBookAtEnd(Book book) {
        BookListNode newBook = new BookListNode(book);
        if (isEmpty()) {
            head = newBook;
            tail = newBook;
        } else {
            tail.setNext(newBook);
            newBook.setPrev(tail);
            tail = newBook;
        }
    }


    public void addBookAtPosition(Book book, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addBookAtBeginning(book);
        } else {
            BookListNode newBook = new BookListNode(book);
            BookListNode temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.getNext();
                if (temp == null) {
                    System.out.println("Position out of range.");
                    return;
                }
            }
            newBook.setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPrev(newBook);
            }
            temp.setNext(newBook);
            newBook.setPrev(temp);
            if (newBook.getNext() == null) {
                tail = newBook;
            }
        }
    }

    public void removeBookById(int bookId) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        BookListNode temp = head;
        while (temp != null && temp.getBook().getBookId() != bookId) {
            temp = temp.getNext();
        }
        if (temp == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            if (temp.getPrev() != null) {
                temp.getPrev().setNext(temp.getNext());
            } else {
                head = temp.getNext();
            }
            if (temp.getNext() != null) {
                temp.getNext().setPrev(temp.getPrev());
            } else {
                tail = temp.getPrev();
            }
            System.out.println("Book with ID " + bookId + " removed.");
        }
    }

    public void searchByTitle(String title) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        BookListNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.getBook().getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + temp);
                found = true;
            }
            temp = temp.getNext();
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found.");
        }
    }

    public void searchByAuthor(String author) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        BookListNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.getBook().getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Book found: " + temp);
                found = true;
            }
            temp = temp.getNext();
        }
        if (!found) {
            System.out.println("Book by author '" + author + "' not found.");
        }
    }

    public void updateAvailability(int bookId, boolean isAvailable) {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        BookListNode temp = head;
        while (temp != null) {
            if (temp.getBook().getBookId() == bookId) {
                temp.getBook().setAvailable(isAvailable);
                System.out.println("Availability updated for Book ID " + bookId + ".");
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public void displayBooksForward() {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        BookListNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }

    public void displayBooksReverse() {
        if (isEmpty()) {
            System.out.println("Library is empty.");
            return;
        }
        BookListNode temp = tail;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getPrev();
        }
    }

    public int countBooks() {
        int count = 0;
        BookListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

}
