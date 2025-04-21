package stage4.TicketRelated;

import java.time.LocalTime;

/** This class represents a move showtime
 * @author Logan Cordova
 */

public class Showtime {

    //Initializes variables for movie showtimes
    private byte showtimeID;
    private Movie movie;
    private Screen screen;
    private LocalTime startTime;
    private LocalTime endTime;

    /**
     * Constructs stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Showtime object
     * @param showtimeID - unique showtime ID
     * @param movie - movie being shown
     * @param screen - screen where the movie is being shown
     * @param startTime - start time of the screening
     */
    public Showtime(byte showtimeID, Movie movie, Screen screen, LocalTime startTime) {

        this.showtimeID = showtimeID;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = this.startTime.plusMinutes(this.movie.getDurationMinutes());
    }

    /**
     * Returns showtime ID
     * @return the showtime ID
     */
    public byte getShowtimeID() {
        return this.showtimeID;
    }

    /**
     * Returns movie
     * @return the movie displayed during that showtime (schedule)
     */
    public Movie getMovie() {
        return this.movie;
    }

    /**
     * Returns screen
     * @return the screen (specific room) where the movie is displayed
     */
    public Screen getScreen() {
        return this.screen;
    }

    /**
     * Returns start time of showtime
     * @return the starting time of the showtime
     */
    public LocalTime getStartTime() {
        return this.startTime;
    }

    /**
     * Returns end time of showtime
     * @return end time of the showtime
     */
    public LocalTime getEndTime() {
        return this.endTime;
    }

    /**
     * checks if the showtime has a showtime ID
     * @return true if the ID is set, otherwise false
     */
    public boolean hasShowtimeID() {

        if (this.showtimeID > 0) {
            return true;
        }

        return false;
    }

    /**
     * checks if the showtime has a movie assigned to it
     * @return true if the movie has been set, otherwise false
     */
    public boolean hasMovie() {

        if (this.movie != null) {
            return true;
        }

        return false;
    }

    /**
     * checks if the showtime has a screen assigned to it
     * @return true if the screen has been set, otherwise false
     */
    public boolean hasScreen() {

        if (this.screen != null) {
            return true;
        }
        return false;
    }

    /**
     * checks if the showtime has a starting time set
     * @return true if starting time has been set, otherwise false
     */
    public boolean hasStartTime() {

        if (this.startTime != null) {
            return true;
        }

        return false;
    }

    /**
     * checks if the showtime has an end time set
     * @return true if end time has been set, otherwise false
     */
    public boolean hasEndTime() {

        if (this.endTime != null) {
            return true;
        }

        return false;
    }

    /**
     * Returns a string representation of a movie's showtime with the stage4.TicketRelated.Showtime ID, stage4.TicketRelated.Movie Title, stage4.TicketRelated.Screen, and Start time
     * @return showtime string
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Showtime ID: #" + this.showtimeID;
        str = str + "\n\t" + "stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Movie: " + this.movie.getTitle();
        str = str + "\n\t" + "Displayed on " + this.screen;
        str = str + "\n\t" + "Show starts at " + this.startTime;

        return str;
    }

}
