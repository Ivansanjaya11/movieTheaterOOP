import java.util.Scanner;

public class SubSubMenuStaff {
    private static final Scanner input = new Scanner(System.in);

    /**
     * Adds staff to staff menu list
     */

     public static void addStaffMenu() {

        // Prompts user to enter staff information:
        System.out.print("Enter staff id: ");
        byte id = input.nextByte();
        input.nextLine();

        System.out.print("Enter staff name: ");
        String name = input.nextLine();

        System.out.print("Enter hourly rate: ");
        byte rate = input.nextByte();
        input.nextLine();

        System.out.print("Enter schedule (HH:mm-HH:mm): ");
        String schedule = input.nextLine();

        String role = Prompt.askStaffRole();

        // Checks if staff has given staff ID
        if (!StaffManager.contains(id)) {
            if (role.equals("ticket")) {
                StaffManager.addStaff(new TicketStaff(name, id, rate, schedule));
            } else if (role.equals("food")) {
                StaffManager.addStaff(new FoodStaff(name, id, rate, schedule));
            } else {
                System.out.println("Invalid role");
            }
        } else {
            System.out.println("Item with id " + id + " already exists");
        }
    }

    /**
     * Removes staff from staff menu list
     */

    public static void removeStaffMenu() {

        //Ensures the staff list has staff members
        if (!StaffManager.hasStaffs()) {
            System.out.println("No staff available!");
            return ;
        }

        System.out.println("Which staff do you want to fire: ");
        byte index;

        for (int i=1; i<=StaffManager.getStaffs().size(); i++) {
            System.out.println(i + ". " + StaffManager.getStaffs().get(i-1).getEmployeeName());
        }

        index = input.nextByte();
        input.nextLine();
        index -=1;

        if (index >=0 && index < StaffManager.getStaffs().size()) {
            StaffManager.removeStaff(index);
        } else {
            System.out.println("Staff does not exist!");
        }
    }

    public static void displayStaff() {
        for (Staff staff : StaffManager.getStaffs()) {
            System.out.println(staff);
        }
    }

}
