import java.util.ArrayList;


/** This class manages a collection of movies
 * @author Logan Cordova
 */


public class MovieManager {

    //List to store movies
    private static final ArrayList<Movie> movies = new ArrayList<>();

    /**
     * Constructor initializes movie list
     */

    private MovieManager() {}

    /**
     * Ensures movie list has movies
     * @return true / false
     */

    public static boolean hasMovies() {

        return !movies.isEmpty();
    }

    /**
     * Returns array list of movies
     * @return the list of available movies
     */

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    /**
     * Checks if movie list contains input movie ID
     * @param id of movie
     * @return true / false
     */

    public static boolean contains(byte id) {

        for (Movie movie : movies) {
            if (movie.getMovieID() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds movie to movie list
     * @param movie the movie to be added
     */

    public static void addMovie(Movie movie) {
        movies.add(movie);
    }

    /**
     * Removes movie from movie list
     * @param idx index of the movie
     */

    public static void removeMovie(byte idx) {

        movies.remove(idx);
        System.out.println("Movie has been removed successfully.");
    }

    /**
     * Displays all movies in movie list
     */

    public static void displayAllMovies() {

        for (Movie movie : movies) {
            System.out.println("ID: " + movie.getMovieID() + ", Title; " + movie.getTitle() +
                    ", Genre: " + movie.getGenre() + ", Duration: " + movie.getDurationMinutes() + " minutes");
        }
    }

    /**
     * Searches movie list for movie by movie ID
     * @param movieID id of the movie being searched
     */

    public static byte searchMovie(byte movieID) {

        for (Movie movie : movies) {
            if (movie.getMovieID() == movieID) {
                return movieID;
            }
        }

        System.out.println("Movie not found");
        return -1;
    }

    /**
     * Checks if movie with specific movie ID exists in list
     * @param movieID id of the movie being searched on
     * @return true if the movie exists, otherwise false
     */

    public static boolean hasMovieID(byte movieID) {

        for (Movie movie : movies) {
            if (movie.getMovieID() == movieID) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if movie with specific title exists in list
     * @param title title of the movie
     * @return true if the movie exists
     */

    public static boolean hasTitle(String title) {

        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
    }
}
