import java.util.ArrayList;
import java.util.stream.IntStream;

public class OrderTicket extends Order {

    private static DetailTicketBought showTicketOptionToAdd(DetailTicketBought detail, ArrayList<Movie> movieList) {
        System.out.println("Select movie: ");
        Movie selectedMovie = null;

        for (Movie movie : movieList) {
            System.out.print(movie.getMovieID() + ". ");
            System.out.println(movie.getTitle());
            System.out.println("\tMovie duration: " + movie.getDurationMinutes() + " minutes");
            System.out.println("\tMovie genre: " + movie.getGenre());

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

        ArrayList<Showtime> showtimeList = ShowtimeManager.getShowtimes();
        System.out.println("Normal screen price: $" + detail.getNormalPrice());
        System.out.println("Imax screen price: $" + detail.getImaxPrice());

        System.out.println("Here is the schedule for the movie '" + selectedMovie.getTitle() + "':");

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        for (Showtime showtime : showtimeList) {
            if (showtime.getMovie() == selectedMovie) {
                Screen aScreen = showtime.getScreen();
                System.out.println("Showtime ID #" + showtime.getShowtimeID());
                System.out.println("Screen room # " + aScreen.getScreenID());
                System.out.println("Screen type: " + aScreen.getScreenType());
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
                seatings.setSeatStatus(rowNum-1, colNum-1);
                byte[] aSeat = {(byte) ( rowNum-1), (byte) (colNum-1)};
                chosenSeats.add(aSeat);
                if (showtime.getScreen().getScreenType().equals("normal")) {
                    detail.addNormalNum();
                } else {
                    detail.addImaxNum();
                }
            }

            System.out.print("Select another seat? (y/n) ");

            if (input.next().equalsIgnoreCase("n")){
                break;
            }

        } while (true);

        detail.setChosenSeats(chosenSeats);

        return detail;
    }

    private static DetailTicketBought removeTicketOrder(DetailTicketBought detail) {
        detail.setImaxNum((byte) 0);
        detail.setNormalNum((byte) 0);
        return detail;
    }

    private static boolean reviewTicketOrder(DetailTicketBought detail) {
        Showtime showtime = detail.getShowtime();
        ArrayList<byte[]> chosenSeats = detail.getChosenSeats();
        byte normalPrice = detail.getNormalPrice();
        byte imaxPrice = detail.getImaxPrice();
        byte quantity = (byte) (detail.getImaxNum() + detail.getNormalNum());

        Movie aMovie = showtime.getMovie();
        Screen aScreen = showtime.getScreen();

        System.out.println(quantity + " tickets of Movie '" + aMovie.getTitle() + "'.");
        System.out.println("Screen room #" + aScreen.getScreenID() + "; type: " + aScreen.getScreenType());

        System.out.print("The price for each ticket is $");
        if (aScreen.getScreenType() == "normal") {
            System.out.println(normalPrice);
        } else {
            System.out.println(imaxPrice);
        }

        System.out.println("The following is the seats you ordered:");
        for (byte[] aSeat : chosenSeats) {
            System.out.println("\t- Seat at (" + (aSeat[0] + 1) + ", " + (aSeat[1] + 1) + ")");
        }

        System.out.print("Is this correct? (y/n)");

        char option = input.next().charAt(0);

        // if yes then return true, otherwise, false
        if (String.valueOf(option).equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

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

        if (detail.isEmpty()) {
            return null;
        }

        return detail;
    }

    private static DetailTicketBought resetTicketSeats(DetailTicketBought detail) {
        ArrayList<byte[]> chosenSeats = detail.getChosenSeats();
        Showtime showtime = detail.getShowtime();

        Screen aScreen = showtime.getScreen();
        SeatingArrangement seatings = aScreen.getSeating();

        for (byte[] aSeat : chosenSeats) {
            seatings.setSeatStatus(aSeat[0], aSeat[1]);
        }

        return detail;
    }}
