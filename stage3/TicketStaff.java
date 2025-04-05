import util.DateAndPaymentTracker;
import java.util.ArrayList;

class TicketStaff extends Staff {
    private ArrayList<TicketPayment> ticketPayments;
    private static ShowtimeManager showtimeManager;
    private static MovieManager movieManager;

    static {
        showtimeManager = new ShowtimeManager();
        movieManager = new MovieManager();
    }

    public TicketStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {
        super(employeeName, employeeId, hourlyRate, schedule);
        this.role = "Ticket Sales";
        this.ticketPayments = new ArrayList<>();
    }

    public ShowtimeManager getShowtimeManager() {
        return showtimeManager;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public void setShowtimeManager(ShowtimeManager showtimeManager) {
        this.showtimeManager = showtimeManager;
    }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public void addNewTicketPayment(Customer customer) {
        if(DateAndPaymentTracker.ticketCustomerNumOfTheDay == 0) {
            clearOrderHistory();
        }
        TicketPayment payment = new TicketPayment(customer);
        payment.chooseTicket();
        ticketPayments.add(payment);
    }

    public void clearOrderHistory() {
        ticketPayments.clear();
        System.out.println("Order history cleared.");
    }

    public ArrayList<TicketPayment> getOrderHistory() {
        return ticketPayments;
    }
}
