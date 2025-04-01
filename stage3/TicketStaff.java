import util.DateAndPaymentTracker;
import java.util.ArrayList;

class TicketStaff extends Staff {
    private ArrayList<TicketPayment> ticketPayments;

    public TicketStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {
        super(employeeName, employeeId, hourlyRate, schedule);
        this.role = "Ticket Sales";
        this.ticketPayments = new ArrayList<>();
    }

    public void addNewTicketPayment(Customer customer) {
        if(DateAndPaymentTracker.ticketNumOfTheDay == 0) {
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

    public void chooseSeat(Screen screen, byte row, byte col) {
        boolean seatTaken = screen.getSeatStatus(row, col);
        if(!seatTaken) {
            screen.setSeatStatus(row, col, true);
            System.out.println("Seat chosen at row " + row + ", column " + col);
            } else {
                System.out.println("Seat unavailable, please choose another.");
            }
    }
}
