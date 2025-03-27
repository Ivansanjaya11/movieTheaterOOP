public class FoodStaff extends Staff {
    
    public FoodStaff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {
        super(employeeName, employeeId, hourlyRate, schedule);
    }

    public void addNewFoodPayment(FoodPayment foodPayment, Food foodItem, byte quantity) {
        foodPayment.addMenu(foodItem, quantity);
        System.out.println("Item added: " + foodItem.getMenuName() + " x" + quantity);
    }

    public void chooseFood(FoodPayment foodPayment) {
        System.out.println("Choosing food...";)
    }

    public String getEmployeeRoles() {
        return "Concession Stand";
    }

    public void setEmployeeRoles(String roleDescription) {
        System.out.println("Employee Role: " + roleDescription);
    }
}
