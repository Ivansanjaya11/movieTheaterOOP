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

    private static byte askTicketQuantityToAdd(Showtime showtime) {
        byte seatingCount = 0;

        Screen aScreen = showtime.getScreen();
        SeatingArrangement seatings = aScreen.getSeating();


        do {
            seatings.viewSeating();
            byte rowNum = input.nextByte();
            byte colNum = input.nextByte();

            if (rowNum >= 1 && rowNum <= seatings.getRowCapacity() && colNum >= 1 && colNum <= seatings.getColCapacity()) {
                seatingCount++;
                //change the status of the seat
            }

            System.out.print("Select another seat? (y/n) ");

            if (input.next().equalsIgnoreCase("n")){
                break;
            }

        } while (true);

        return seatingCount;
    }

    private static byte[] updateNumTickets(Showtime showtime, byte quantity) {

    }

    private static byte[] showOptionToRemove(byte[] orderedTicket) {

    }

    private static boolean reviewTicketOrder(Showtime showtime, byte[] orderedTicket) {

    }

    public static byte[] takeTicketOrder(byte normalPrice, byte imaxPrice) {
        byte[] orderedTicket = new byte[2];

        Showtime showtime = null;

        do {
            System.out.println("Choose:");
            System.out.println("1. Add order");
            System.out.println("2. Remove order");
            byte addOrRemove = input.nextByte();

            if (addOrRemove == 1) {
                showtime = showTicketOptionToAdd(MovieManager.getMovies(), normalPrice, imaxPrice);
                byte quantity = askTicketQuantityToAdd(showtime);
                orderedTicket = updateNumTickets(showtime, quantity);

                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(showtime, orderedTicket);
                    if (isCorrect) {
                        break;
                    }
                }
            } else {
                orderedTicket = showOptionToRemove(orderedTicket);
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(showtime, orderedTicket);
                    if (isCorrect) {
                        break;
                    }
                }
            }
        } while(true);

        return orderedTicket;
    }

    public static void reviewTicketOrder() {

    }




    private static Food showOptionToAdd(ArrayList<Food> menuList) {
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
    } byte

    private static byte askQuantityToAdd() {
        System.out.print("How many do you want? ");
        byte quantity = input.nextByte();
        if (quantity > 0) {
            return quantity;
        }
        return -1;
    }

    private static TreeMap<Food, Byte> showOptionToRemove(TreeMap<Food, Byte> orderedFood) {
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
                Food aFood = showOptionToAdd(menuList);

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
                orderedFood = showOptionToRemove(orderedFood);

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
