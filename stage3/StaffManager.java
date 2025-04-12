import java.util.ArrayList;


/**
 * Handles movie staff members including adding and removing staff
 */

public class StaffManager {

    // Initializes list of staff members
    private static ArrayList<Staff> staffs = new ArrayList<>();

    /**
     * Constructs staff list
     * @return list of staff members
     */

    public static ArrayList<Staff> getStaffs() {
        return new ArrayList<>(staffs);
    }

    /**
     * Checks if staff ID exists in staff member list
     * @param id staff ID
     * @return true / false
     */

    public static boolean contains(byte id) {
        for (Staff staff : staffs) {
            if (staff.getEmployeeId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ensures the staff member list has staff members
     * @return if the list is empty or not
     */

    public static boolean hasStaffs() {
        return !staffs.isEmpty();
    }

    /**
     * Method to add staff members to list
     * @param staff members to add
     */

    public static void addStaff(Staff staff) {
        staffs.add(staff);
    }

    /**
     * Method to remove staff members from list
     * @param index of staff members
     */

    public static void removeStaff(byte index) {
        staffs.remove(index);
    }

}
