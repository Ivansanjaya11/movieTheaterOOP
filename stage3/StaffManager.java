import java.util.ArrayList;

public class StaffManager {
    private static ArrayList<Staff> staffs = new ArrayList<>();

    public static ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public static boolean contains(byte id) {
        for (Staff staff : staffs) {
            if (staff.getEmployeeId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasStaffs() {
        return !staffs.isEmpty();
    }

    public static void addStaff(Staff staff) {
        staffs.add(staff);
    }

    public static void removeStaff(byte index) {

    }

}
