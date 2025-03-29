/** This class represents a movie within the movie theater
 * @author Logan Cordova
 */

public class Movie {
    //Movie details
    private byte movieID
    private String title
    private String genre
    private short durationMinutes

    //Constructor initializes Movie object
    public Movie(byte movieID, String title, String genre, short durationMinutes) {

        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
    }

    //Retruns movie ID
    public byte getMovieID() {
        return movieID;
    }

    //Returns movie title
    public String getTitle() {
        return title;
    }
 
    //Returns movie genre
    public String getGenre() {
        return genre;
    }

    //Returns movie duriation in minutes
    public short getDurationMinutes() {
        return durationMinutes;
    }

    //Sets movie title
    public void setTitle(String title) {
        this.title = title;
    }

    //Sets movie genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    //Sets movie duration in minutes
    public void setDurationMinutes(short durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}