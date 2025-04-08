/** This class represents the seating availiable within a movie theater
 * @author Logan Cordova
 */

public class SeatingArrangement {
    
    private boolean[][] seatStatus;
    private static short capacity = 100;
    private static final byte ROWS = (byte) ((capacity / 10) + (capacity % 10 == 0 ? 0 : 1));
    private static final byte COLS = 10;

    public static final String RESET = "\033[0m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";

    /**
     * Constructs a seating arrangement with a set capacity
     */
    public SeatingArrangement() {

        this.seatStatus = new boolean[ROWS][COLS];

        // Initializes all seats as availiable
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seatStatus[i][j] = false;
            }
        }
    }

    /**
     * method to get the row capacity
     * @return
     */
    public byte getRowCapacity() {
        return ROWS;
    }

    /**
     * method to get the column capacity
     * @return
     */
    public byte getColCapacity() {
        return COLS;
    }

    /**
     * Gets status of a specific seat
     * @param row
     * @param col
     * @return
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
     * @param row
     * @param col
     */
    public void setSeatStatus(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat selection.");
            return;
    }
    seatStatus[row][col] = !seatStatus[row][col];
}

    /**
     * Displays current seating arrangement.
     * 'O' represents available, 'X' represents taken
     */
    public void viewSeating() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (getSeatStatus(i, j)) {
                    System.out.print(RED + "X ");
                } else {
                    System.out.print(GREEN + "O ");
                }
                //System.out.print(seatStatus[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
        System.out.print(RESET);
    }

}
 