package util;

import java.io.File;
import java.io.IOException;

/**
 * Util class to store paths to files where data is stored
 */
public final class Path {
    private static String reportPath = "report/";
    // all paths to the report files
    public static final String INVENTORY_REPORT_PATH = reportPath + "inventoryReport.txt";
    public static final String ITEM_ORDER_REPORT_PATH = reportPath + "itemOrderReport.txt";
    public static final String FOOD_SALES_REPORT_PATH = reportPath + "foodSalesReport.txt";
    public static final String TICKET_SALES_REPORT_PATH = reportPath + "ticketSalesReport.txt";

    private static String exportPath = "export/";
    // all paths to the export files
    public static final String INVENTORY_EXPORT_PATH = exportPath + "inventory/";
    public static final String ITEM_ORDER_EXPORT_PATH = exportPath + "itemOrder/";
    public static final String FOOD_SALES_EXPORT_PATH = exportPath + "foodSales/";
    public static final String TICKET_SALES_EXPORT_PATH = exportPath + "ticketSales/";

    private Path() {}

    static {
        // create the inventory report file if not exists yet
        File inventoryReportFile = new File(INVENTORY_REPORT_PATH);

        if (!inventoryReportFile.exists()) {
            try {
                inventoryReportFile.getParentFile().mkdirs();
                inventoryReportFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // create the item order report file if not exists yet
        File itemOrderReportFile = new File(ITEM_ORDER_REPORT_PATH);

        if (!itemOrderReportFile.exists()) {
            try {
                itemOrderReportFile.getParentFile().mkdirs();
                itemOrderReportFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // create the food sales report file if not exists yet
        File foodSalesReportFile = new File(FOOD_SALES_REPORT_PATH);

        if (!foodSalesReportFile.exists()) {
            try {
                foodSalesReportFile.getParentFile().mkdirs();
                foodSalesReportFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // create the ticket sales report file if not exists yet
        File ticketSalesReportFile = new File(TICKET_SALES_REPORT_PATH);

        if (!ticketSalesReportFile.exists()) {
            try {
                ticketSalesReportFile.getParentFile().mkdirs();
                ticketSalesReportFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
