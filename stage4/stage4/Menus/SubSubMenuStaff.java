package stage4.Menus;

import stage4.FoodStaff;
import stage4.Staff;
import stage4.StaffManager;
import stage4.TicketStaff;

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
            System.out.println("stage4.TicketRelated.stage4.Staff with id " + id + " already exists");
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
            System.out.println("stage4.TicketRelated.stage4.Staff does not exist!");
        }
    }

    /**
     * updates staff from staff menu
     */
    public static void updateStaffMenu() {
        //Ensures the staff list has staff members
        if (!StaffManager.hasStaffs()) {
            System.out.println("No staff available!");
            return ;
        }

        System.out.println("Which staff do you want to update: ");
        byte index;

        for (int i=1; i<=StaffManager.getStaffs().size(); i++) {
            System.out.println(i + ". " + StaffManager.getStaffs().get(i-1).getEmployeeName());
        }

        index = input.nextByte();
        input.nextLine();
        index -=1;

        System.out.print("Enter staff name: ");
        String employeeName = input.nextLine();

        System.out.print("Enter new employee ID (0–127): ");
        byte employeeId = input.nextByte();
        input.nextLine();

        System.out.print("Enter new hourly rate (0–127): ");
        byte hourlyRate = input.nextByte();
        input.nextLine();

        System.out.print("Enter new work schedule (HH:mm-HH:mm): ");
        String schedule = input.nextLine();

        System.out.print("Enter staff role (ticket/food): ");
        String staffRole = input.nextLine();

        if (staffRole.equals("ticket")) {
            StaffManager.updateStaff(index, new TicketStaff(employeeName, employeeId, hourlyRate, schedule));
        } else {
            StaffManager.updateStaff(index, new FoodStaff(employeeName, employeeId, hourlyRate, schedule));
        }
    }

    /**
     * Displays staff members currently working within the movie theater
     */

    public static void displayStaff() {
        for (Staff staff : StaffManager.getStaffs()) {
            System.out.println(staff);
        }
    }

    public static void searchStaffMenu() {
        System.out.print("Enter the id of the staff you're searching for: ");
        byte staffId = input.nextByte();
        input.nextLine();

        Staff staff = StaffManager.searchStaff(staffId);

        if (staff != null) {
            System.out.println("id #" + staffId + " as " + staff);
            System.out.println("\thourly rate: $" + staff.getHourlyRate());
            System.out.println("\ttotal working hours (weekly): " + staff.getHoursWorked() + " hours");
            System.out.println("\tschedule: " + staff.getSchedule());
        }
    }

}
