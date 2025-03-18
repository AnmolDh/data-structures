import java.util.ArrayList;

public class BookStore {
    private String name;
    private final ArrayList<Book> books;

    public BookStore(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(String title, String author, int price) {
        Book book = new Book(title, author, price);
        books.add(book);
    }

    private void merge(int low, int mid, int high) {
        ArrayList<Book> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (books.get(left).getPrice() <= books.get(right).getPrice()) {
                temp.add(books.get(left));
                left++;
            }
            else{
                temp.add(books.get(right));
                right++;
            }
        }

        while (left <= mid) {
            temp.add(books.get(left));
            left++;
        }
        while (right <= high) {
            temp.add(books.get(right));
            right++;
        }

        for (int i = low; i <= high; i++) {
            books.set(i, temp.get(i-low));
        }
    }

    private void mergeSort(int low, int high){
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }

    public void sort(){
        int low = 0;
        int high = books.size() - 1;
        mergeSort(low, high);
    }

    public void display(){
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
