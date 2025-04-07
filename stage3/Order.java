import java.util.*;
import java.util.stream.IntStream;

public class Order {
    protected static Scanner input = new Scanner(System.in);

    protected Order() {}

    protected static boolean askStillContinue() {
        System.out.print("Do you still want to order more? (y/n)");
        char option1 = input.next().charAt(0);

        // if no, then review order, if confirmed, then break out of do-while loop
        // if yes, exits all if statements and iterate from the beginning again
        if (String.valueOf(option1).equalsIgnoreCase("n")) {
            return false;
        }
        return true;
    }
}
