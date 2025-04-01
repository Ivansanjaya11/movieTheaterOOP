/** This class represents a movie within the movie theater
 * @author Logan Cordova
 */

public class Movie {

    private byte movieID;
    private String title;
    private String genre;
    private short durationMinutes;

    /**
     * Constructor initializes Movie object
     * @param movieID - unique movie ID
     * @param title - moive title
     * @param genre - movie genre
     * @param durationMinutes - duration of move
     */
    public Movie(byte movieID, String title, String genre, short durationMinutes) {

        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
    }

    /**
     * Returns movie ID
     * @return
     */
    public byte getMovieID() {
        return movieID;
    }

    /**
     * Returns movie title
     * @return
     */
    public String getTitle() {
        return title;
    }
 
    /**
     * Returns movie genre
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Returns movie duration
     * @return
     */
    public short getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Sets movie title
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets movie genre
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Sets movie duration, in minutes
     * @param durationMinutes
     */
    public void setDurationMinutes(short durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
