public class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    public MovieLinkedList() {
        head = null;
        tail = null;
    }

    public void traverse(int order) {
        MovieNode current;
        if (order >= 0){
            current = head;
            while (current != null) {
                System.out.println(current);
                current = current.getNext();
            }
        }
        else {
            current = tail;
            while (current != null) {
                System.out.println(current);
                current = current.getPrev();
            }
        }
    }

    public void addAtStart(Movie movie) {
        MovieNode newNode = new MovieNode(movie);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        MovieNode temp = head;
        head = newNode;
        newNode.setNext(temp);
        temp.setPrev(newNode);
    }

    public void add(Movie movie) {
        MovieNode newNode = new MovieNode(movie);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        MovieNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        newNode.setPrev(temp);
        temp.setNext(newNode);
        tail = newNode;
    }

    public void add(Movie movie, int index){
        MovieNode newNode = new MovieNode(movie);
        if (index <= 0 && head == null) {
            addAtStart(movie);
            return;
        }

        MovieNode temp = head;
        int counter = 0;
        while (counter < index-1 && temp != null) {
            temp = temp.getNext();
            counter++;
        }
        if (temp == null) {
            add(movie);
        }else {
            MovieNode tempNext = temp.getNext();
            temp.setNext(newNode);
            newNode.setPrev(temp);
            newNode.setNext(tempNext);
            if (tempNext != null) {
                tempNext.setPrev(newNode);
            }
        }
    }

    public void remove(String title) {
        if (head == null) {
            return;
        }
        if (head.getMovie().getTitle().equals(title)) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
            return;
        }

        MovieNode temp = head;
        while (temp.getNext() != null && !temp.getNext().getMovie().getTitle().equals(title)) {
            temp = temp.getNext();
        }
        if (temp.getNext() == null) {
            return;
        } else {
            MovieNode toRemove = temp.getNext();
            MovieNode nextNode = toRemove.getNext();
            temp.setNext(nextNode);
            if (nextNode != null) {
                nextNode.setPrev(temp);
            } else {
                tail = temp;
            }
        }
    }

    public void search(String director) {
        if (head == null) {
            return;
        }
        if (head.getMovie().getDirector().equals(director)) {
            System.out.println(head);
        }
        MovieNode temp = head;
        while (temp != null) {
            if (temp.getMovie().getDirector().equals(director)) {
                System.out.println(temp);
                return;
            }
            temp = temp.getNext();
        }
    }

    public void search(int rating) {
        if (head == null) {
            return;
        }
        if (head.getMovie().getRating() == rating) {
            System.out.println(head);
        }
        MovieNode temp = head;
        while (temp != null) {
            if (temp.getMovie().getRating() == rating) {
                System.out.println(temp);
                return;
            }
            temp = temp.getNext();
        }
    }

}
