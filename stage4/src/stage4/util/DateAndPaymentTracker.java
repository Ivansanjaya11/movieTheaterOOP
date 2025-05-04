package stage4.util;

import java.time.LocalDate;
import java.io.*;

/**
 * Util class to keep track of current date
 * and the counter for the number of customer of the day for food and ticket.
 * These counters resets back to 1 every day
 * This class is useful to generate receipt and payment id
 */
public class DateAndPaymentTracker {
    public static short foodCustomerNumOfTheDay;
    public static short ticketCustomerNumOfTheDay;
    public static LocalDate currentDate;
    
    private static final File customerCounterFile = new File(Path.CUSTOMER_COUNTER_DATA_PATH);

    private DateAndPaymentTracker() {}
    
    static {
        if (customerCounterFile.length() != 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(Path.CUSTOMER_COUNTER_DATA_PATH))) {
                String line;
                
                while ((line = reader.readLine()) != null) {
                    String[] infoArray = line.split(";");
                    
                    foodCustomerNumOfTheDay = Short.parseShort(infoArray[0]);
                    ticketCustomerNumOfTheDay = Short.parseShort(infoArray[1]);
                    
                    currentDate = LocalDate.parse(infoArray[2]);
                }
                
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } else {
            foodCustomerNumOfTheDay = 0;
            ticketCustomerNumOfTheDay = 0;
            currentDate = LocalDate.now();
        }
    }
}
