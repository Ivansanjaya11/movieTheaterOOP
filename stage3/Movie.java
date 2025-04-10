/** This class represents a movie within the movie theater
 * @author Logan Cordova
 */

public class Movie {

    // Initializes movie variables: ID, title, genre, and duration
    private byte movieID;
    private String title;
    private String genre;
    private short durationMinutes;

    /**
     * Constructor initializes Movie object
     * @param movieID - unique movie ID
     * @param title - movie title
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
     * @return ID of the movie
     */

    public byte getMovieID() {
        return movieID;
    }

    /**
     * Returns movie title
     * @return title of the movie
     */

    public String getTitle() {
        return title;
    }
 
    /**
     * Returns movie genre
     * @return genre of the movie
     */

    public String getGenre() {
        return genre;
    }

    /**
     * Returns movie duration
     * @return duration of the movie in minutes
     */

    public short getDurationMinutes() {
        return durationMinutes;
    }

    /**
     * Sets movie title
     * @param title title of the movie
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets movie genre
     * @param genre genre of the movie
     */

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Sets movie duration, in minutes
     * @param durationMinutes duration of the movie in minutes
     */

    public void setDurationMinutes(short durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
