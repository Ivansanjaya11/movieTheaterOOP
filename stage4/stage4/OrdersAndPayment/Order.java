package stage4.OrdersAndPayment;

import java.util.Scanner;

public class Order {

    protected static Scanner input = new Scanner(System.in);

    protected Order() {}

    /**
     * asks the user if they still want to continue ordering
     * @return true if yes, otherwise false
     */
    protected static boolean askStillContinue() {

        // Prompts user if they have purchased enough
        System.out.print("Do you still want to order more? (y/n)");
        char option1 = input.next().charAt(0);

        if (String.valueOf(option1).equalsIgnoreCase("n")) {
            return false;
        }

        return true;
    }
}
