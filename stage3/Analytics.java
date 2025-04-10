import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.stream.IntStream;

import util.Path;

public class Analytics {
	private LocalDateTime timePeriodStart;
	private LocalDateTime timePeriodEnd;
	private Scanner input;
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

	/**
	 * Constructs an Analytics object with a specified start time for the reporting period.
	 * The end time is set to the current time.
	 *
	 */
	public Analytics() {
		this.timePeriodStart = null;
		this.timePeriodEnd = LocalDateTime.now(ZoneId.of("US/Mountain"));
		this.input = new Scanner(System.in);
	}

	/**
	 * Constructs an Analytics object with a specified start time for the reporting period.
	 * The end time is set to the current time.
	 *
	 * @param timePeriodStart The start time for the report period.
	 */
	public Analytics(LocalDateTime timePeriodStart) {
		this.timePeriodStart = timePeriodStart;
		this.timePeriodEnd = LocalDateTime.now(ZoneId.of("US/Mountain"));
		this.input = new Scanner(System.in);
	}

	/**
	 * Constructs an Analytics object with specified start and end times for the reporting period.
	 *
	 * @param timePeriodStart The start time for the report period.
	 * @param timePeriodEnd The end time for the report period.
	 */
	public Analytics(LocalDateTime timePeriodStart, LocalDateTime timePeriodEnd) {
		this.timePeriodStart = timePeriodStart;
		this.timePeriodEnd = timePeriodEnd;
		this.input = new Scanner(System.in);
	}

	/**
	 * Returns the time period for the report, including start and end times.
	 *
	 * @return A Pair containing the start and end times of the report.
	 */
	public LocalDateTime[] getTimePeriod() {
		LocalDateTime[] dateTime = {this.timePeriodStart, this.timePeriodEnd};
		return dateTime;
	}

	/**
	 * Sets the start time for the report period and resets the end time to the current time.
	 *
	 * @param timePeriodStart The new start time for the report period.
	 */
	public void setTimePeriod(LocalDate timePeriodStart){
		this.timePeriodStart = timePeriodStart.atStartOfDay();
		this.timePeriodEnd = LocalDateTime.now(ZoneId.of("US/Mountain"));
	}

	/**
	 * Sets both the start and end times for the report period.
	 *
	 * @param timePeriodStart The new start time for the report period.
	 * @param timePeriodEnd The new end time for the report period.
	 */
	public void setTimePeriod(LocalDate timePeriodStart, LocalDate timePeriodEnd){
		this.timePeriodStart = timePeriodStart.atStartOfDay();
		this.timePeriodEnd = timePeriodEnd.atStartOfDay();
	}

	/**
	 * Checks if a time period has been set.
	 *
	 * @return True if both start and end times are set; false otherwise.
	 */
	public boolean hasTimePeriod() {
		return !(timePeriodStart==null || timePeriodEnd==null);
	}

	/**
	 * Prompts the user to select and generate a report based on the available options.
	 */
	public void generateReport() {
		byte option;
		do {
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
				generateTicketSalesReport();
				break;
			case 2:
				generateFoodSalesReport();
				break;
			case 3:
				generateInventoryReport();
				break;
			case 4:
				generateItemOrderReport();
				break;
			default:
				System.out.println("No report to be generated!");
		}
	}

	/**
	 * Generates a ticket sales report. (Implementation to be added later.)
	 */
	private void generateTicketSalesReport() {
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
		 * Example of a single line in the report file:
		 *    P12345,2025-04-06T15:42:00,250,3,IMAX,S3,Interstellar,2025-04-06T17:00:00;0,5,0,6,1,3
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
			System.out.println("Payment ID\t\t\t|Timestamp\t\t\t|Total\t|Qty\t|Type\t|Scr ID\t|Movie\t\t\t\t|Start\t\t|Seats\t\t");

			IntStream.range(0, 150).forEach(i -> System.out.print("-"));
			System.out.println();

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
					System.out.print(paymentId + "\t\t|" + timestamp + "\t|$" + paymentAmount + "\t|" + quantity + "\t\t|" + screenType + "\t|" + screenId + "\t\t|" + movieTitle + "\t\t\t|" + startTime + "\t\t|");
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

				IntStream.range(0, 150).forEach(i -> System.out.print("-"));
				System.out.println();
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}


	}

	/**
	 * Generates a food sales report for the specified time period.
	 * Reads data from a file and displays it in a tabular format.
	 */
	private void generateFoodSalesReport() {
		/*
		 * The report generated by the generateFoodSalesReport method is formatted as follows:
		 *
		 * 1. The report header is displayed with the following columns:
		 * 	  - Payment ID
		 *    - Date & Time
		 *    - Food Name
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
		 * Payment ID		|Date & Time            |Food Name         |Quantity       |Price
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
			System.out.println("Payment ID\t\t|Date & Time\t\t|Food Name\t\t|Qty\t|Price");
			System.out.println("-----------------------------------------------------------------");
			String line;
			while ((line = reader.readLine()) != null) {
				String orderInfo = line.split(";")[0];
				String orderList = line.split(";")[1];

				String paymentId = orderInfo.split(",")[0];
				LocalDateTime time = LocalDateTime.parse(orderInfo.split(",")[1]);
				String totalPrice = orderInfo.split(",")[2];

				String[] orderArray = orderList.split(",");

				if (orderArray[0].length()<7) {
					int trailing = 7-orderArray[0].length();
					for (int j=0; j<trailing; j++) {
						orderArray[0] += " ";
					}
				}

				if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
					System.out.println(paymentId + "\t\t|" + time + "\t\t|" + orderArray[0] + "\t\t|" + orderArray[1] + "\t\t|$" + orderArray[2]);

					if (orderArray.length > 3) {
						for (int i=3; i<orderArray.length; i+=3) {
							if (orderArray[i].length()<7) {
								int trailing = 7-orderArray[i].length();
								for (int j=0; j<trailing; j++) {
									orderArray[i] += " ";
								}

							}

							System.out.println("\t\t\t\t\t\t\t\t\t|" + orderArray[i] + "\t\t|" + orderArray[i+1] + "\t\t|$" + orderArray[i+2]);
						}
					}
					System.out.println("-----------------------------------------------------------------");
					System.out.println("\t\t\t\t\t\t\t\t\t\t\t\ttotal Price\t|$" + totalPrice);
					System.out.println("-----------------------------------------------------------------");
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
	private void generateInventoryReport() {
		/*
		 * The report generated by the generateInventoryReport method is formatted as follows:
		 *
		 * 1. The report header is displayed with the following columns:
		 *    - Item Name
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
		 * Item Name            |Quantity
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
			System.out.println("Item Name\t\t|Quantity");
			System.out.println("--------------------------------------------------");
			String line;
			while ((line = reader.readLine()) != null) {
				String itemName = line.split(",")[1];
				short quantity = Short.parseShort(line.split(",")[2]);
				System.out.println(itemName + "\t\t\t|" + quantity);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Generates a report of the item order history for the specified time period.
	 * Reads data from a file and displays the item order history.
	 */
	private void generateItemOrderReport() {
		/*
		 * The report generated by the generateItemOrderReport method is formatted as follows:
		 *
		 * 1. The report header is displayed with the following columns:
		 *    - Date & Time
		 *    - Item Name
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
		 * Date & Time             |Item Name            |Quantity Bought |TotalPrice
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
			System.out.println("Date & Time\t\t\t\t\t\t|Name\t\t|Qty\t\t|Total Price");
			IntStream.range(0, 70).forEach(i -> System.out.print("-"));
			System.out.println();
			String line;
			while ((line = reader.readLine()) != null) {
				LocalDateTime time = LocalDateTime.parse(line.split(",")[0]);
				String itemName = line.split(",")[1];
				short quantity = Short.parseShort(line.split(",")[2]);
				short totalPrice = Short.parseShort(line.split(",")[3]);
				if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
					System.out.println(time + "\t|" + itemName + "\t\t|" + quantity + "\t\t|" + totalPrice);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Prompts the user to select and export a report based on the available options.
	 */
	public void exportReport() {
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
				this.exportTicketSalesReport();
				break;
			case 2:
				exportFoodSalesReport();
				break;
			case 3:
				exportInventoryReport();
				break;
			case 4:
				exportItemOrderReport();
				break;
			default:
				System.out.println("No report to be exported!");
		}
	}

	/**
	 * Exports the ticket sales report. (Implementation to be added later.)
	 */
	private void exportTicketSalesReport() {
		// format is the same as generateTicketSalesReport
		String start = this.timePeriodStart.format(formatter);
		String end = this.timePeriodEnd.format(formatter);
		String ticketSalesExportPath = Path.TICKET_SALES_EXPORT_PATH + "TS-" + start + "TO" + end + ".txt";

		File file = new File(ticketSalesExportPath);
		file.getParentFile().mkdirs();

		try (BufferedReader reader = new BufferedReader(new FileReader(Path.TICKET_SALES_REPORT_PATH));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(ticketSalesExportPath, true))) {

			writer.write("Below is the ticket sales report for the specified time period: ");
			writer.newLine();
			writer.write("Payment ID\t\t\t|Timestamp\t\t\t|Total\t|Qty\t|Type\t|Scr ID\t|Movie\t\t\t\t|Start\t\t|Seats\t\t");
			writer.newLine();

            for (int i = 0; i < 150; i++) {
                writer.write("-");
            }

            writer.newLine();
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
					writer.write(paymentId + "\t\t|" + timestamp + "\t|$" + paymentAmount + "\t|" + quantity + "\t\t|" + screenType + "\t|" + screenId + "\t\t|" + movieTitle + "\t\t\t|" + startTime + "\t\t|");
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

				for (int i = 0; i < 150; i++) {
                	writer.write("-");
            	}

				writer.newLine();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Exports the food sales report for the specified time period to a file.
	 */
	private void exportFoodSalesReport() {
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
			writer.write("Payment ID\t\t|Date & Time\t\t|Food Name\t\t|Qty\t|Price");
			writer.newLine();
			writer.write("-----------------------------------------------------------------");
			writer.newLine();
			String line;
			while ((line = reader.readLine()) != null) {
				String orderInfo = line.split(";")[0];
				String orderList = line.split(";")[1];

				String paymentId = orderInfo.split(",")[0];
				LocalDateTime time = LocalDateTime.parse(orderInfo.split(",")[1]);
				String totalPrice = orderInfo.split(",")[2];

				String[] orderArray = orderList.split(",");

				if (orderArray[0].length()<7) {
					int trailing = 7-orderArray[0].length();
					for (int j=0; j<trailing; j++) {
						orderArray[0] += " ";
					}
				}

				if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
					writer.write(paymentId + "\t|" + time + "\t|" + orderArray[0] + "\t\t|" + orderArray[1] + "\t\t|$" + orderArray[2]);
					writer.newLine();

					if (orderArray.length > 3) {
						for (int i=3; i<orderArray.length; i+=3) {

							if (orderArray[i].length()<7) {
								int trailing = 7-orderArray[i].length();
								for (int j=0; j<trailing; j++) {
									orderArray[i] += " ";
								}

							}

							writer.write("\t\t\t\t\t\t\t\t\t|" + orderArray[i] + "\t\t|" + orderArray[i+1] + "\t\t|$" + orderArray[i+2]);
							writer.newLine();
						}
					}
					writer.write("-----------------------------------------------------------------");
					writer.newLine();
					writer.write("\t\t\t\t\t\t\t\t\t\t\t\ttotalPrice\t|$" + totalPrice);
					writer.newLine();
					writer.write("-----------------------------------------------------------------");
					writer.newLine();
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Exports the inventory report to a file for the current time.
	 */
	private void exportInventoryReport() {
		// format is the same as generateInventoryReport
		String timeNow = LocalDateTime.now().format(formatter);
		String inventoryExportFilePath = Path.INVENTORY_EXPORT_PATH + "I-" + timeNow + ".txt";

		File file = new File(inventoryExportFilePath);
		file.getParentFile().mkdirs();

		try (BufferedReader reader = new BufferedReader(new FileReader(Path.INVENTORY_REPORT_PATH));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryExportFilePath, true))){
			writer.write("Below is the content of the inventory as of " + LocalDateTime.now() + ":");
			writer.newLine();
			writer.write("Item Name\t\t|Quantity");
			writer.newLine();
			writer.write("--------------------------------------------------");
			writer.newLine();
			String line;

			while ((line = reader.readLine()) != null) {
				String itemName = line.split(",")[1];
				short quantity = Short.parseShort(line.split(",")[2]);
				writer.write(itemName + "\t\t\t|" + quantity);
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Exports the item order history report to a file for the specified time period.
	 */
	private void exportItemOrderReport() {
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
			writer.write("Date & Time\t\t\t\t\t\t|Name\t\t|Qty\t\t|TotalPrice");
			writer.newLine();
			writer.write("-----------------------------------------------------------------");
			writer.newLine();
			String line;
			while ((line = reader.readLine()) != null) {
				LocalDateTime time = LocalDateTime.parse(line.split(",")[0]);
				String itemName = line.split(",")[1];
				short quantity = Short.parseShort(line.split(",")[2]);
				short totalPrice = Short.parseShort(line.split(",")[3]);
				if (this.hasTimePeriod() && time.isAfter(this.timePeriodStart) && time.isBefore(this.timePeriodEnd)) {
					writer.write(time + "\t|" + itemName + "\t\t|" + quantity + "\t\t|" + totalPrice);
					writer.newLine();
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
