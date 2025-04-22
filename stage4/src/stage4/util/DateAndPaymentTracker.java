package stage4.util;

import java.time.LocalDate;

/**
 * Util class to keep track of current date
 * and the counter for the number of customer of the day for food and ticket.
 * These counters resets back to 1 every day
 * This class is useful to generate receipt and payment id
 */
public class DateAndPaymentTracker {
    public static short foodCustomerNumOfTheDay = 0;
    public static short ticketCustomerNumOfTheDay = 0;
    public static LocalDate currentDate = LocalDate.now();

    private DateAndPaymentTracker() {}
}
