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

    /**
     * method to add trailing whitespace for formatting
     * @param str the string to be padded with extra whitespace
     * @param intendedWidth the width of the column or space where the string is to be printed
     * @return the string with padded whitespace
     */
    public static String addWhitespace(String str, byte intendedWidth) {
        byte pad = (byte) (intendedWidth-str.length());

        for (int i=0; i<pad; i++) {
            str += " ";
        }

        return str;
    }
}
