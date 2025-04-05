import java.util.ArrayList;

public class FoodStaff extends Staff {
    private static MenuManager menuManager;
    private ArrayList<FoodPayment> foodPayments;

    static {
        menuManager = new MenuManager();
    }
    
    public FoodStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {
        super(employeeName, employeeId, hourlyRate, schedule);
        this.role = "Concession Stand";
        this.foodPayments = new ArrayList<>();
    }

    public void addNewFoodPayment(Customer customer) {
        FoodPayment foodPayment = new FoodPayment(customer);
        foodPayment.chooseFood();
        foodPayments.add(foodPayment);
    }

    public void clearOrderHistory() {
        foodPayments.clear();
    }

    public ArrayList<FoodPayment> getOrderHistory() {
        return foodPayments;
    }
}
