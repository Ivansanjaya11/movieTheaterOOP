package util;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Util class containing methods to help with pretty printing/writing
 */

public class PrettyPrinter {
    private PrettyPrinter() {}

    /**
     * prints dashes of a certain width on the console
     * @param width number of dashes
     */
    public static void printDashLine(short width) {
        for(int i=0; i<width; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    /**
     * writes dashes of a certain width to a .txt file
     * @param writer BufferedWriter object
     * @param width number of dashes
     */
    public static void writeDashLine(BufferedWriter writer, short width) throws IOException {
        for (int i=0; i<width; i++) {
            writer.write("-");
        }

        writer.newLine();
    }
}
