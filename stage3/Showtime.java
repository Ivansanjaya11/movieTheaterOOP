/** This class represents a move showtime
 * @author Logan Cordova
 */

public class Showtime {
    
    private int showtimeID;
    private Moive movie;
    private Screen screen;
    private DurationTime screenDurationTime;

    /**
     * Constructs Showtime object
     * @param showtimeID - unique showtime ID
     * @param moivie - movie being shown
     * @param screen - screen where the movie is being shown
     * @param screeningDurationTime - duration of the screening
     */
    public Showtime(int showtimeID, Movie movie, Screen screen, DurationTime screenDurationTime) {
        this.showtimeID = showtimeID;
        this.movie = movie;
        this.screen = screen;
        this.screenDurationTime = screenDurationTime;
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
     * Returns duration of showtime
     * @return 
     */
    public DurationTime getShowtimeDurationTime() {
        return screenDurationTime;
    }
}
