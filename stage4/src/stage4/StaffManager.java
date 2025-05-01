package stage4;

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.util.Color;
import stage4.util.LogPrinter;
import stage4.util.LogType;
import stage4.util.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles movie staff members including adding and removing staff
 */

public class StaffManager {

    // Initializes list of staff members
    private static ArrayList<Staff> staffs = new ArrayList<>();

    private static final File staffFile = new File(Path.STAFF_DATA_PATH);

    static {

        if (staffFile.length() != 0) {

            try (BufferedReader reader = new BufferedReader(new FileReader(Path.STAFF_DATA_PATH))) {
               String line;

               while ((line = reader.readLine()) != null) {
                   String[] staffInfo = line.trim().split(",");

                   String staffName = staffInfo[0].trim();
                   byte staffId = Byte.parseByte(staffInfo[1].trim());
                   byte staffHourlyRate = Byte.parseByte(staffInfo[2].trim());
                   String staffSchedule = staffInfo[3].trim();

                   if (staffInfo[4].trim().equals("ticket")) {
                       staffs.add(new TicketStaff(staffName, staffId, staffHourlyRate, staffSchedule));
                       LogPrinter.println(Color.GREEN, Color.GREEN, LogType.NEW_STAFF,
                               "ticket staff '" + staffName + "' added from database!");

                       //System.out.println("ticket staff '" + staffName + "' added from database!");
                   } else {
                       staffs.add(new FoodStaff(staffName, staffId, staffHourlyRate, staffSchedule));
                       LogPrinter.println(Color.GREEN, Color.GREEN, LogType.NEW_STAFF,
                               "food staff '" + staffName + "' added from database!");
                       //System.out.println("food staff '" + staffName + "' added from database!");
                   }

               }

            } catch (IOException e) {
                LogPrinter.println(Color.RED, Color.RED, LogType.ERROR, e.getMessage());
                //System.err.println(e.getMessage());
            }

        }
    }

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

        if (!contains(staff.getEmployeeId())) {
            staffs.add(staff);

            LogPrinter.println(Color.GREEN, Color.GREEN, LogType.NEW_STAFF,
                    "staff '" + staff.getEmployeeName() + "' has been added!");
            //System.out.println("staff '" + staff.getEmployeeName() + "' has been added!");
            FilesUpdateManager.updateStaffDataFile(new ArrayList<>(staffs));
        } else {

            LogPrinter.println(Color.WHITE, Color.WHITE, LogType.EXIST_STAFF,
                    "staff '" + staff.getEmployeeName() + "' already exists!");
            //System.out.println("staff '" + staff.getEmployeeName() + "' already exists!");
        }

    }

    /**
     * Method to remove staff members from list
     * @param index of staff members
     */
    public static void removeStaff(byte index) {
        if (hasStaffs()) {
            Staff staffToBeRemoved = staffs.get(index);
            staffs.remove(index);
            FilesUpdateManager.updateStaffDataFile(new ArrayList<>(staffs));

            LogPrinter.println(Color.CYAN, Color.CYAN, LogType.REMOVE_STAFF,
                    "staff '" + staffToBeRemoved.getEmployeeName() + "' removed!");
            //System.out.println("staff '" + staffToBeRemoved.getEmployeeName() + "' removed!");
        } else {
            LogPrinter.println(Color.WHITE, Color.WHITE, LogType.NOT_EXIST_STAFF, "staff list is empty!");
        }
    }

    /**
     * updates the staff in the staff list
     * @param index the position of the staff in the list
     * @param staff the new staff to replace the old one
     */
    public static void updateStaff(byte index, Staff staff) {
        staffs.set(index, staff);

        LogPrinter.println(Color.MAGENTA, Color.MAGENTA, LogType.UPDATE_STAFF,
                "staff '" + staff.getEmployeeName() + "' updated!");
    }


    public static Staff searchStaff(byte staffId) {
        for (Staff staff : staffs) {
            if (staff.getEmployeeId() == staffId) {
                LogPrinter.println(Color.WHITE, Color.WHITE, LogType.EXIST_STAFF, staff.getEmployeeName() + " found!");
                return staff;
            }
        }

        LogPrinter.println(Color.WHITE, Color.WHITE, LogType.NOT_EXIST_STAFF, "staff not found!");
        System.out.println("staff not found!");
        return null;
    }

}
