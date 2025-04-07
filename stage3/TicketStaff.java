/**
 * @author Heather Santos
 */

import util.DateAndPaymentTracker;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Represents a staff member responsible for ticket sales operations
 * Manages ticket payment and iteracts with showtime and movie data
 */

class TicketStaff extends Staff {
    private ArrayList<TicketPayment> ticketPayments;
    private static ShowtimeManager showtimeManager = new ShowtimeManager();
    private static MovieManager movieManager = new MovieManager();

    /**
     * Constructs a TicketStaff member with provided employee details
     * @param employeeName the name of the staff member
     * @param employeeId th eID of the staff member
     * @param hourlyRate the hourly pay rate
     * @param schedule the work schedule in HH:mm-HH:mm format
     */

    public TicketStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {
        super(employeeName, employeeId, hourlyRate, schedule);
        this.role = "Ticket Sales";
        this.ticketPayments = new ArrayList<>();
    }

    /**
     * Gets the static Showtime Manager instance
     * @return the ShowtimeManager
     */

    public ShowtimeManager getShowtimeManager() {
        return showtimeManager;
    }

    /**
     * Gets the static MovieManager instance
     * @return the MovieManager
     */

    public MovieManager getMovieManager() {
        return movieManager;
    }

    /**
     * Sets the static ShowtimeManager
     * @param newShowtimeManager the new ShowtimeManager to set
     */

    public void setShowtimeManager(ShowtimeManager newShowtimeManager) {
        showtimeManager = newShowtimeManager;
    }

    /**
     * Sets the MovieManager
     * @param newMovieManager the new MovieManager to set
     */

    public void setMovieManager(MovieManager newMovieManager) {
        movieManager = newMovieManager;
    }

    /**
     * Adds a new ticket payment for a customer
     * Clears previous order history if it's the first customer of the day
     * @param customer the customer purchasing tickets
     */

    public void addNewTicketPayment(Customer customer) {
        if(DateAndPaymentTracker.ticketCustomerNumOfTheDay == 0) {
            this.clearOrderHistory();
        }
        TicketPayment payment = new TicketPayment(customer);
        boolean isSuccessful = payment.chooseTicket();

        if (isSuccessful) {
            this.ticketPayments.add(payment);
        }
        IntStream.range(0, 25).forEach(i -> System.out.print(i));
        System.out.println();
    }

    /**
     * Clears the list of ticket payments for this staff member
     */

    public void clearOrderHistory() {
        this.ticketPayments.clear();
        System.out.println("Order history cleared.");
    }

    /**
     * Returns the order history containing all ticket payments
     * @return list of TicketPayment objects
     */

    public ArrayList<TicketPayment> getOrderHistory() {
        return this.ticketPayments;
    }
}
