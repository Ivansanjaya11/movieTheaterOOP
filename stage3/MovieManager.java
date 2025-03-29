import java.util.ArrayList;

/** This class manages a collection of movies
 * @author Logan Cordova
 */


public class MovieManager {
    
    //List to store movies
    private ArrayList<Movie> movies;

    //Constructor initializes movie list
    public MovieManager() {
        this.movies = new ArrayList<>();
    }

    //Adds movie to movie list
    public addMovie(Movie movie) {
        movies.add(movie); 
    }

    //Removes movie from movie list
    public removeMovie(byte movieID) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieID() == movieID) {
                movies.remove(i);
                System.out.println("Movie " + movieID + " has been removed successfully.");
                return;
            }
        }
        System.out.println("Movie not found");
    }   

    //Displays all movies in movie list
    public void displayAllMovies() {
        for (Movie movie : movies) {
            System.out.println("ID: " + movie.getMovieID() + ", Title; " + movie.getTitle() + 
            ", Genre: " + movie.getGenre() + ", Duration: " + movie.getDurationMinutes() + " minutes");
        }
    }
 
    //Searches for movie in movie list
    public movieSearch(byte movieID) {
        for (Movie movie : movies) {
            if (movie.getMovieID() == movieID) {
                return movie;
            }
        }
        System.out.println("Movie not found");
    }
}
