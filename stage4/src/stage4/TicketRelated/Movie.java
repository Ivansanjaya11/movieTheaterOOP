package stage4.TicketRelated;

/** This class represents a movie within the movie theater
 * @author Logan Cordova
 */

public class Movie {

    private byte movieID;
    private String title;
    private String genre;
    private short durationMinutes;

    /**
     * Constructor initializes stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Movie object
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

    /**
     * Returns a string representation of a movie with the title, genre, and duration of the movie
     * @return movie string
     */
    @Override
    public String toString() {
        String str = "";

        str = str + "stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Movie title: " + this.title;
        str = str + "\n\tgenre: " + this.genre;
        str = str + "\n\tduration: " + this.durationMinutes;

        return str;
    }

}
