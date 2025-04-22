package stage4.TicketRelated;

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.util.Color;
import stage4.util.LogPrinter;
import stage4.util.LogType;
import stage4.util.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


/** This class manages a collection of movies
 * @author Logan Cordova
 */


public class MovieManager {

    //List to store movies
    private static final ArrayList<Movie> movies = new ArrayList<>();

    private static final File movieFile = new File(Path.MOVIE_DATA_PATH);

    /**
     * Constructor initializes movie list
     */
    private MovieManager() {}

    static {
           if (movieFile.length() != 0) {

               try (BufferedReader reader = new BufferedReader(new FileReader(Path.MOVIE_DATA_PATH))) {
                   String line;

                   while ((line = reader.readLine()) != null) {
                       String[] movieInfo = line.trim().split(",");

                       byte movieId = Byte.parseByte(movieInfo[0].trim());
                       String movieName = movieInfo[1].trim();
                       String movieGenre = movieInfo[2].trim();
                       short movieDuration = Short.parseShort(movieInfo[3].trim());

                       movies.add(new Movie(movieId, movieName, movieGenre, movieDuration));

                       LogPrinter.println(Color.GREEN, Color.GREEN, LogType.NEW_MOVIE, movieName + " added from the database!");
                       //System.out.println("movie '" + movieName + "' added from database!");
                   }

               } catch (Exception e) {
                   LogPrinter.println(Color.RED, Color.RED, LogType.ERROR, e.getMessage());
                   //System.err.println(e.getMessage());
               }

           }
    }

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
        return new ArrayList<>(movies);
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

        if (!contains(movie.getMovieID())) {
            movies.add(movie);
            LogPrinter.println(Color.GREEN, Color.GREEN, LogType.NEW_MOVIE, movie.getTitle() + " added!");
            //System.out.println("movie '" + movie.getTitle() + "' has been added!");
            FilesUpdateManager.updateMovieDataFile(new ArrayList<>(movies));
        } else {
            LogPrinter.println(Color.WHITE, Color.WHITE, LogType.EXIST_MOVIE, movie.getTitle() + " already exists!");
            //System.out.println("movie '" + movie.getTitle() + "' already exists!");
        }
    }

    /**
     * Removes movie from movie list
     * @param idx index of the movie
     */
    public static void removeMovie(byte idx) {
        if (hasMovies()) {
            Movie movieToBeRemoved = movies.get(idx);
            movies.remove(idx);

            LogPrinter.println(Color.CYAN, Color.CYAN, LogType.REMOVE_MOVIE, movieToBeRemoved.getTitle() + " removed!");

            FilesUpdateManager.updateMovieDataFile(new ArrayList<>(movies));
            //System.out.println("Movie '" + movieToBeRemoved.getTitle() + "' has been removed successfully.");
        } else {
            LogPrinter.println(Color.WHITE, Color.WHITE, LogType.NOT_EXIST_FOOD, "movie list is empty!");
        }
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
    public static Movie searchMovie(byte movieID) {

        for (Movie movie : movies) {
            if (movie.getMovieID() == movieID) {
                LogPrinter.println(Color.WHITE, Color.WHITE, LogType.EXIST_MOVIE, movie.getTitle() + " found!");
                return movie;
            }
        }


        LogPrinter.println(Color.WHITE, Color.WHITE, LogType.NOT_EXIST_MOVIE, "movie not found!");
        //System.out.println("Movie not found");
        return null;
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

    /**
     * updates the movie in the list of movies
     * @param index the position of the movie in the list
     * @param movie the new movie to replace the old one
     */
    public static void updateMovie(byte index, Movie movie) {
        movies.set(index, movie);

        LogPrinter.println(Color.MAGENTA, Color.MAGENTA, LogType.UPDATE_MOVIE, movie.getTitle() + " updated!");
    }
}
