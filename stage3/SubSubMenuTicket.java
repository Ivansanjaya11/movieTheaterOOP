import java.time.LocalTime;
import java.util.Scanner;

public class SubSubMenuTicket {

    // Initializes scanner for user input
    private static final Scanner input = new Scanner(System.in);

    /**
     * Allows for movie screen to be added to menu list
     */

    public static void addScreenMenu() {

        // Prompts user for screen information to be added to menu
        System.out.print("Enter screen id: ");
        byte id = input.nextByte();
        input.nextLine();
        System.out.print("Enter screen type: (normal/imax) ");
        String type = input.nextLine();

        if (!ScreenManager.contains(id)) {
            ScreenManager.addScreen(new Screen(id, type));
        } else {
            System.out.println("Screen with id " + id + " already exists");
        }
    }

    /**
     * Allows for the selection of and removal of an input movie screen from menu list
     */

    public static void removeScreenMenu() {

        // Checks if screen exists in theater
        if (!ScreenManager.hasScreens()) {
            System.out.println("No screen available!");
            return ;
        }

        System.out.println("Which screen do you want to remove: ");
        byte index;

        for (int i=1; i<=ScreenManager.getScreens().size(); i++) {
            System.out.println(i + ". " + ScreenManager.getScreens().get(i-1).getScreenID());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >= 0 && index < ScreenManager.getScreens().size()) {
            ScreenManager.removeScreen(index);
        } else {
            System.out.println("Screen does not exist!");
        }
    }

    /**
     * Displays screens found within the movie theater
     */

    public static void displayScreen() {

        for (Screen screen : ScreenManager.getScreens()) {
            System.out.println(screen);
        }
    }


    /**
     * Allows for movie to be added to movie menu list
     */

    public static void addMovieMenu() {

        // Prompts user to enter movie information to be added to menu
        System.out.print("Enter movie id: ");

        byte id = input.nextByte();
        input.nextLine();

        System.out.print("Enter movie title: ");
        String title = input.nextLine();

        System.out.print("Enter movie genre: ");
        String genre = input.nextLine();

        System.out.print("Enter duration in minutes: ");
        short duration = input.nextShort();

        if (!MovieManager.contains(id)) {
            MovieManager.addMovie(new Movie(id, title, genre, duration));
        } else {
            System.out.println("Movie with id " + id + " already exists");
        }
    }


    /**
     * Removes movie from movie menu list
     */

    public static void removeMovieMenu() {

        // Checks if movie exists in theater
        if (!MovieManager.hasMovies()) {
            System.out.println("No movie available!");
            return ;
        }

        System.out.println("Which movie do you want to remove: ");
        byte index;

        for (int i=1; i<=MovieManager.getMovies().size(); i++) {
            System.out.println(i + ". " + MovieManager.getMovies().get(i-1).getTitle());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >=0 && index < MovieManager.getMovies().size()) {
            MovieManager.removeMovie(index);
        } else {
            System.out.println("Movie does not exist!");
        }
    }

    public static void updateMovieMenu() {

        // Checks if movie exists in theater
        if (!MovieManager.hasMovies()) {
            System.out.println("No movie available!");
            return ;
        }

        System.out.println("Which movie do you want to update: ");
        byte index;

        for (int i=1; i<=MovieManager.getMovies().size(); i++) {
            System.out.println(i + ". " + MovieManager.getMovies().get(i-1).getTitle());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        System.out.print("Enter movie ID: ");
        byte movieID = input.nextByte();
        input.nextLine();

        System.out.print("Enter movie title: ");
        String title = input.nextLine();

        System.out.print("Enter movie genre: ");
        String genre = input.nextLine();

        System.out.print("Enter movie duration (in minutes): ");
        short durationMinutes = input.nextShort();
        input.nextLine();

        if (index >=0 && index < MovieManager.getMovies().size()) {
            MovieManager.updateMovie(index, new Movie(movieID, title, genre, durationMinutes));
        } else {
            System.out.println("Movie does not exist!");
        }
    }

    /**
     * Displays the movies available at the movie theater
     */

    public static void displayMovie() {

        for (Movie movie : MovieManager.getMovies()) {
            System.out.println(movie);
        }
    }

    /**
     * Provides showtime menu for movie, screen, and time
     */

    public static void addShowtimeMenu() {

        System.out.print("Enter showtime id: ");

        byte id = input.nextByte();
        input.nextLine();

        Movie movie = Prompt.askForMovie();
        Screen screen = Prompt.askForScreen();
        LocalTime time = Prompt.askForTime();

        if (!ShowtimeManager.contains(id)) {
            ShowtimeManager.addShowtime(new Showtime(id, movie, screen, time));
        } else {
            System.out.println("Showtime with id " + id + " already exists");
        }
    }

    /**
     * Removes showtime from menu
     */

    public static void removeShowtimeMenu() {

        // Ensures menu has provided showtime
        if (!ShowtimeManager.hasShowtimes()) {
            System.out.println("No showtime available!");
            return ;
        }

        System.out.print("Which showtime do you want to remove: ");
        byte index;

        // Removes input showtime from menu
        for (int i=1; i<=ShowtimeManager.getShowtimes().size(); i++) {
            Showtime showtime = ShowtimeManager.getShowtimes().get(i-1);
            Movie movie = showtime.getMovie();
            Screen screen = showtime.getScreen();

            System.out.println(i + ". " + movie.getTitle());
            System.out.println("\t" + screen.getScreenType() + " screen");
            System.out.println("\tStarts at " + showtime.getStartTime());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >=0 && index < ShowtimeManager.getShowtimes().size()) {
            ShowtimeManager.removeShowtime(index);
        } else {
            System.out.println("Movie does not exist!");
        }
    }

    /**
     * Displays the showtimes currently available within the movie theater
     */

    public static void displayShowtime() {

        for (Showtime showtime : ShowtimeManager.getShowtimes()) {
            System.out.println(showtime);
        }
    }

}
