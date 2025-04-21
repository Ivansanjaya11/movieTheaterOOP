package stage4.AnalyticsAndFiles;

import stage4.util.Path;
import stage4.util.PrettyPrinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnalyticsReporter extends Analytics {

    /**
     * Constructs stage4.TicketRelated.stage4.Analytics.AnalyticsReporter class
     */
    public AnalyticsReporter() {}

    // Initializes stage4.TicketRelated.stage4.Analytics.AnalyticsReporter with LocalDate startReport and LocalDate endReport
    public AnalyticsReporter(LocalDate startReport, LocalDate endReport) {
        super(startReport.atStartOfDay(), endReport.atStartOfDay());
    }

    /**
     * Generates a ticket sales report. (Implementation to be added later.)
     */
    public void generateTicketSalesReport() {
        /*
         * ===================== Report Generator =====================
         *
         * This section of code reads each line from a text-based report file,
         * parses the order information and seat positions, then displays a
         * formatted table-like analytics view to the console, filtered by
         * a specific time period (if specified).
         *
         * -------------------------------------------------------------
         * Each line in the report file has the following structure:
         *
         *    orderInfo;seatsInfo
         *
         *    - orderInfo: paymentId, timestamp, paymentAmount, quantity,
         *                 screenType, screenId, movieTitle, startTime
         *    - seatsInfo: a comma-separated list of seat positions (row, col)
         *
         * This will be printed to the console (if timestamp is in the time range) as:
         *
         *    P12345     |2025-04-06T15:42:00      |250    |3    |IMAX   |S3    |Interstellar   |2025-04-06T17:00:00 |(0,5), (0,6), (1,3)     |
         *    -------------------------
         *
         * Explanation:
         *    - Only lines with timestamps falling between `timePeriodStart`
         *      and `timePeriodEnd` are displayed.
         *    - Each seat is printed in (row,col) format.
         *    - A horizontal line is printed after each entry for visual separation.
         *
         * This formatting is useful for CLI-based analytics tools where quick
         * viewing of ticket sales, seating patterns, and screen/movies data
         * is necessary.
         *
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.TICKET_SALES_REPORT_PATH))) {

            System.out.println("Below is the ticket sales report for the specified time period: ");
            System.out.print(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.Orders.Payment ID", paymentIdWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Timestamp", timeWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Total", numericWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Qty", numericWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Type", veryShortStrWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("stage4.TicketRelated.Screen ID", numericWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("stage4.TicketRelated.Movie", longStrWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Start", numericWidth) + "|");
            System.out.println("Seats");

            PrettyPrinter.printDashLine(reportWidth);

            String line;

            while ((line = reader.readLine()) != null) {
                String orderInfo = line.split(";")[0];
                String seatsInfo = line.split(";")[1];

                String[] seatsPosition = seatsInfo.split(",");

                String paymentId = orderInfo.split(",")[0];

                LocalDateTime timestamp = LocalDateTime.parse(orderInfo.split(",")[1]);

                String paymentAmount = orderInfo.split(",")[2];
                String quantity = orderInfo.split(",")[3];
                String screenType = orderInfo.split(",")[4];
                String screenId = orderInfo.split(",")[5];
                String movieTitle = orderInfo.split(",")[6];
                String startTime = orderInfo.split(",")[7];


                if (this.hasTimePeriod() && timestamp.isAfter(this.timePeriodStart) && timestamp.isBefore(this.timePeriodEnd)) {

                    System.out.print(PrettyPrinter.addWhitespace(paymentId, paymentIdWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(String.valueOf(timestamp), timeWidth) + "|");
                    System.out.print("$" + PrettyPrinter.addWhitespace(paymentAmount, (byte) (numericWidth-1)) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(quantity, numericWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(screenType, veryShortStrWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(screenId, numericWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(movieTitle, longStrWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(startTime, numericWidth) + "|");


                    for (int i=0; i<seatsPosition.length; i+=2) {
                        String row = seatsPosition[i].trim();
                        String col = seatsPosition[i+1].trim();

                        String pos = "(" + row + "," + col + ")";
                        System.out.print(pos);
                        if (i+2 == seatsPosition.length) {
                            System.out.println();
                        } else {
                            System.out.print(", ");
                        }
                    }
                }

                PrettyPrinter.printDashLine(reportWidth);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }

    /**
     * Generates a food sales report for the specified time period.
     * Reads data from a file and displays it in a tabular format.
     */
    public void generateFoodSalesReport() {
        /*
         * The report generated by the generateFoodSalesReport method is formatted as follows:
         *
         * 1. The report header is displayed with the following columns:
         * 	  - stage4.TicketRelated.stage4.Orders.Payment ID
         *    - Date & Time
         *    - stage4.TicketRelated.stage4.FoodRelated.Food Name
         *    - Quantity
         *    - Price
         *
         * 2. Each order is printed in the following format:
         *    - The order's timestamp (Date & Time)
         *    - The food item name
         *    - The quantity of the food item ordered
         *    - The price for the quantity of the food item ordered
         *
         * 3. If there are multiple food items in a single order,
         * each food item is displayed on a new line under the same order with its respective details.
         *
         * 4. After each order, a separator line is printed, and the total price for the order is displayed.
         *
         * Example:
         *
         * stage4.TicketRelated.stage4.Orders.Payment ID		|Date & Time            |stage4.TicketRelated.stage4.FoodRelated.Food Name         |Quantity       |Price
         * -----------------------------------------------------------------------------------
         * 2025-03-07-001	|2025-03-07T10:30:00    |Burger            |2              |$10.00
         *         		    |               		|Fries             |1              |$2.50
         * -----------------------------------------------------------------------------------
         *                      									  totalPrice       |$12.50
         * ------------------------------------------------------------------------------------
         *
         * 5. The report is filtered based on the time period, if specified.
         * Orders outside the specified time period will not appear in the report.
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.FOOD_SALES_REPORT_PATH))) {

            System.out.println("Below is the food sales report for the specified time period: ");

            System.out.print(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.Orders.Payment ID", paymentIdWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Date & Time", timeWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.FoodRelated.Food Name", shortStrWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Qty", numericWidth) + "|");
            System.out.println("Price");

            PrettyPrinter.printDashLine(reportWidth);

            String line;

            while ((line = reader.readLine()) != null) {
                String orderInfo = line.split(";")[0];
                String orderList = line.split(";")[1];

                String paymentId = orderInfo.split(",")[0];
                LocalDateTime time = LocalDateTime.parse(orderInfo.split(",")[1]);
                String totalPrice = orderInfo.split(",")[2];

                String[] orderArray = orderList.split(",");

                if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
                    System.out.print(PrettyPrinter.addWhitespace(paymentId, paymentIdWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(time.toString(), timeWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(orderArray[0], shortStrWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(orderArray[1], numericWidth) + "|");
                    System.out.println("$" + PrettyPrinter.addWhitespace(orderArray[2], (byte)(numericWidth - 1)));


                    byte indentTabWidth1 = (byte) (paymentIdWidth + timeWidth + 1);

                    if (orderArray.length > 3) {
                        for (int i=3; i<orderArray.length; i+=3) {

                            System.out.print(PrettyPrinter.addWhitespace("", indentTabWidth1) + "|");
                            System.out.print(PrettyPrinter.addWhitespace(orderArray[i], shortStrWidth) + "|");
                            System.out.print(PrettyPrinter.addWhitespace(orderArray[i+1], numericWidth) + "|");
                            System.out.println("$" + PrettyPrinter.addWhitespace(orderArray[i+2], (byte)(numericWidth - 1)));

                        }
                    }

                    byte indentTabWidth2 = (byte) (paymentIdWidth + timeWidth + shortStrWidth + 2);
                    PrettyPrinter.printDashLine(reportWidth);
                    System.out.print(PrettyPrinter.addWhitespace("", indentTabWidth2));
                    System.out.print(PrettyPrinter.addWhitespace("total Price", numericWidth) + "|");
                    System.out.println("$" + PrettyPrinter.addWhitespace(totalPrice, (byte)(numericWidth - 1)));

                    PrettyPrinter.printDashLine(reportWidth);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Generates an inventory report for the current time.
     * Reads data from a file and displays the inventory items and quantities.
     */
    public void generateInventoryReport() {
        /*
         * The report generated by the generateInventoryReport method is formatted as follows:
         *
         * 1. The report header is displayed with the following columns:
         *    - stage4.TicketRelated.stage4.FoodRelated.Item Name
         *    - Quantity
         *
         * 2. Each line of the report represents an item in the inventory, formatted as:
         *    - The name of the item
         *    - The quantity of the item in stock
         *
         * 3. The items are displayed in the following format:
         *    - The item name
         *    - The quantity of the item in the inventory
         *
         * Example:
         *
         * stage4.TicketRelated.stage4.FoodRelated.Item Name            |Quantity
         * --------------------------------------------------
         * Burger               |50
         * Fries                |100
         * Coke					|75
         *
         * 4. The report reads data from the inventory report file
         * and prints each item with its corresponding quantity.
         *
         * 5. The report is printed as a simple tabular list with item names and quantities.
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.INVENTORY_REPORT_PATH))) {

            System.out.println("Below is the current content of the inventory: ");
            System.out.print(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.FoodRelated.Item Name", shortStrWidth) + "|");
            System.out.println(PrettyPrinter.addWhitespace("Quantity", numericWidth));

            PrettyPrinter.printDashLine(reportWidth);

            String line;

            while ((line = reader.readLine()) != null) {
                String itemName = line.split(",")[1];
                short quantity = Short.parseShort(line.split(",")[2]);

                System.out.print(PrettyPrinter.addWhitespace(itemName, shortStrWidth) + "|");
                System.out.println(quantity);

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Generates a report of the item order history for the specified time period.
     * Reads data from a file and displays the item order history.
     */
    public void generateItemOrderReport() {
        /*
         * The report generated by the generateItemOrderReport method is formatted as follows:
         *
         * 1. The report header is displayed with the following columns:
         *    - Date & Time
         *    - stage4.TicketRelated.stage4.FoodRelated.Item Name
         *    - Quantity Bought
         *    - Total Price
         *
         * 2. Each line of the report represents an item order, formatted as:
         *    - The date and time when the order was made
         *    - The name of the item ordered
         *    - The quantity of the item ordered
         *    - The total price for that order
         *
         * 3. The report filters the orders based on the specified time period.
         * Only the orders that fall within the time period are displayed.
         *
         * Example:
         *
         * Date & Time             |stage4.TicketRelated.stage4.FoodRelated.Item Name            |Quantity Bought |TotalPrice
         * ------------------------------------------------------------------------
         * 2025-03-01T14:00:00     |Burger               |10              |150
         * 2025-03-01T15:30:00     |Fries                |20              |100
         *
         * 4. The report reads data from the item order report file
         * and prints each order with the corresponding details.
         *
         * 5. The report is printed as a simple tabular list
         * with date, item name, quantity, and total price.
         */

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.ITEM_ORDER_REPORT_PATH))) {

            System.out.println("Below is the inventory item order history: ");

            System.out.print(PrettyPrinter.addWhitespace("Date & Time", timeWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Name", shortStrWidth) + "|");
            System.out.print(PrettyPrinter.addWhitespace("Qty", numericWidth) + "|");
            System.out.println("Total Price");

            PrettyPrinter.printDashLine(reportWidth);

            String line;

            while ((line = reader.readLine()) != null) {
                LocalDateTime time = LocalDateTime.parse(line.split(",")[0]);
                String itemName = line.split(",")[1];
                short quantity = Short.parseShort(line.split(",")[2]);
                short totalPrice = Short.parseShort(line.split(",")[3]);

                if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
                    System.out.print(PrettyPrinter.addWhitespace(time.toString(), timeWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(itemName, shortStrWidth) + "|");
                    System.out.print(PrettyPrinter.addWhitespace(String.valueOf(quantity), numericWidth) + "|");
                    System.out.println("$" + PrettyPrinter.addWhitespace(String.valueOf(totalPrice), (byte)(numericWidth - 1)));
                }
            }

            PrettyPrinter.printDashLine(reportWidth);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
