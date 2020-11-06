//CurrencyDriver.java
// This program is working and complete.
package util1228;

import java.util.Scanner;

/**
 *
 * @author akshu
 */
public class Utilities {

    /**
     * This method pauses the program.
     *
     * @param s String s Prompts user to press enter.
     */
    public static void pause(String s) {
        Scanner kbd = new Scanner(System.in);
        System.out.print(s);
        kbd.nextLine();

    }

    /**
     * Another pause method.(Overloaded method).
     */
    public static void pause() {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Press enter to continue....");
        kbd.nextLine();
    }

    /**
     * This method displays info about the program and the programmer.
     *
     * @param name Name of the program writer.
     * @param aNum ANumber of the program writer.
     * @param assignment Assignment Number.
     * @param s Information about the program.
     */
    public static void displayInfo(String name, String aNum, String assignment,
            String s) {
        System.out.println(name + "\n"
                + aNum + "\n"
                + "Assignment" + assignment + "\n"
                + s + "\n\n");

    }
}
