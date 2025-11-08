
✈️ Concurrent Flight Booking System (Java)
This repository contains a simple, object-oriented Flight Booking System implemented in Java. It demonstrates core OOP concepts, list management for dynamic data storage, and the use of Java Threads and synchronization to handle concurrent booking and display operations safely.

✨ Key Concepts Demonstrated
Object-Oriented Design (OOP): The system is divided into clear concerns: a Ticket model and a BookingSystem service.
Concurrency: Booking and display operations run in separate threads, showcasing thread creation and the use of synchronized methods on the BookingSystem object to prevent data corruption during simultaneous access.
Data Management: Bookings are stored in a List wrapped in Collections.synchronizedList() for thread-safe access.
Unique ID Generation: Each Ticket automatically receives a unique, sequential ID.

⚙️ How to Compile and Run
Prerequisites
Java Development Kit (JDK) 8 or newer.
Structure
Since the package lines were removed, compile and run this code from a single directory.
Save the three files (Ticket.java, BookingSystem.java, FlightBookingMain.java) in the same folder.

Compile
Use the Java compiler (javac) to compile all three files:
Bash
javac *.java
Run
Execute the main class:
Bash
java FlightBookingMain
