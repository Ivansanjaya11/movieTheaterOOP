package stage4.util;

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

    private static String dataPath = "data/";
    // all paths to data persistence
    public static final String FOOD_DATA_PATH = dataPath + "food.txt";
    public static final String MOVIE_DATA_PATH = dataPath + "movie.txt";
    public static final String SCREEN_DATA_PATH = dataPath + "screen.txt";
    public static final String SHOWTIME_DATA_PATH = dataPath + "showtime.txt";
    public static final String STAFF_DATA_PATH = dataPath + "staff.txt";

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

        // create the food data file if not exists yet
        File foodDataFile = new File(FOOD_DATA_PATH);

        if (!foodDataFile.exists()) {
            try {
                foodDataFile.getParentFile().mkdirs();
                foodDataFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // create staff data file if not exists yet
        File staffDataFile = new File(STAFF_DATA_PATH);

        if (!staffDataFile.exists()) {
            try {
                staffDataFile.getParentFile().mkdirs();
                staffDataFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // create the movie data file if not exists yet
        File movieDataFile = new File(Path.MOVIE_DATA_PATH);

        if (!movieDataFile.exists()) {
            try {
                movieDataFile.getParentFile().mkdirs();
                movieDataFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // create the screen data file if not exists yet
        File screenDataFile = new File(Path.SCREEN_DATA_PATH);

        if (!screenDataFile.exists()) {
            try {
                screenDataFile.getParentFile().mkdirs();
                screenDataFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // create the showtime data file if not exists yet
        File showtimeDataFile = new File(Path.SHOWTIME_DATA_PATH);

        if (!showtimeDataFile.exists()) {
            try {
                showtimeDataFile.getParentFile().mkdirs();
                showtimeDataFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
