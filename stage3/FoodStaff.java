/**
 * @author Heather Santos
 */

import java.util.ArrayList;

/**
 * Represents a concession stand staff member 
 */

public class FoodStaff extends Staff {
    private static MenuManager menuManager;
    private ArrayList<FoodPayment> foodPayments;
    
    //static initializer to initialize the sharded MenuManager
    static {
        menuManager = new MenuManager();
    }

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
        this.foodPayments = new ArrayList<>();
    }

    /**
     * Gets the shared MenuManager instance
     * @return the MenuManager
     */

    public MenuManager getMenuManager() {
        return FoodStaff.menuManager;
    }

    /**
     * Sets a MenuManager instance
     * @param menuManager the new Menu Manager to assign
     */

    public void setMenuManager(MenuManager menuManager) {
        FoodStaff.menuManager = menuManager;
    }

    /**
     * Creates and adds a new FoodPayment for a customer
     * Auto invokes food selection
     * @param customer the customer placing the food order
     */

    public void addNewFoodPayment(Customer customer) {
        FoodPayment foodPayment = new FoodPayment(customer);
        foodPayment.chooseFood();
        this.foodPayments.add(foodPayment);
    }

    /**
     * Clears the entire order history for this food staff member
     */

    public void clearOrderHistory() {
        this.foodPayments.clear();
    }

    /**
     * Retrieves the list of all food payments made
     * @return the list of FoodPayment objects
     */

    public ArrayList<FoodPayment> getOrderHistory() {
        return this.foodPayments;
    }
}
