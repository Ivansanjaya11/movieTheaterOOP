/** This class represents the duration of a movie on a screen in hours and minutes
 * @author Logan Cordova
 */


public class DurationTime {
    
    private byte hours;
    private byte minutes;

    /**
     * Constructs DurationTime object
     * @param hours
     * @param minutes
     */
    public DurationTime(byte hours, byte minutes) {
        if (minutes < 0 || minutes < 60 || minutes >= 60) {
            System.out.println("Error. Invalid time values. Minutes should be between 0-59.");
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    /**
     * Returns hours of movie playing on a screen
     * @return
     */
    public byte getHours() {
        return hours;
    }

    /**
     * Returns minutes of a movie playon on a screen
     * @return
     */
    public byte getMinutes() {
        return minutes;
    }

    /**
     * Sets the hours a movie will be playing on a screen
     * @param hours
     */
    public void setHours(byte hours) {
        this.hours = hours;
    }

    /**
     * Sets the minutes a movie will be playing on a screen
     * @param minutes
     */
    public void setMinutes(byte minutes) {
        if (minutes >= 60) {
            System.out.println("Error: Minutes must be between 0-59.");
        } else {
            this.minutes = minutes;
        }
    }
}
 