public class TicketLinkedList {
    private TicketListNode head;
    private TicketListNode tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void addTicket(Ticket ticket) {
        TicketListNode newTicket = new TicketListNode(ticket);
        if (isEmpty()) {
            head = newTicket;
            tail = newTicket;
            tail.setNext(head);
        } else {
            tail.setNext(newTicket);
            newTicket.setNext(head);
            tail = newTicket;
        }
    }

    public void removeTicketById(int ticketId) {
        if (isEmpty()) {
            System.out.println("No tickets to remove.");
            return;
        }
        TicketListNode temp = head;
        TicketListNode prev = tail;

        do {
            if (temp.getTicket().getTicketId() == ticketId) {
                if (temp == head) {
                    if (head == tail) {
                        head = null;
                        tail = null;
                    } else {
                        head = head.getNext();
                        tail.setNext(head);
                    }
                } else {
                    prev.setNext(temp.getNext());
                    if (temp == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.getNext();
        } while (temp != head);

        System.out.println("Ticket with ID " + ticketId + " not found.");
    }

    public void displayTickets() {
        if (isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }
        TicketListNode temp = head;
        do {
            System.out.println(temp);
            temp = temp.getNext();
        } while (temp != head);
    }

    public void searchByCustomerName(String customerName) {
        if (isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }
        TicketListNode temp = head;
        boolean found = false;
        do {
            if (temp.getTicket().getCustomerName().equalsIgnoreCase(customerName)) {
                System.out.println("Ticket found: " + temp);
                found = true;
            }
            temp = temp.getNext();
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found for customer '" + customerName + "'.");
        }
    }

    public void searchByMovieName(String movieName) {
        if (isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }
        TicketListNode temp = head;
        boolean found = false;
        do {
            if (temp.getTicket().getMovieName().equalsIgnoreCase(movieName)) {
                System.out.println("Ticket found: " + temp);
                found = true;
            }
            temp = temp.getNext();
        } while (temp != head);
        if (!found) {
            System.out.println("No tickets found for movie '" + movieName + "'.");
        }
    }

    public int countTickets() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        TicketListNode temp = head;
        do {
            count++;
            temp = temp.getNext();
        } while (temp != head);
        return count;
    }

}
