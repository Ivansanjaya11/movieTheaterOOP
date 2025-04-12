/**
 * @author Heather Santos
 */


import util.PrettyPrinter;

/**
 * Represents a concession stand staff member 
 */

public class FoodStaff extends Staff {

     /**
     * Constructs a new FoodStaff object with the given employee details
     * @param employeeName the name of the employee
     * @param employeeId the ID of the employee
     * @param hourlyRate the hourly rate of the employee
     * @param schedule the work schedule in HH:mm-HH:mm format
     */
    public FoodStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {

        super(employeeName, employeeId, hourlyRate, schedule);
        this.role = "Concession Stand";
    }

    /**
     * Creates and adds a new FoodPayment for a customer
     * Auto invokes food selection
     * @param customer the customer placing the food order
     */
    public void addNewFoodPayment(Customer customer) {

        FoodPayment foodPayment = new FoodPayment(customer);
        boolean isSuccessful = foodPayment.chooseFood();

        if (isSuccessful) {
           System.out.println("Transaction completed!");
        }

        PrettyPrinter.printDashLine((short) 40);
    }

}
