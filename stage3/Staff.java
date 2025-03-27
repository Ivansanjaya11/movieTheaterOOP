public class Staff {

    protected String employeeName;
    protected byte employeeId;
    protected byte hourlyRate;
    protected byte hoursWorked;
    protected String schedule;
    protected Analytics analytics;

    public Staff(String employeeName,byte employeeId, byte hourlyRate, String schedule) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
        this.schedule = schedule;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public short getEmployeeId() {
        return employeeId;
    }

    public short getWeeklySalary() {
        return (short) (hourlyRate * hoursWorked);
    }

    public String getSchedule() {
        return schedule;
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

    public void setWeeklySalary(byte hourlyRate, byte hoursWorked) {
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public void setWeeklySalary(short salary) {
        this.salary = salary;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setAnalytics(Analytics analytics) {
        this.analytics = analytics;
    }
}
