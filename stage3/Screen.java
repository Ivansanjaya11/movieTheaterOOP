/** This class represents a screen within a movie theater
 * @author Logan Cordova
 */

public class Screen {

    private byte screenID;
    private String screenType;
    private TimeSchedule startTime;
    private TimeSchedule endTime;
    private SeatingArrangement seating;

    /**
     * Constructs a Screen object
     * @param screenID - unique screen ID
     * @param screenType - type of screen
     * @param startTime - start time of screening
     * @param endTime - end time of screening
     */
    public Screen(byte screenID, String screenType, TimeSchedule startTime, TimeSchedule endTime) {
        this.screenID = screenID;
        this.screenType = screenType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seating = new SeatingArrangement();
    }

    /**
     * Returns screen iD
     * @return
     */
    public byte getScreenID() {
        return screenID;
    }

    /**
     * Retruns screen type
     * @return
     */
    public String getScreenType() {
        return screenType;
    }

    /**
     * Returns start time of screening
     * @return
     */
    public TimeSchedule getStartTime() {
        return startTime;
    }

    /**
     * Returns end time of screening
     * @return
     */
    public TimeSchedule getEndTime() {
        return endTime;
    }

    /**
     * Returns seating arrangement of screen
     * @return
     */
    public SeatingArrangement getSeating() {
        return seating;
    }

    /**
     * Sets screen ID
     * @param screenID
     */
    public void setScreenID(byte screenID) {
        this.screenID = screenID;
    }

    /**
     * Sets screen type
     * @param screenType
     */
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    /**
     * Sets screening start time
     * @param startTime
     */
    public void setStartTime(TimeSchedule startTime) {
        this.startTime = startTime;
    }

    /**
     * Sets screening end time
     * @param endTime
     */
    public void setEndTime(TimeSchedule endTime) {
        this.endTime = endTime;
    }

}
