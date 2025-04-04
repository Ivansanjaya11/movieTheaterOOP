/** This class represents a move showtime
 * @author Logan Cordova
 */

public class Showtime {

    private int showtimeID;
    private Movie movie;
    private Screen screen;
    private TimeSchedule startTime;
    private TimeSchedule endTime;

    /**
     * Constructs Showtime object
     * @param showtimeID - unique showtime ID
     * @param movie - movie being shown
     * @param screen - screen where the movie is being shown
     * @param startTime - start time of the screening
     * @param endTime - end time of the screening
     */
    public Showtime(int showtimeID, Movie movie, Screen screen, TimeSchedule startTime, TimeSchedule endTime) {
        this.showtimeID = showtimeID;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns showtime ID
     * @return
     */
    public int getShowtimeID() {
        return showtimeID;
    }

    /**
     * Returns movie
     * @return
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Returns screen
     * @return
     */
    public Screen getScreen() {
        return screen;
    }

    /**
     * Returns start time of showtime
     * @return
     */
    public TimeSchedule getStartTime() {
        return startTime;
    }

    /**
     * Returns end time of showtime
     * @return
     */
    public TimeSchedule getEndTime() {
        return endTime;
    }

    /**
     *
     * @return
     */
    public boolean hasShowtimeID() {
        if (showtimeID > 0) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean hasMovie() {
        if (this.movie != null) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean hasScreen() {
        if (this.screen != null) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean hasStartTime() {
        if (this.startTime != null) {
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean hasEndTime() {
        if (this.endTime != null) {
            return true;
        }
        return false;
    }
}
