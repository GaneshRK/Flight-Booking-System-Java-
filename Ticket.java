import java.util.*;

public class Ticket {
    private static int counter = 1000;
    private int ticketId;
    private String name;
    private int age;
    private String source;
    private String destination;

    public Ticket(String name, int age, String source, String destination) {
        this.ticketId = counter++;
        this.name = name;
        this.age = age;
        this.source = source;
        this.destination = destination;
    }

    public int getTicketId() { return ticketId; }
    public String getName() { return name; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }

    @Override
    public String toString() {
        return String.format("Ticket ID: %d | Name: %s | Age: %d | From: %s | To: %s",
                ticketId, name, age, source, destination);
    }
}
