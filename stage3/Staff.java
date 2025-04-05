import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Staff {

    protected String employeeName;
    protected byte employeeId;
    protected byte hourlyRate;
    protected byte hoursWorked;
    protected String schedule;
    protected String role;

    private Analytics analytics;

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

    public String getEmployeeName() {
        return employeeName;
    }

    public short getEmployeeId() {
        return employeeId;
    }

    public byte getHourlyRate() {
        return hourlyRate;
    }

    public byte getHoursWorked() {
        return hoursWorked;
    }

    public short getWeeklySalary() {
        return (short)(hourlyRate * hoursWorked); //to confirm; remove this method as its not needed?
    }

    public String getSchedule() {
        return schedule;
    }

    public String getRole() {
        return role;
    }

    public Analytics getAnalytics() {
        return analytics;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeId(byte employeeId) {
        this.employeeId = employeeId;
    }

    public void setHourlyRate(byte hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
        this.hoursWorked = calculateWeeklyHours(schedule);
    } 
    
    public void setRole(String role) {
        this.role = role;
    }

    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }
}
