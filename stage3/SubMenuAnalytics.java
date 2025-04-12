import util.PrettyPrinter;

import java.util.Scanner;

public class SubMenuAnalytics {
    private static final Scanner input = new Scanner(System.in);

    private SubMenuAnalytics() {}

    /**
     * Prompts the user to select and generate a report based on the available options.
     */

    public static void generateReport(Staff staff) {

        byte option;

        do {
            PrettyPrinter.printDashLine((short) 100);
            System.out.println("Which report would you like to generate?");
            System.out.println("1. Ticket sales report");
            System.out.println("2. Food sales report");
            System.out.println("3. Inventory report");
            System.out.println("4. Item order history report");
            option = input.nextByte();
            if (option<0 || option>4) {
                System.out.println("Invalid option!");
            }
        } while (option<0 || option>4);

        switch (option) {
            case 1:
                AnalyticsReporter analyticsTicket = Prompt.askForAnalyticsReportTime(staff);
                analyticsTicket.generateTicketSalesReport();
                break;
            case 2:
                AnalyticsReporter analyticsFood = Prompt.askForAnalyticsReportTime(staff);
                analyticsFood.generateFoodSalesReport();
                break;
            case 3:
                AnalyticsReporter analyticsInventory = new AnalyticsReporter();
                analyticsInventory.generateInventoryReport();
                break;
            case 4:
                AnalyticsReporter analyticsItem = Prompt.askForAnalyticsReportTime(staff);
                analyticsItem.generateItemOrderReport();
                break;
            default:
                System.out.println("No report to be generated!");
        }
    }

    /**
     * Prompts the user to select and export a report based on the available options.
     */

    public static void exportReport(Staff staff) {

        byte option;

        do {
            System.out.println("Which report would you like to export?");
            System.out.println("1. Ticket sales report");
            System.out.println("2. Food sales report");
            System.out.println("3. Inventory report");
            System.out.println("4. Item order history report");
            option = input.nextByte();
            if (option<0 || option>4) {
                System.out.println("Invalid option!");
            }
        } while (option<0 || option>4);

        switch (option) {
            case 1:
                AnalyticsExporter analyticsTicket = Prompt.askForAnalyticsExportTime(staff);
                analyticsTicket.exportTicketSalesReport();
                break;
            case 2:
                AnalyticsExporter analyticsFood = Prompt.askForAnalyticsExportTime(staff);
                analyticsFood.exportFoodSalesReport();
                break;
            case 3:
                AnalyticsExporter analyticsInventory = new AnalyticsExporter();
                analyticsInventory.exportInventoryReport();
                break;
            case 4:
                AnalyticsExporter analyticsItem = Prompt.askForAnalyticsExportTime(staff);
                analyticsItem.exportItemOrderReport();
                break;
            default:
                System.out.println("No report to be exported!");
        }
    }

}
