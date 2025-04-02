import java.util.ArrayList;


/** This class manages a collection of movies
 * @author Logan Cordova
 */


public class MovieManager {

    //List to store movies
    private ArrayList<Movie> movies;

    /**
     * Constructor initializes movie list
     */
    public MovieManager() {
        this.movies = new ArrayList<>();
    }

    /**
     * Adds movie to movie list
     * @param movie
     */
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    /**
     * Removes movie from movie list
     * @param movieID
     */
    public void removeMovie(byte movieID) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieID() == movieID) {
                movies.remove(i);
                System.out.println("Movie " + movieID + " has been removed successfully.");
                return;
            }
        }
        System.out.println("Movie not found");
    }

    /**
     * Displays all movies in movie list
     */
    public void displayAllMovies() {
        for (Movie movie : movies) {
            System.out.println("ID: " + movie.getMovieID() + ", Title; " + movie.getTitle() +
                    ", Genre: " + movie.getGenre() + ", Duration: " + movie.getDurationMinutes() + " minutes");
        }
    }

    /**
     * Searches movie list for movie by movie ID
     * @param movieID
     */
    public byte searchMovie(byte movieID) {
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
     * @param movieID
     * @return
     */
    public boolean hasMovieID(byte movieID) {
        for (Movie movie : movies) {
            if (movie.getMovieID() == movieID) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if movie with specific title exists in list
     * @param title
     * @return
     */
    public boolean hasTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if movie with specific genre exists in list
     * @param genre
     * @return
     */
    public boolean hasGenre(String genre) {
        for (Movie movie : movies) {
            if (movie.getGenre().equals(genre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if movie with specific duration exists in movie list
     * @param duration
     * @return
     */
    public boolean hasDuration(int duration) {
        for (Movie movie : movies) {
            if (movie.getDurationMinutes() == duration) {
                return true;
            }
        }
        return false;
    }
}
