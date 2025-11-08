import java.util.*;

public class BookingSystem {
    private final List<Ticket> tickets = Collections.synchronizedList(new ArrayList<>());

    public synchronized void bookTicket(String name, int age, String source, String destination) {
        Ticket t = new Ticket(name, age, source, destination);
        tickets.add(t);
        System.out.println("[Booking Thread] Booking successful for " + name + " (Ticket ID: " + t.getTicketId() + ")");
    }

    public synchronized void cancelTicket(int ticketId) throws Exception {
        boolean removed = tickets.removeIf(t -> t.getTicketId() == ticketId);
        if (!removed) throw new Exception("Ticket ID not found for cancellation!");
        System.out.println("[Booking Thread] Ticket ID " + ticketId + " cancelled successfully.");
    }

    public synchronized void displayTickets() {
        System.out.println("\n[Display Thread] Current Bookings:");
        if (tickets.isEmpty()) System.out.println("No bookings available!");
        else for (Ticket t : tickets) System.out.println(t);
    }

    public synchronized void searchTicket(int ticketId) {
        for (Ticket t : tickets) {
            if (t.getTicketId() == ticketId) {
                System.out.println("Ticket Found: " + t);
                return;
            }
        }
        System.out.println("Ticket not found!");
    }

    public synchronized int countTickets() { return tickets.size(); }
}
