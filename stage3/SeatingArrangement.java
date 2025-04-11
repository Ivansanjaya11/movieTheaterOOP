/** This class represents the seating available within a movie theater
 * @author Logan Cordova
 */

public class SeatingArrangement {

    // Initializes Seating chart with final variables
    private final boolean[][] seatStatus;

    private static final byte ROWS = 10;
    private static final byte COLS = 10;

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";

    /**
     * Constructs a seating arrangement with a set capacity
     */

    public SeatingArrangement() {

        this.seatStatus = new boolean[ROWS][COLS];

        // Initializes all seats as available
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seatStatus[i][j] = false;
            }
        }
    }

    /**
     * method to get the max row capacity
     * @return max capacity of row
     */

    public byte getRowCapacity() {
        return ROWS;
    }

    /**
     * method to get the column capacity
     * @return max capacity of column
     */

    public byte getColCapacity() {
        return COLS;
    }

    /**
     * Gets status of a specific seat
     * @param row row position
     * @param col column position
     * @return the current status of the seat
     */

    public boolean getSeatStatus(int row, int col) {

        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat selection.");
            return false;
        }

        return seatStatus[row][col];
    }

    /**
     * Sets status of a specific seat
     * @param row row position
     * @param col column position
     */

    public void setSeatStatus(int row, int col) {

        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat selection.");
        } else {
            // flips the status of the seat
            seatStatus[row][col] = !seatStatus[row][col];
        }
    }


    /**
     * Displays current seating arrangement.
     * 'O' represents available, 'X' represents taken
     */

    public void viewSeating() {

        for (int i = 0; i < ROWS; i++) {

            for (int j = 0; j < COLS; j++) {
                if (getSeatStatus(i, j)) {
                    System.out.print(RED + "X "); // prints in red for taken
                } else {
                    System.out.print(GREEN + "O "); // prints in green for available
                }
            }

            System.out.println(); // create line for the next row
        }

        System.out.print(RESET); // resets the console text printing color
    }

}
 