/**
 * @author Heather Santos
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Represents a staff member in a movie theater
 * Stores employee details, work schedule, and analytics
 */


public class Staff {

    private String employeeName;
    private byte employeeId;
    private byte hourlyRate;
    protected byte hoursWorked;
    private String schedule;
    protected String role;

    private Analytics analytics;

    /**
     * Constructs a new staff object with the given details
     * @param employeeName the name of the staff member
     * @param employeeId the ID of the staff member
     * @param hourlyRate the hourly pay rate for the staff member
     * @param schedule the weekly schedule in HH:mm-HH:mm format
     */

    public Staff(String employeeName, byte employeeId, byte hourlyRate, String schedule) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
        this.schedule = schedule;
        this.hoursWorked = calculateWeeklyHours(schedule);
        this.role = "Unassigned";
        this.analytics = new Analytics();

        this.hoursWorked = calculateWeeklyHours(schedule);
    }

    /**
     * Calculates total weekly hours worked based on daily schedule
     * @param scheduleStr the schedule string in HH:mm-HH:mm format
     * @return total weekly hours worked, assuming 5 work days
     */

    private byte calculateWeeklyHours(String scheduleStr) {
        try {
            String[] parts = scheduleStr.split("-");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            LocalTime start = LocalTime.parse(parts[0], formatter);
            LocalTime end = LocalTime.parse(parts[1], formatter);

            long hoursPerDay = ChronoUnit.HOURS.between(start, end);
            return (byte)(hoursPerDay * 5);
        } catch (Exception e) {
            System.out.println("Invalid schedule format. Expected HH:mm-HH:mm.");
            return 0;
        }
    }

    /**
     * 
     * @return the employees name
     */

    public String getEmployeeName() {
        return this.employeeName;
    }

    /**
     * 
     * @return the employees ID
     */

    public short getEmployeeId() {
        return this.employeeId;
    }

    /**
     * 
     * @return the hourly rate
     */

    public byte getHourlyRate() {
        return this.hourlyRate;
    }

    /**
     * 
     * @return total hours worked per week
     */

    public byte getHoursWorked() {
        return this.hoursWorked;
    }

    /**
     * Calculates and returns weekly salary
     * @return the calculated weekly salary
     */

    public short getWeeklySalary() {
        return (short)(this.hourlyRate * this.hoursWorked); 
    }

    /**
     * 
     * @return the schedule string
     */

    public String getSchedule() {
        return this.schedule;
    }

    /**
     * 
     * @return the role assigned to a staff member
     */

    public String getRole() {
        return this.role;
    }

    /**
     * 
     * @return the analytics object linked to a staff member
     */

    public Analytics getAnalytics() {
        return this.analytics;
    }

    /**
     * Sets the employee name
     * @param employeeName the new name
     */

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Sets the employee ID
     * @param employeeId the new ID
     */

    public void setEmployeeId(byte employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Sets the hourly rate
     * @param hourlyRate the new hourly rate
     */

    public void setHourlyRate(byte hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Updates the employees schedule and recalculates hours worked
     * @param schedule the new schedule in HH:mm-HH:mm format
     */

    public void setSchedule(String schedule) {
        this.schedule = schedule;
        this.hoursWorked = calculateWeeklyHours(schedule);
    } 

    /**
     * Sets the employee role
     * @param role the new role
     */
    
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Sets a new analytics object
     * @param analytics the analytics object to assign
     */

    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }
}
