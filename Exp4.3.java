import java.util.*;

class TicketBookingSystem {
    private final boolean[] seats;

    public TicketBookingSystem(int totalSeats) {
        seats = new boolean[totalSeats];
    }

    public synchronized boolean bookSeat(int seatNumber, String userName) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println(userName + ": Invalid seat number!");
            return false;
        }
        if (!seats[seatNumber - 1]) {
            seats[seatNumber - 1] = true;
            System.out.println(userName + " booked seat " + seatNumber);
            return true;
        } else {
            System.out.println(userName + ": Seat " + seatNumber + " is already booked!");
            return false;
        }
    }
}

class User extends Thread {
    private final TicketBookingSystem system;
    private final int seatNumber;
    private final String userName;

    public User(TicketBookingSystem system, int seatNumber, String userName, int priority) {
        this.system = system;
        this.seatNumber = seatNumber;
        this.userName = userName;
        this.setPriority(priority);
    }

    @Override
    public void run() {
        system.bookSeat(seatNumber, userName);
    }
}

public class Main {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(5);

        User user1 = new User(system, 1, "Anish (VIP)", Thread.MAX_PRIORITY);
        User user2 = new User(system, 2, "Bobby (Regular)", Thread.NORM_PRIORITY);
        User user3 = new User(system, 3, "Charlie (VIP)", Thread.MAX_PRIORITY);
        User user4 = new User(system, 4, "David (Regular)", Thread.MIN_PRIORITY);
        User user5 = new User(system, 4, "Eve (VIP)", Thread.MAX_PRIORITY);
        User user6 = new User(system, 6, "Frank (Regular)", Thread.NORM_PRIORITY);

        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();
        user6.start();
    }
}
