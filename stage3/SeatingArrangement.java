/** This class represents the seating availiable within a movie theater
 * @author Logan Cordova
 */

public class SeatingArrangement {
    
    private boolean[][] seatStatus;
    private static short capacity = 100;
    private static final int ROWS = (capacity / 10) + (capacity % 10 == 0 ? 0 : 1);
    private static final int COLS = 10;

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
     * @param status
     */
    public void setSeatStatus(int row, int col, boolean status) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat selection.");
            return;
    }
    seatStatus[row][col] = status;
}

    /**
     * Displays current seating arrangement.
     * 'O' represents available, 'X' represents taken
     */
    public void viewSeating() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seatStatus[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

}
 