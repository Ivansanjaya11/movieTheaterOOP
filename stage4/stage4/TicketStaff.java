package stage4; /**
 * @author Heather Santos
 */

import stage4.OrdersAndPayment.TicketPayment;
import stage4.util.PrettyPrinter;

/**
 * Represents a staff member responsible for ticket sales operations
 * Manages ticket payment and interacts with showtime and movie data
 */

public class TicketStaff extends Staff {

    /**
     * Constructs a stage4.TicketRelated.stage4.TicketStaff member with provided employee details
     * @param employeeName the name of the staff member
     * @param employeeId th eID of the staff member
     * @param hourlyRate the hourly pay rate
     * @param schedule the work schedule in HH:mm-HH:mm format
     */
    public TicketStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {

        super(employeeName, employeeId, hourlyRate, schedule);
        this.role = "Ticket Sales";
    }

    /**
     * Adds a new ticket payment for a customer
     * Clears previous order history if it's the first customer of the day
     * @param customer the customer purchasing tickets
     */
    public void addNewTicketPayment(Customer customer) {

        TicketPayment payment = new TicketPayment(customer);

        boolean isSuccessful = payment.chooseTicket();

        if (isSuccessful) {
            System.out.println("Transaction completed!");
        }

        PrettyPrinter.printDashLine((short) 50);
    }
}
