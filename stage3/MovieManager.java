import java.util.ArrayList;


/** This class manages a collection of movies
 * @author Logan Cordova
 */


public class MovieManager {
    //List to store movies
    private static ArrayList<Movie> movies = new ArrayList<>();

    /**
     * Constructor initializes movie list
     */
    public MovieManager() {}

    /**
     * Returns array list of movies
     * @return the list of available movies
     */
    public static ArrayList<Movie> getMovies() {
        return movies;
    }
    /**
     * Adds movie to movie list
     * @param movie the movie to be added
     */
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    /**
     * Removes movie from movie list
     * @param movieID the id of the movie to be removed
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
     * @param movieID id of the movie being searched
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
     * @param movieID id of the movie being searched on
     * @return true if the movie exists, otherwise false
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
     * @param title title of the movie
     * @return true if the movie exists
     */
    public boolean hasTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return true;
            }
        }

        return false;
    }
}
