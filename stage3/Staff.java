public class Staff {

    protected String employeeName;
    protected byte employeeId;
    protected byte hourlyRate;
    protected byte hoursWorked;
    protected String schedule;

    public Staff(String employeeName,byte employeeId, byte hourlyRate, String schedule) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
        this.schedule = schedule;
        this.hoursWorked = 0;
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
        return (short)(hourlyRate * hoursWorked);
    }

    public String getSchedule() {
        return schedule;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setEmployeeId(byte employeeId) {
        this.employeeId = employeeId;
    }

    public void setHourlyrate(byte hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(byte hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setWeeklySalary(short salary) {
        this.salary = salary;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    
}
