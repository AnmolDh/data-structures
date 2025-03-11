public class MovieNode {
    private Movie movie;
    private MovieNode prev;
    private MovieNode next;

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public MovieNode getPrev() {
        return prev;
    }
    public void setPrev(MovieNode prev) {
        this.prev = prev;
    }
    public MovieNode getNext() {
        return next;
    }
    public void setNext(MovieNode next) {
        this.next = next;
    }

    public MovieNode(Movie movie) {
        this.movie = movie;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Title: " + movie.getTitle() + "\nDirector: " + movie.getDirector() + "\nYear: " + movie.getYear() + "\n";
    }
}
