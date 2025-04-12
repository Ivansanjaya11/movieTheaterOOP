/** This class represents a screen (room) within a movie theater
 * @author Logan Cordova
 */

public class Screen {

    private byte screenID;
    private String screenType;
    private final SeatingArrangement seating;

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
     * Returns screen ID
     * @return screen's ID
     */
    public byte getScreenID() {
        return screenID;
    }

    /**
     * Returns screen type
     * @return screen's type
     */
    public String getScreenType() {
        return screenType;
    }

    /**
     * Returns seating arrangement of screen
     * @return seating arrangement object
     */
    public SeatingArrangement getSeating() {
        return seating;
    }

    /**
     * Sets screen ID
     * @param screenID screen's ID
     */
    public void setScreenID(byte screenID) {
        this.screenID = screenID;
    }

    /**
     * Sets screen type
     * @param screenType screen's type
     */
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    /**
     * Returns a string representation of a screen within the movie theater with the Screen ID and Screen Type
     * @return screen string
     */
    @Override
    public String toString() {

        String str = "";

        str = str + "screen: #" + this.screenID;
        str = str + "; screen type: " + this.screenType;

        return str;
    }

}
