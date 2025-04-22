package stage4.util;

public class LogType {
    private LogType() {}

    private static final String addition = " - Addition";
    private static final String removal = " - Removal";
    private static final String update = " - Update";

    private static final String exist = " - Exist";
    private static final String not_exist = " - Not exist";

    private static final String receipt = " - Receipt";

    public static String NEW_STAFF = "STAFF" + addition;
    public static String REMOVE_STAFF = "STAFF" + removal;
    public static String UPDATE_STAFF = "STAFF" + update;
    public static String EXIST_STAFF = "STAFF" + exist;
    public static String NOT_EXIST_STAFF = "STAFF" + not_exist;

    public static String NEW_MOVIE = "MOVIE" + addition;
    public static String REMOVE_MOVIE = "MOVIE" + removal;
    public static String UPDATE_MOVIE = "MOVIE" + update;
    public static String EXIST_MOVIE = "MOVIE" + exist;
    public static String NOT_EXIST_MOVIE = "MOVIE" + not_exist;

    public static String NEW_SCREEN = "SCREEN" + addition;
    public static String REMOVE_SCREEN = "SCREEN" + removal;
    public static String UPDATE_SCREEN = "SCREEN" + update;
    public static String EXIST_SCREEN = "SCREEN" + exist;
    public static String NOT_EXIST_SCREEN = "SCREEN" + not_exist;

    public static String NEW_SHOWTIME = "SHOWTIME" + addition;
    public static String REMOVE_SHOWTIME = "SHOWTIME" + removal;
    public static String UPDATE_SHOWTIME = "SHOWTIME" + update;
    public static String EXIST_SHOWTIME = "SHOWTIME" + exist;
    public static String NOT_EXIST_SHOWTIME = "SHOWTIME" + not_exist;

    public static String NEW_FOOD = "MENU" + addition;
    public static String REMOVE_FOOD = "MENU" + removal;
    public static String UPDATE_FOOD = "MENU" + removal;
    public static String EXIST_FOOD = "MENU" + exist;
    public static String NOT_EXIST_FOOD = "MENU" + not_exist;

    public static String NEW_ITEM = "ITEM" + addition;
    public static String REMOVE_ITEM = "ITEM" + removal;
    public static String UPDATE_ITEM = "ITEM" + update;
    public static String EXIST_ITEM = "ITEM" + exist;
    public static String NOT_EXIST_ITEM = "ITEM" + not_exist;

    public static String ORDER_ITEM = "ITEM" + " - Order";

    public static String TICKET_PAYMENT = "PAYMENT" + " - Ticket";
    public static String FOOD_PAYMENT = "PAYMENT" + " - Food";

    public static String TICKET_RECEIPT = "TICKET" + receipt;
    public static String FOOD_RECEIPT = "MENU" + receipt;

    public static String SEATING_CREATE = "SEATING" + " - Creation";

    public static String SYSTEM = "SYSTEM";

    public static String INVALID = "INVALID";
    public static String ERROR = "ERROR";
}
