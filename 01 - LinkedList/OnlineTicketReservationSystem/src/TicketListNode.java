public class TicketListNode {
    private Ticket ticket;
    private TicketListNode next;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketListNode getNext() {
        return next;
    }

    public void setNext(TicketListNode next) {
        this.next = next;
    }

    public TicketListNode(Ticket ticket) {
        this.ticket = ticket;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticket.getTicketId() + ", Customer Name: " + ticket.getCustomerName() + ", Movie Name: " + ticket.getMovieName() +
                ", Seat Number: " + ticket.getSeatNumber() + ", Booking Time: " + ticket.getBookingTime();
    }
}
