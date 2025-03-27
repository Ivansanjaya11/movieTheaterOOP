import java.util.ArrayList;

class TicketStaff extends Staff {
    private ArrayList<TicketPayment> ticketPayments;

    public TicketStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {
        super(employeeName, employeeId, hourlyRate, schedule);
        this.ticketPayments = new ArrayList<>();
    }

    public void addNewTicketPayment(byte normalTickets, byte imaxTickets) {
        TicketPayment payment = new TicketPayment(normalTickets, imaxTickets);
        ticketPayments.add(payment);
        System.out.println("Ticket payment successful.");
    }

    public void clearOrderHistory() {
        ticketPayments.clear();
        System.out.println("Order history cleared.");
    }

    public ArrayList<TicketPayments> getOrderHistory() {
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

    public String getEmployeeRoles() {
        return "Ticket Seller";
    }

    public void setEmployeeRoles(String roleDescription) {
        System.out.println("Employee role: " + roleDescription);
    }
}
