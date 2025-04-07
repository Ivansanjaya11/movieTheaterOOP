/** This class represents a screen within a movie theater
 * @author Logan Cordova
 */

public class Screen {

    private byte screenID;
    private String screenType;
    private SeatingArrangement seating;

    /**
     * Constructs a Screen object
     * @param screenID - unique screen ID
     * @param screenType - type of screen
     */
    public Screen(byte screenID, String screenType) {
        this.screenID = screenID;
        this.screenType = screenType;
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

}
