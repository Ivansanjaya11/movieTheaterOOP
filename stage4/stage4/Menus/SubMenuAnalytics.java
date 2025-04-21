package stage4.Menus;

import stage4.AnalyticsAndFiles.AnalyticsExporter;
import stage4.AnalyticsAndFiles.AnalyticsReporter;
import stage4.Staff;
import stage4.util.PrettyPrinter;

import java.util.Scanner;

public class SubMenuAnalytics {

    private static final Scanner input = new Scanner(System.in);

    /**
     * Constructs stage4.TicketRelated.stage4.Menus.SubMenuAnalytics class
     */
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
            System.out.println("2. stage4.TicketRelated.stage4.FoodRelated.Food sales report");
            System.out.println("3. stage4.TicketRelated.stage4.FoodRelated.Inventory report");
            System.out.println("4. stage4.TicketRelated.stage4.FoodRelated.Item order history report");

            option = input.nextByte();

            if (option<0 || option>4) {
                System.out.println("Invalid option!");
            }
        } while (option<0 || option>4);

        switch (option) {
            // Prompts ticket staff user to enter report time
            case 1:
                AnalyticsReporter analyticsTicket = Prompt.askForAnalyticsReportTime(staff);
                analyticsTicket.generateTicketSalesReport();
                break;
            // Prompts food staff user to enter report time
            case 2:
                AnalyticsReporter analyticsFood = Prompt.askForAnalyticsReportTime(staff);
                analyticsFood.generateFoodSalesReport();
                break;
            // Creates new analytics report for inventory
            case 3:
                AnalyticsReporter analyticsInventory = new AnalyticsReporter();
                analyticsInventory.generateInventoryReport();
                break;
            // Prompts staff user to enter report for item orders
            case 4:
                AnalyticsReporter analyticsItem = Prompt.askForAnalyticsReportTime(staff);
                analyticsItem.generateItemOrderReport();
                break;
            default:
                System.out.println("No report to be generated!");
                break;
        }
    }

    /**
     * Prompts the user to select and export a report based on the available options.
     */

    public static void exportReport(Staff staff) {

        byte option;

        do {
            PrettyPrinter.printDashLine((short) 100);

            System.out.println("Which report would you like to export?");
            System.out.println("1. Ticket sales report");
            System.out.println("2. stage4.TicketRelated.stage4.FoodRelated.Food sales report");
            System.out.println("3. stage4.TicketRelated.stage4.FoodRelated.Inventory report");
            System.out.println("4. stage4.TicketRelated.stage4.FoodRelated.Item order history report");

            option = input.nextByte();

            if (option<0 || option>4) {
                System.out.println("Invalid option!");
            }
        } while (option<0 || option>4);

        switch (option) {
            // Prompts ticket staff user to export ticket sales report
            case 1:
                AnalyticsExporter analyticsTicket = Prompt.askForAnalyticsExportTime(staff);
                analyticsTicket.exportTicketSalesReport();
                break;
            // Prompts food staff user to export food sales report
            case 2:
                AnalyticsExporter analyticsFood = Prompt.askForAnalyticsExportTime(staff);
                analyticsFood.exportFoodSalesReport();
                break;
            // Creates new analytics exporter to export inventory report
            case 3:
                AnalyticsExporter analyticsInventory = new AnalyticsExporter();
                analyticsInventory.exportInventoryReport();
                break;
            // Prompts staff to export item order report
            case 4:
                AnalyticsExporter analyticsItem = Prompt.askForAnalyticsExportTime(staff);
                analyticsItem.exportItemOrderReport();
                break;
            default:
                System.out.println("No report to be exported!");
                break;
        }
    }

}
