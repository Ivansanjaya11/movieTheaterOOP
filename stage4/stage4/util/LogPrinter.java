package stage4.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LogPrinter {
    private static final byte logWidth = 20;

    private LogPrinter() {}

    public static void print(String logPrefixColor, String textColor, String logLabel, String text) {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        String newCurrentTime = "[" + currentTime + "]";

        System.out.print(logPrefixColor + newCurrentTime + Color.RESET);

        System.out.print(" ");

        String newLogLabel = PrettyPrinter.addWhitespace("[" + logLabel + "]", logWidth);
        System.out.print(logPrefixColor + newLogLabel + Color.RESET);

        System.out.print("  ");

        System.out.print(textColor + text + Color.RESET);
    }

    public static void println(String logPrefixColor, String textColor, String logLabel, String text) {
        print(logPrefixColor, textColor, logLabel, text);
        System.out.println();
    }
}
