import java.util.Scanner;

public class FlightBookingMain {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        Scanner sc = new Scanner(System.in);

        Thread bookingThread = new Thread(() -> {
            try {
                System.out.print("Enter number of passengers to book: ");
                int n = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < n; i++) {
                    System.out.println("\nEnter Passenger " + (i + 1) + " Details:");
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Source: ");
                    String src = sc.nextLine();
                    System.out.print("Destination: ");
                    String dest = sc.nextLine();
                    system.bookTicket(name, age, src, dest);
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                System.out.println("Error during booking: " + e.getMessage());
            }
        });

        Thread displayThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                system.displayTickets();
            } catch (InterruptedException e) {
                System.out.println("Display interrupted.");
            }
        });

        bookingThread.start();
        displayThread.start();

        try {
            bookingThread.join();
            displayThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted!");
        }

        System.out.print("\nEnter Ticket ID to search: ");
        int id = sc.nextInt();
        system.searchTicket(id);

        System.out.print("\nEnter Ticket ID to cancel: ");
        int cancelId = sc.nextInt();
        try {
            system.cancelTicket(cancelId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        system.displayTickets();
        System.out.println("\nTotal Bookings Remaining: " + system.countTickets());
        System.out.println("\n[System] Flight Booking Simulation Completed Successfully!");
    }
}
