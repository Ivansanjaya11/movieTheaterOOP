package util;

import java.time.LocalDate;

/**
 * Util class to keep track of current date
 * and the counter for the number of customer of the day for food and ticket.
 * These counters resets back to 1 every day
 */

public class DateAndPaymentTracker {
    public static short foodCustomerNumOfTheDay;
    public static short ticketCustomerNumOfTheDay;
    public static LocalDate currentDate;

    private DateAndPaymentTracker() {

    }

    static {
        foodCustomerNumOfTheDay = 0;
        ticketCustomerNumOfTheDay = 0;
        currentDate = LocalDate.now();
    }
}
