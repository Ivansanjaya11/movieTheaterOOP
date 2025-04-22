package stage4.AnalyticsAndFiles;

import stage4.util.Path;
import stage4.util.PrettyPrinter;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnalyticsExporter extends Analytics {

    /**
     * Constructs stage4.TicketRelated.stage4.Analytics.AnalyticsExporter class
     */
    public AnalyticsExporter() {}

    // Initializes stage4.TicketRelated.stage4.Analytics.AnalyticsExporter with LocalDate startReport and LocalDate endReport
    public AnalyticsExporter(LocalDate startReport, LocalDate endReport) {
        super(startReport.atStartOfDay(), endReport.atStartOfDay());
    }

    /**
     * Exports the ticket sales report. (Implementation to be added later.)
     */
    public void exportTicketSalesReport() {

        // format is the same as generateTicketSalesReport
        String start = this.timePeriodStart.format(formatter);
        String end = this.timePeriodEnd.format(formatter);
        String ticketSalesExportPath = Path.TICKET_SALES_EXPORT_PATH + "TS-" + start + "TO" + end + ".txt";

        File file = new File(ticketSalesExportPath);
        file.getParentFile().mkdirs();

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.TICKET_SALES_REPORT_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(ticketSalesExportPath, true))) {

            writer.write("Below is the ticket sales report for the specified time period:\n");

            writer.write(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.Orders.Payment ID", paymentIdWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Timestamp", timeWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Total", numericWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Qty", numericWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Type", veryShortStrWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("stage4.TicketRelated.Screen ID", numericWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Movie", longStrWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Start", numericWidth) + "|");
            writer.write("Seats\n");

            PrettyPrinter.writeDashLine(writer, reportWidth);

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

                    writer.write(PrettyPrinter.addWhitespace(paymentId, paymentIdWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(String.valueOf(timestamp), timeWidth) + "|");
                    writer.write("$" + PrettyPrinter.addWhitespace(paymentAmount, (byte) (numericWidth - 1)) + "|");
                    writer.write(PrettyPrinter.addWhitespace(quantity, numericWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(screenType, veryShortStrWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(screenId, numericWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(movieTitle, longStrWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(startTime, numericWidth) + "|");

                    for (int i=0; i<seatsPosition.length; i+=2) {
                        String row = seatsPosition[i].trim();
                        String col = seatsPosition[i+1].trim();

                        String pos = "(" + row + "," + col + ")";
                        writer.write(pos);
                        if (i+2 == seatsPosition.length) {
                            writer.newLine();
                        } else {
                            writer.write(", ");
                        }
                    }
                }

                PrettyPrinter.writeDashLine(writer, reportWidth);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Exports the food sales report for the specified time period to a file.
     */
    public void exportFoodSalesReport() {

        // format is the same as generateFoodSalesReport
        String start = this.timePeriodStart.format(formatter);
        String end = this.timePeriodEnd.format(formatter);

        String foodSalesExportPath = Path.FOOD_SALES_EXPORT_PATH + "foodSales" + start + "TO" + end + ".txt";

        File file = new File(foodSalesExportPath);
        file.getParentFile().mkdirs();

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.FOOD_SALES_REPORT_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(foodSalesExportPath, true))) {
            writer.write("Below is the food sales report for the specified time period: ");
            writer.newLine();

            writer.write(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.Orders.Payment ID", paymentIdWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Date & Time", timeWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.FoodRelated.Food Name", shortStrWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Qty", numericWidth) + "|");
            writer.write("Price\n");

            PrettyPrinter.writeDashLine(writer, reportWidth);
            String line;

            while ((line = reader.readLine()) != null) {
                String orderInfo = line.split(";")[0];
                String orderList = line.split(";")[1];

                String paymentId = orderInfo.split(",")[0];
                LocalDateTime time = LocalDateTime.parse(orderInfo.split(",")[1]);
                String totalPrice = orderInfo.split(",")[2];

                String[] orderArray = orderList.split(",");

                if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
                    writer.write(PrettyPrinter.addWhitespace(paymentId, paymentIdWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(time.toString(), timeWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(orderArray[0], shortStrWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(orderArray[1], numericWidth) + "|");
                    writer.write("$" + PrettyPrinter.addWhitespace(orderArray[2], (byte)(numericWidth - 1)) + "\n");

                    byte indentTabWidth1 = (byte) (paymentIdWidth + timeWidth + 1);

                    if (orderArray.length > 3) {
                        for (int i=3; i<orderArray.length; i+=3) {

                            writer.write(PrettyPrinter.addWhitespace("", indentTabWidth1) + "|");
                            writer.write(PrettyPrinter.addWhitespace(orderArray[i], shortStrWidth) + "|");
                            writer.write(PrettyPrinter.addWhitespace(orderArray[i+1], numericWidth) + "|");
                            writer.write("$" + PrettyPrinter.addWhitespace(orderArray[i+2], (byte)(numericWidth - 1)) + "\n");

                        }
                    }

                    PrettyPrinter.writeDashLine(writer, reportWidth);

                    byte indentTabWidth2 = (byte) (paymentIdWidth + timeWidth + shortStrWidth + 2);

                    writer.write(PrettyPrinter.addWhitespace("", indentTabWidth2));
                    writer.write(PrettyPrinter.addWhitespace("total Price", numericWidth) + "|");
                    writer.write("$" + PrettyPrinter.addWhitespace(totalPrice, (byte)(numericWidth - 1)) + "\n");

                    PrettyPrinter.writeDashLine(writer, reportWidth);

                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Exports the inventory report to a file for the current time.
     */
    public void exportInventoryReport() {

        // format is the same as generateInventoryReport
        String timeNow = LocalDateTime.now().format(formatter);
        String inventoryExportFilePath = Path.INVENTORY_EXPORT_PATH + "I-" + timeNow + ".txt";

        File file = new File(inventoryExportFilePath);
        file.getParentFile().mkdirs();

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.INVENTORY_REPORT_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryExportFilePath, true))){

            writer.write("Below is the content of the inventory as of " + LocalDateTime.now() + ":");
            writer.newLine();

            writer.write(PrettyPrinter.addWhitespace("stage4.TicketRelated.stage4.FoodRelated.Item Name", shortStrWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Quantity", numericWidth));
            writer.newLine();

            PrettyPrinter.writeDashLine(writer, reportWidth);


            String line;

            while ((line = reader.readLine()) != null) {
                String itemName = line.split(",")[1];
                short quantity = Short.parseShort(line.split(",")[2]);

                writer.write(PrettyPrinter.addWhitespace(itemName, shortStrWidth) + "|");
                writer.write(String.valueOf(quantity));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Exports the item order history report to a file for the specified time period.
     */
    public void exportItemOrderReport() {

        // format is the same as generateItemOrderReport
        String start = this.timePeriodStart.format(formatter);
        String end = this.timePeriodEnd.format(formatter);
        String itemOrderExportPath = Path.ITEM_ORDER_EXPORT_PATH + "IO-" + start + "TO" + end + ".txt";

        File file = new File(itemOrderExportPath);
        file.getParentFile().mkdirs();

        try (BufferedReader reader = new BufferedReader(new FileReader(Path.ITEM_ORDER_REPORT_PATH));
             BufferedWriter writer = new BufferedWriter(new FileWriter(itemOrderExportPath, true))) {

            writer.write("Below is the inventory item order history: ");
            writer.newLine();

            writer.write(PrettyPrinter.addWhitespace("Date & Time", timeWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Name", shortStrWidth) + "|");
            writer.write(PrettyPrinter.addWhitespace("Qty", numericWidth) + "|");
            writer.write("Total Price\n");


            PrettyPrinter.writeDashLine(writer, reportWidth);

            String line;

            while ((line = reader.readLine()) != null) {
                LocalDateTime time = LocalDateTime.parse(line.split(",")[0]);
                String itemName = line.split(",")[1];
                short quantity = Short.parseShort(line.split(",")[2]);
                short totalPrice = Short.parseShort(line.split(",")[3]);
                if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
                    writer.write(PrettyPrinter.addWhitespace(time.toString(), timeWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(itemName, shortStrWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(String.valueOf(quantity), numericWidth) + "|");
                    writer.write(PrettyPrinter.addWhitespace(String.valueOf(totalPrice), (byte)(numericWidth - 1)) + "\n");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}