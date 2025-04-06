/**
 * @author Heather Santos
 */

import util.DateAndPaymentTracker;
import java.util.ArrayList;

/**
 * Represents a staff member responsible for ticket sales operations
 * Manages ticket payment and iteracts with showtime and movie data
 */

class TicketStaff extends Staff {
    private ArrayList<TicketPayment> ticketPayments;
    private static ShowtimeManager showtimeManager;
    private static MovieManager movieManager;

    //static initializer block to set up shared managers
    static {
        showtimeManager = new ShowtimeManager();
        movieManager = new MovieManager();
    }

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
     * @param showtimeManager the new ShowtimeManager to set
     */

    public void setShowtimeManager(ShowtimeManager showtimeManager) {
        this.showtimeManager = showtimeManager;
    }

    /**
     * Sets the MovieManager
     * @param movieManager the new MovieManager to set
     */

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
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
        payment.chooseTicket();
        this.ticketPayments.add(payment);
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
