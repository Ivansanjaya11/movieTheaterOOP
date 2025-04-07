import java.util.*;
import java.util.stream.IntStream;

public class Order {
    protected static Scanner input = new Scanner(System.in);

    private Order() {}

    private static Showtime showTicketOptionToAdd(ArrayList<Movie> movieList, byte normalPrice, byte imaxPrice) {
        System.out.println("Select movie: ");
        Movie selectedMovie = null;

        for (Movie movie : movieList) {
            System.out.print(movie.getMovieID() + ". ");
            System.out.println(movie.getTitle());
            System.out.println("\tMovie duration: " + selectedMovie.getDurationMinutes());
            System.out.println("\tMovie genre: " + selectedMovie.getGenre());

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
        System.out.println("Here is the schedule for the movie '" + selectedMovie.getTitle() + "':");
        System.out.println("Normal screen price: $" + normalPrice);
        System.out.println("Imax screen price: $" + imaxPrice);

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        for (Showtime showtime : showtimeList) {
            if (showtime.getMovie().getMovieID() == selectedMovie.getMovieID()) {
                Screen aScreen = showtime.getScreen();
                System.out.println("Screen room # " + aScreen.getScreenID());
                System.out.println("Screen type: " + aScreen.getScreenType());
                System.out.println("Start time: " + showtime.getStartTime().toString());
                System.out.println("End time: " + showtime.getEndTime().toString());

                IntStream.range(0, 25).forEach(i -> System.out.print("-"));
                System.out.println();
            }
        }

        byte showtimeOption = input.nextByte();
        if (showtimeOption >= 1 && showtimeOption <= showtimeList.size()) {
            for (Showtime showtime : showtimeList) {
                if (showtime.getShowtimeID() == showtimeOption) {
                    return showtime;
                }
            }
        }
        return null;
    }

    private static ArrayList<byte[]> askTicketQuantityToAdd(Showtime showtime) {

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
            }

            System.out.print("Select another seat? (y/n) ");

            if (input.next().equalsIgnoreCase("n")){
                break;
            }

        } while (true);

        return chosenSeats;
    }

    private static byte[] updateNumTickets(Showtime showtime, byte quantity) {
        if (showtime.getScreen().getScreenType().equals("normal")) {
            return new byte[]{quantity, 0};
        } else {
            return new byte[]{0, quantity};
        }
    }

    private static byte[] removeTicketOrder(byte[] orderedTicket) {
        return new byte[]{0, 0};
    }

    private static boolean reviewTicketOrder(Showtime showtime, ArrayList<byte[]> chosenSeats, byte quantity, byte normalPrice, byte imaxPrice) {
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
            System.out.println("\t- Seat at (" + aSeat[0] + ", " + aSeat[1] + ")");
        }

        System.out.print("Is this correct? (y/n)");

        char option = input.next().charAt(0);

        // if yes then return true, otherwise, false
        if (String.valueOf(option).equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    public static ArrayList<byte[]> takeTicketOrder(byte normalPrice, byte imaxPrice) {
        byte[] orderedTicket = new byte[2];

        Showtime showtime = null;

        ArrayList<byte[]> chosenSeats = null;

        byte quantity = 0;

        do {
            System.out.println("Choose:");
            System.out.println("1. Add order");
            System.out.println("2. Remove order");
            byte addOrRemove = input.nextByte();

            if (addOrRemove == 1) {
                showtime = showTicketOptionToAdd(MovieManager.getMovies(), normalPrice, imaxPrice);
                chosenSeats = askTicketQuantityToAdd(showtime);
                quantity = (byte) chosenSeats.size();
                orderedTicket = updateNumTickets(showtime, quantity);

                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(showtime, chosenSeats, quantity, normalPrice, imaxPrice);
                    if (isCorrect) {
                        break;
                    }
                }
            } else {
                orderedTicket = removeTicketOrder(orderedTicket);
                chosenSeats = resetTicketSeats(chosenSeats, showtime);
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(showtime, chosenSeats, quantity, normalPrice, imaxPrice);
                    if (isCorrect) {
                        break;
                    }
                }
            }
        } while(true);

        if (orderedTicket[0] == 0 && orderedTicket[1] == 0) {
            return null;
        }

        chosenSeats.add(orderedTicket);

        return chosenSeats;
    }

    private static ArrayList<byte[]> resetTicketSeats(ArrayList<byte[]> chosenSeats, Showtime showtime) {
        Screen aScreen = showtime.getScreen();
        SeatingArrangement seatings = aScreen.getSeating();

        for (byte[] aSeat : chosenSeats) {
            seatings.setSeatStatus(aSeat[0], aSeat[1]);
        }

        return new ArrayList<>();
    }

    private static Food showFoodOptionToAdd(ArrayList<Food> menuList) {
        System.out.println("Choose from the following menu: ");
        for (Food food : menuList) {
            System.out.print(food.getMenuId() + ". ");
            System.out.print(food.getMenuName() + ": $");
            System.out.println(food.getPrice());
        }
        byte menuOption = input.nextByte();
        if (menuOption >= 1 && menuOption <= menuList.size()) {
            for (Food aFood : menuList) {
                if (aFood.getMenuId() == menuOption) {
                    return aFood;
                }
            }
        } else {
            System.out.println("There is no such item in the menu!");
        }
        return null;
    }

    private static byte askQuantityToAdd() {
        System.out.print("How many do you want? ");
        byte quantity = input.nextByte();
        if (quantity > 0) {
            return quantity;
        }
        return -1;
    }

    private static TreeMap<Food, Byte> showFoodOptionToRemove(TreeMap<Food, Byte> orderedFood) {
        if (!orderedFood.isEmpty()) {
            System.out.print("Choose which one to remove: ");
            byte j = 1;

            // list all ordered food to choose which to remove from order
            for (Food aFood : orderedFood.keySet()) {
                System.out.print(j + ". ");
                System.out.print(aFood.getMenuName() + ": ");
                System.out.println(orderedFood.get(aFood));
            }

            byte removeOption = input.nextByte();
            if (removeOption >= 1 && removeOption <= orderedFood.size()) {

                byte idx = 1;
                Map.Entry<Food, Byte> foodToRemove = null;
                Iterator<Map.Entry<Food, Byte>> iter = orderedFood.entrySet().iterator();

                while (idx < removeOption) {
                    foodToRemove = iter.next();
                }

                orderedFood.remove(foodToRemove.getKey());
            } else {
                System.out.println("There is no such item in your order!");
            }
        } else {
            System.out.println("You haven't ordered anything yet!");
        }

        return orderedFood;
    }

    private static boolean askStillContinue() {
        System.out.print("Do you still want to order more? (y/n)");
        char option1 = input.next().charAt(0);

        // if no, then review order, if confirmed, then break out of do-while loop
        // if yes, exits all if statements and iterate from the beginning again
        if (String.valueOf(option1).equalsIgnoreCase("n")) {
            return false;
        }
        return true;
    }

    public static TreeMap<Food, Byte> takeFoodOrder() {
        TreeMap<Food, Byte> orderedFood = new TreeMap<>();

        ArrayList<Food> menuList = MenuManager.getMenuList();

        do {
            System.out.println("Choose:");
            System.out.println("1. Add order");
            System.out.println("2. Remove order");
            byte addOrRemove = input.nextByte();

            // add order
            if (addOrRemove==1) {
                // ask the user to choose from a list of food menu
                Food aFood = showFoodOptionToAdd(menuList);

                // ask for order quantity
                byte quantity = askQuantityToAdd();

                // set the ordered food and quantity to a tree map and store to array list of ordered food
                orderedFood.put(aFood, quantity);

                // ask if user still wants to order
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewFoodOrder(orderedFood);
                    if (isCorrect) {
                        break;
                    }
                }

            // remove order
            } else {
                // remove the order
                orderedFood = showFoodOptionToRemove(orderedFood);

                // ask if the user still wants to order
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewFoodOrder(orderedFood);
                    if (isCorrect) {
                        break;
                    }
                }

            }
        } while (true);

        if (orderedFood.isEmpty()) {
            return null;
        }

        return orderedFood;
    }

    /**
     * Reviews the customer's order to confirm if it is correct.
     *
     * @return true if the order is correct, false otherwise
     */
    private static boolean reviewFoodOrder(TreeMap<Food, Byte> orderedFood) {
        // print out the ordered food one by one
        byte i = 1;
        for (Food aFood : orderedFood.keySet()) {
            System.out.print(i + ". ");
            System.out.print(aFood.getMenuName() + ": ");
            System.out.println(orderedFood.get(aFood));
        }

        // ask the user if the order is correct
        System.out.print("Is this correct? (y/n)");
        char option = input.next().charAt(0);

        // if yes then return true, otherwise, false
        if (String.valueOf(option).equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }
}
