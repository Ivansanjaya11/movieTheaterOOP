package stage4.OrdersAndPayment;

import stage4.TicketRelated.*;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class OrderTicket extends Order {

    private OrderTicket() {
        super();
    }

    /**
     *
     * @param detail of movie ticket
     * @param movieList of movies
     * @return movieID, movieTitle, movie duration, movie genre
     */
    private static DetailTicketBought showTicketOptionToAdd(DetailTicketBought detail, ArrayList<Movie> movieList) {

        System.out.println("Select movie: ");
        Movie selectedMovie = null;

        for (Movie movie : movieList) {
            System.out.print(movie.getMovieID() + ". ");
            System.out.println(movie.getTitle());
            System.out.println("\tstage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Movie duration: " + movie.getDurationMinutes() + " minutes");
            System.out.println("\tstage4.TicketRelated.Movie genre: " + movie.getGenre());

        }

        byte ticketOption = input.nextByte();

        if (ticketOption >= 1 && ticketOption <= movieList.size()) {
            for (Movie aMovie : movieList) {
                if (aMovie.getMovieID() == ticketOption) {
                    selectedMovie = aMovie;
                    break;
                }
            }
        }

        // Normal and IMAX screen prices
        ArrayList<Showtime> showtimeList = ShowtimeManager.getShowtimes();
        System.out.println("Normal screen price: $" + detail.getNormalPrice());
        System.out.println("Imax screen price: $" + detail.getImaxPrice());

        System.out.println("Here is the schedule for the movie '" + selectedMovie.getTitle() + "':");

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        // List of movie show times and details
        for (Showtime showtime : showtimeList) {
            if (showtime.getMovie() == selectedMovie) {
                Screen aScreen = showtime.getScreen();
                System.out.println("stage4.TicketRelated.Showtime ID #" + showtime.getShowtimeID());
                System.out.println("stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Screen room # " + aScreen.getScreenID());
                System.out.println("stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Screen type: " + aScreen.getScreenType());
                System.out.println("Start time: " + showtime.getStartTime().toString());
                System.out.println("End time: " + showtime.getEndTime().toString());

                IntStream.range(0, 25).forEach(i -> System.out.print("-"));
                System.out.println();
            }
        }

        System.out.println("Enter the showtime ID you want:");

        byte showtimeOption = input.nextByte();

        if (showtimeOption >= 1 && showtimeOption <= showtimeList.size()) {
            for (Showtime showtime : showtimeList) {
                if (showtime.getShowtimeID() == showtimeOption) {
                    detail.setShowtime(showtime);
                    return detail;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param detail of showtime, screen, and seating
     * @return details of purchased ticket: showtime, screen, and seating
     */
    private static DetailTicketBought askTicketQuantityToAdd(DetailTicketBought detail) {

        Showtime showtime = detail.getShowtime();
        Screen aScreen = showtime.getScreen();
        SeatingArrangement seatings = aScreen.getSeating();

        ArrayList<byte[]> chosenSeats = new ArrayList<>();

        do {
            seatings.viewSeating();
            byte rowNum = input.nextByte();
            byte colNum = input.nextByte();

            if (rowNum >= 1 && rowNum <= seatings.getRowCapacity() && colNum >= 1 && colNum <= seatings.getColCapacity()) {

                if (detail.checkSeat(rowNum, colNum)) {
                    System.out.println("Seat is occupied!");
                } else {
                    seatings.setSeatStatus(rowNum-1, colNum-1);
                    byte[] aSeat = {(byte) ( rowNum-1), (byte) (colNum-1)};
                    chosenSeats.add(aSeat);
                    if (showtime.getScreen().getScreenType().equals("normal")) {
                        detail.addNormalNum();
                    } else {
                        detail.addImaxNum();
                    }
                }

            } else {
                System.out.println("Invalid seating position!");
            }

            System.out.print("Select another seat? (y/n) ");

            if (input.next().equalsIgnoreCase("n")){
                break;
            }

        } while (true);

        detail.setChosenSeats(chosenSeats);

        return detail;
    }

    /**
     * Removes customer ticket order
     * @param detail of customer selcted movie
     * @return removed movie ticket details
     */
    private static DetailTicketBought removeTicketOrder(DetailTicketBought detail) {

        detail.setImaxNum((byte) 0);
        detail.setNormalNum((byte) 0);
        return detail;
    }

    /**
     * Allows users to look over their movie ticket selection
     * @param detail of purchased ticket
     * @return showtime, seating, price, and quantity
     */
    private static boolean reviewTicketOrder(DetailTicketBought detail) {

        Showtime showtime = detail.getShowtime();
        ArrayList<byte[]> chosenSeats = detail.getChosenSeats();
        byte normalPrice = detail.getNormalPrice();
        byte imaxPrice = detail.getImaxPrice();
        byte quantity = (byte) (detail.getImaxNum() + detail.getNormalNum());

        Movie aMovie = showtime.getMovie();
        Screen aScreen = showtime.getScreen();

        // Prints movie ticke details
        System.out.println(quantity + " tickets of stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Movie '" + aMovie.getTitle() + "'.");
        System.out.println("stage4.TicketRelated.Screen room #" + aScreen.getScreenID() + "; type: " + aScreen.getScreenType());

        System.out.print("The price for each ticket is $");

        // Prices for normal / IMAX movie screen
        if (aScreen.getScreenType() == "normal") {
            System.out.println(normalPrice);
        } else {
            System.out.println(imaxPrice);
        }

        // User selected seat
        System.out.println("The following is the seats you ordered:");

        for (byte[] aSeat : chosenSeats) {
            System.out.println("\t- Seat at (" + (aSeat[0] + 1) + ", " + (aSeat[1] + 1) + ")");
        }

        // Asks if user choice is correct
        System.out.print("Is this correct? (y/n)");

        char option = input.next().charAt(0);

        // if yes then return true, otherwise, false
        if (String.valueOf(option).equalsIgnoreCase("y")) {
            return true;
        }

        return false;
    }

    /**
     * Method that prompts and takes user movie ticket order
     * @param detail of ticket and ticket quantity
     * @return ticket order and quantity
     */
    public static DetailTicketBought takeTicketOrder(DetailTicketBought detail) {

        do {
            System.out.println("Choose:");
            System.out.println("1. Add order");
            System.out.println("2. Remove order");
            byte addOrRemove = input.nextByte();

            if (addOrRemove == 1) {
                detail = showTicketOptionToAdd(detail, MovieManager.getMovies());
                detail = askTicketQuantityToAdd(detail);

                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(detail);
                    if (isCorrect) {
                        break;
                    }
                }
            } else {
                detail = removeTicketOrder(detail);
                detail = resetTicketSeats(detail);
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(detail);
                    if (isCorrect) {
                        break;
                    }
                }
            }
        } while(true);

        return detail;
    }

    /**
     * Resets user selected seat if they choose to remove or change their seat
     * @param detail of selected seat, showtime of movie, and screen where seat is
     * @return details regarding user seating choice
     */
    private static DetailTicketBought resetTicketSeats(DetailTicketBought detail) {

        ArrayList<byte[]> chosenSeats = detail.getChosenSeats();
        Showtime showtime = detail.getShowtime();

        Screen aScreen = showtime.getScreen();
        SeatingArrangement seatings = aScreen.getSeating();

        for (byte[] aSeat : chosenSeats) {
            seatings.setSeatStatus(aSeat[0], aSeat[1]);
        }

        return detail;
    }

}